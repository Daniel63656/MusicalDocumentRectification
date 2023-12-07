package net.scoreworks.omr.parsing;

import jakarta.xml.bind.JAXBException;
import net.scoreworks.music.model.*;
import net.scoreworks.music.utils.Fraction;
import net.scoreworks.omr.parsing.antlr.MusicScriptLexer;
import net.scoreworks.omr.parsing.antlr.MusicScriptListener;
import net.scoreworks.omr.parsing.antlr.MusicScriptParser;
import net.scoreworks.xml.XmlExport;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Interpreter implements MusicScriptListener {
    private final Score score = new Score();
    private final Track track;
    private int currentStaffId;
    private Fraction currentTick = Fraction.ZERO, barStartTick = Fraction.ZERO;
    private final List<Voice> activeVoices = new ArrayList<>();
    private final List<Voice> currentVoices = new ArrayList<>();
    private final List<Note> pendingTies = new ArrayList<>();
    private final Map<Voice, NoteGroupOrRest> pendingBeams = new HashMap<>();
    private final Map<Integer, Map<Integer, Accidental>> pendingAccidentals = new HashMap<>();

    public Interpreter() {
        track = new Track(score);
        new Staff(track, 0);
        new Staff(track, 1);
        for (Staff staff : track.getStaffs()) {
            new TonalityRange(staff, currentTick, Tonality.Cmajor); // no visual signs is C major by default
            //TODO no time signature at system breaks, read system by system and keep time
            new TimeSignatureRange(staff, currentTick, new TimeSignature(4, 4));
            pendingAccidentals.put(staff.getKey(), new HashMap<>());
        }
    }

    public Score getScore() {
        return score;
    }

    @Override
    public void enterScore(MusicScriptParser.ScoreContext ctx) {}
    @Override
    public void exitScore(MusicScriptParser.ScoreContext ctx) {}
    @Override
    public void enterEvent(MusicScriptParser.EventContext ctx) {}
    @Override
    public void exitEvent(MusicScriptParser.EventContext ctx) {
        //calculate voice demand of this event
        int voiceDemand = 0;
        for (MusicScriptParser.StaffContext staffCtx : ctx.staff()) {
            voiceDemand += staffCtx.group().size();
        }
        //create a new list of current voices sorted by the offset tick
        currentVoices.clear();
        currentVoices.addAll(activeVoices);
        currentVoices.sort(Comparator.comparing(Voice::getEnd)); //this keeps insertion order for elements with same tick
        //check for new voices and register them AFTER sorting as they have no duration
        int currentVoiceIndex = 0;
        for (MusicScriptParser.StaffContext staffCtx : ctx.staff()) {
            for (MusicScriptParser.GroupContext groupCtx : staffCtx.group()) {
                if (groupCtx.NEWV() != null)
                    newVoice(currentVoiceIndex);
                if (currentVoiceIndex >= currentVoices.size()) {
                    newVoice(currentVoiceIndex);
                    System.out.printf("Missing voice start inserted at %s%n", currentTick.toString());
                }
                currentVoiceIndex++;
            }
        }
        if (voiceDemand > currentVoices.size())
            throw new RuntimeException(String.format("Not enough voices at tick = %s. Expected %d, found %d", currentTick, voiceDemand, currentVoices.size()));
        //advance current tick to be the greatest offset tick of demanded voices
        for (int i=voiceDemand-1; i>=0; i--) {
            Voice voice = currentVoices.get(i);
            if (voice.getNoteGroupOrRests().isEmpty() || voice.getEnd().compareTo(currentTick) < 0)
                continue;   //skip new (empty) and recycled voices
            currentTick = voice.getEnd();
            break;
        }
        //finally, dispatch the event
        dispatchEvent(ctx);
    }

    @Override
    public void enterStaff(MusicScriptParser.StaffContext ctx) {}
    @Override
    public void exitStaff(MusicScriptParser.StaffContext ctx) {}
    @Override
    public void enterGroup(MusicScriptParser.GroupContext ctx) {}
    @Override
    public void exitGroup(MusicScriptParser.GroupContext ctx) {}
    @Override
    public void enterRest(MusicScriptParser.RestContext ctx) {}
    @Override
    public void exitRest(MusicScriptParser.RestContext ctx) {}
    @Override
    public void enterChord(MusicScriptParser.ChordContext ctx) {}
    @Override
    public void exitChord(MusicScriptParser.ChordContext ctx) {}
    @Override
    public void enterNote(MusicScriptParser.NoteContext ctx) {}
    @Override
    public void exitNote(MusicScriptParser.NoteContext ctx) {}
    @Override
    public void enterAccidental(MusicScriptParser.AccidentalContext ctx) {}
    @Override
    public void exitAccidental(MusicScriptParser.AccidentalContext ctx) {}
    @Override
    public void enterTime(MusicScriptParser.TimeContext ctx) {}
    @Override
    public void exitTime(MusicScriptParser.TimeContext ctx) {}
    @Override
    public void enterKey(MusicScriptParser.KeyContext ctx) {}
    @Override
    public void exitKey(MusicScriptParser.KeyContext ctx) {}
    @Override
    public void enterOttavastart(MusicScriptParser.OttavastartContext ctx) {}
    @Override
    public void exitOttavastart(MusicScriptParser.OttavastartContext ctx) {}
    @Override
    public void enterOttavaend(MusicScriptParser.OttavaendContext ctx) {}
    @Override
    public void exitOttavaend(MusicScriptParser.OttavaendContext ctx) {}
    @Override
    public void visitTerminal(TerminalNode node) {
        //String type = MusicScriptLexer.VOCABULARY.getSymbolicName(node.getSymbol().getType()); if (type == null) return;
    }
    @Override
    public void visitErrorNode(ErrorNode node) {}
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {}
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {}


    private void dispatchEvent(MusicScriptParser.EventContext ctx) {
        int currentVoiceIndex = 0;  //point to the location of next voice to add a group to in urgentVoices
        if (ctx.BARL() != null) {
            //handle irregular bars / up beats
            Fraction realBarDuration = currentTick.subtract(barStartTick);
            for (Staff staff : track.getStaffs()) {
                Bar currentBar = staff.getBar(barStartTick);
                if (realBarDuration.compareTo(currentBar.getDuration()) != 0) {
                    TimeSignatureRange tsr = currentBar.getOwner();
                    //make first in TimeSignatureRange if not already
                    if (currentBar.getKey() != 0)
                        tsr = new TimeSignatureRange(staff, currentTick, tsr.getTimeSignature());
                    tsr.setUpBeatCorrect(realBarDuration.subtract(currentBar.getDuration()));
                }
            }
            //reset bar specific pending collections
            pendingBeams.clear();
            pendingAccidentals.clear();
            for (Staff staff : track.getStaffs()) {
                pendingAccidentals.put(staff.getKey(), new HashMap<>());
            }
            barStartTick = currentTick;
        }
        currentStaffId = ctx.STAFF().getText().equals("T") ? 0 : 1;

        for (int i=0; i<ctx.staff().size(); i++) {
            MusicScriptParser.StaffContext staffCtx = ctx.staff(i);
            if (i == 1) {
                if (currentStaffId == 1)
                    throw new RuntimeException(String.format("Can not staff change if already in bass at %s", currentTick));
                currentStaffId = 1;
            }
            if (staffCtx.CLEF() != null) {
                String value = staffCtx.CLEF().getText();
                switch (value) {
                    case "G" -> new ClefRange(track.getStaff(currentStaffId), currentTick, Clef.TREBLE);
                    case "F" -> new ClefRange(track.getStaff(currentStaffId), currentTick, Clef.BASS);
                    default -> throw new RuntimeException(String.format("Clef %s not recognized", value));
                }
            }
            if (staffCtx.time() != null) {
                if (staffCtx.time().SLASH() != null) {
                    int slashLocation = staffCtx.time().SLASH().getSymbol().getStartIndex();
                    StringBuilder numerator = new StringBuilder();
                    StringBuilder denominator = new StringBuilder();
                    for (TerminalNode digit : staffCtx.time().DIGIT()) {
                        if (digit.getSymbol().getStartIndex() < slashLocation)
                            numerator.append(digit.getText());
                        else denominator.append(digit.getText());
                    }
                    new TimeSignatureRange(track.getStaff(currentStaffId), currentTick, new TimeSignature(Integer.parseInt(numerator.toString()), Integer.parseInt(denominator.toString())));
                }
                else {
                    String value = staffCtx.time().getText();
                    if (value.equals("c"))
                        new TimeSignatureRange(track.getStaff(currentStaffId), currentTick, TimeSignature.createAllaSemibrevis());
                    if (value.equals("/c"))
                        new TimeSignatureRange(track.getStaff(currentStaffId), currentTick, TimeSignature.createAllaBreve());
                }
            }
            if (staffCtx.key() != null) {
                MusicScriptParser.KeyContext keyCtx = staffCtx.key();
                int fifths = 0;     // default/naturals
                if (!keyCtx.SHARP().isEmpty())
                    fifths = keyCtx.SHARP().size();
                else if (!keyCtx.FLAT().isEmpty())
                    fifths = -keyCtx.FLAT().size();
                new TonalityRange(track.getStaff(currentStaffId), currentTick, Tonality.fromFifths(fifths, MajorMinor.Major));
                // reset active accidentals on that staff
                pendingAccidentals.put(currentStaffId, new HashMap<>());
            }

            for (MusicScriptParser.GroupContext groupCtx : staffCtx.group()) {
                if (groupCtx.rest() != null) {
                    MusicScriptParser.RestContext restCtx = groupCtx.rest();
                    NoteType noteType = NoteType.fromExponent(-Integer.parseInt(restCtx.REST().getText().substring(1)));
                    Voice voice = currentVoices.get(currentVoiceIndex);
                    //handle the case rest is first in bar, whole and too long for bar -> whole appearance but different duration
                    //currently bar duration can only be estimated to be normal, so these rests are only allowed to happen in normal bars
                    //TODO overcome or remove Liebestraum
                    Rest rest;
                    TimeSignature timeSignature = track.getStaff(currentStaffId).getTimeSignatureRange(currentTick).getTimeSignature();
                    if (currentTick.compareTo(barStartTick) == 0 && noteType == NoteType.WHOLE && timeSignature.getFraction().compareTo(Fraction.ONE) < 0)
                        rest = new Rest(currentTick, voice, track.getStaff(currentStaffId), timeSignature.getFraction());
                    //or normal rest
                    else rest = new Rest(currentTick, voice, track.getStaff(currentStaffId), noteType, restCtx.DOT().size());
                    if (restCtx.BEAM() != null)
                        processBeam(voice, rest, restCtx.BEAM().getText());
                    currentVoiceIndex++;
                }
                else if (groupCtx.chord() != null) {
                    MusicScriptParser.ChordContext chordCtx = groupCtx.chord();
                    NoteType noteType = NoteType.QUARTER;
                    if (chordCtx.WHOLE() != null)
                        noteType = NoteType.WHOLE;
                    else if (chordCtx.HALF() != null)
                        noteType = NoteType.HALF;
                    if (chordCtx.FLAG() != null) {
                        noteType = NoteType.fromExponent(-Integer.parseInt(chordCtx.FLAG().getText().substring(1)) - 2);
                    }

                    //parse notes
                    NoteGroup noteGroup = null;
                    for (MusicScriptParser.NoteContext noteCtx : chordCtx.note()) {
                        Accidental accidental = Accidental.NONE;
                        if (noteCtx.accidental() != null) {
                            switch (noteCtx.accidental().getText()) {
                                case "#", "b", "n", "x" -> accidental = Accidental.fromString(noteCtx.accidental().getText());
                                case "-" -> accidental = Accidental.FLAT_FLAT;
                            }
                        }
                        int referenceLine = Integer.parseInt(noteCtx.LINE().getText().substring(1));
                        referenceLine -= track.getStaff(currentStaffId).getClefRange(currentTick).getClef().getC0_referenceLine();
                        OctaveShiftRange osr = track.getStaff(currentStaffId).getOctaveShiftRange(currentTick);
                        if (osr != null)
                            referenceLine -= osr.getOctavation().getShiftOctaves()*7;
                        NoteName name = NoteName.values()[referenceLine % 7];
                        OctaveRegion octave = OctaveRegion.fromNumber(referenceLine / 7);
                        if (accidental != Accidental.NONE) pendingAccidentals.get(currentStaffId).put(name.noteLineId(octave), accidental);
                        // instantiate Notes and NoteGroup
                        Note note;
                        if (noteGroup == null) {
                            Voice voice = currentVoices.get(currentVoiceIndex);
                            note = new Note(currentTick, voice, track.getStaff(currentStaffId), noteType, chordCtx.DOT().size(), calculatePitch(name, octave, accidental), name, octave, accidental);
                            noteGroup = note.getOwner();
                            if (chordCtx.STEM() != null)
                                noteGroup.setStem(chordCtx.STEM().getText().equals("u") ? Stem.UP : Stem.DOWN);
                            if (chordCtx.BEAM() != null)
                                processBeam(voice, noteGroup, chordCtx.BEAM().getText());
                            currentVoiceIndex++;
                        }
                        else
                            note = new Note(noteGroup, calculatePitch(name, octave, accidental), name, octave, accidental);
                        if (noteCtx.TIE_START() != null)
                            pendingTies.add(note);
                        if (noteCtx.TIE_END() != null && !linkNotes(note))
                            System.out.printf("Ignored erroneous tie at %s%n", currentTick.toString());
                    }
                }
                if (groupCtx.VEND() != null)
                    activeVoices.remove(currentVoices.get(currentVoiceIndex-1));
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        if (args.length < 2) {
            System.out.println("Please provide sentence and output file path");
            return;
        }
        MusicScriptLexer lexer = new MusicScriptLexer(CharStreams.fromString(args[0]));
        MusicScriptParser parser = new MusicScriptParser(new CommonTokenStream(lexer));
        Interpreter interpreter = new Interpreter();
        parser.addParseListener(interpreter);
        parser.score(); //do the parsing
        Score score = interpreter.getScore();

        XmlExport export = new XmlExport(score);
        export.writeToFile(new FileOutputStream(args[1]));
    }


    private void newVoice(int currentVoiceIndex) {
        Voice newVoice = null;
        Set<Integer> occupiedIds = new HashSet<>();
        //use inactive voices first before creating new ones
        for (Voice voice : track.getVoices()) {
            occupiedIds.add(voice.getKey());
            if (activeVoices.contains(voice))
                continue;
            //voice is unbound at this point
            newVoice = voice;
            break;
        }
        //if no inactive voice found to recycle, create new one
        if (newVoice == null) {
            int i = 0;
            while (occupiedIds.contains(i))
                i++;
            newVoice = new Voice(track, i);
        }
        //add at right index (before current voice)
        int insertIndex = 0;
        if (!currentVoices.isEmpty())
            insertIndex = activeVoices.indexOf(currentVoices.get(Math.max(0, currentVoiceIndex-1))) + 1;    //TODO math max only quick fix! Investigate!
        activeVoices.add(insertIndex, newVoice);
        currentVoices.add(currentVoiceIndex, newVoice);
    }

    private int calculatePitch(NoteName name, OctaveRegion octave, Accidental accidental) {
        //pitch - alter = (1+octaveNumber)*12 + chromaticIndex
        int pitch = (1+octave.getRegionNumber())*12 + NoteName.chromaticName2Index.get(name.name());

        //calculate alter
        if (accidental != Accidental.NONE) {
            pitch += accidental.alter;
        }
        else if (pendingAccidentals.get(currentStaffId).containsKey(name.noteLineId(octave))) {
            pitch += pendingAccidentals.get(currentStaffId).get(name.noteLineId(octave)).alter;
        }
        else {
            Tonality tonality = track.getStaff(currentStaffId).getTonalityRange(currentTick).getTonality();
            if (tonality.pitchHasAccidental(pitch)) {
                if (tonality.getFifths() > 0)
                    pitch++;
                else
                    pitch--;
            }
        }
        return pitch;
    }

    private boolean linkNotes(Note note) {
        for (int i = 0; i< pendingTies.size(); i++) {
            if (note.getPitch() == pendingTies.get(i).getPitch()) {
                note.tieNote(pendingTies.get(i));
                pendingTies.remove(i);
                return true;
            }
        }
        return false;
    }

    private void processBeam(Voice voice, NoteGroupOrRest ngor, String beamValue) {
        //TODO close if beam is not continued?
        if (beamValue.equals("["))
            pendingBeams.put(voice, ngor);
        else if (beamValue.equals("]")) {
            if (pendingBeams.containsKey(voice)) {
                new Beam(voice, pendingBeams.get(voice), ngor);
                pendingBeams.remove(voice);
            }
            else System.out.printf("Ignored erroneous beam at %s%n", currentTick.toString());
        }
    }
}
