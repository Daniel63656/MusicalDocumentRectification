package net.scoreworks.omr.parsing;

import net.scoreworks.music.model.*;
import net.scoreworks.music.utils.Fraction;
import net.scoreworks.omr.parsing.antlr.MusicScriptLexer;
import net.scoreworks.omr.parsing.antlr.MusicScriptListener;
import net.scoreworks.omr.parsing.antlr.MusicScriptParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class MyListener implements MusicScriptListener {
    private final Score score = new Score();
    private final Track track;
    private int currentStaffId;
    private Fraction currentTick = Fraction.ZERO;
    private final List<Voice> activeVoices = new ArrayList<>();
    private final List<Voice> currentVoices = new ArrayList<>();
    private int currentVoiceIndex;  //point to the location of next voice to add a group to in urgentVoices
    private final List<Note> pendingTies = new ArrayList<>();
    private final Map<Voice, NoteGroupOrRest> pendingBeams = new HashMap<>();
    private final Map<Integer, Map<Integer, Accidental>> pendingAccidentals = new HashMap<>();

    public MyListener() {
        track = new Track(score);
        new Staff(track, 0);
        new Staff(track, 1);
        for (Staff staff : track.getStaffs()) {
            new TonalityRange(staff, currentTick, Tonality.Cmajor); // no visual signs is C major by default
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
    public void exitEvent(MusicScriptParser.EventContext ctx) {}
    @Override
    public void enterGroup(MusicScriptParser.GroupContext ctx) {}
    @Override
    public void exitGroup(MusicScriptParser.GroupContext ctx) {}
    @Override
    public void enterRest(MusicScriptParser.RestContext ctx) {}
    @Override
    public void exitRest(MusicScriptParser.RestContext ctx) {
        NoteType noteType = NoteType.fromExponent(-Integer.parseInt(ctx.REST().getText().substring(1)));
        if (currentVoiceIndex >= currentVoices.size()) {
            newVoice();
            System.out.printf("Missing voice start inserted at %s%n", currentTick.toString());
        }
        Voice voice = currentVoices.get(currentVoiceIndex);
        Rest rest = new Rest(currentTick, voice, track.getStaff(currentStaffId), noteType, ctx.DOT().size());
        if (ctx.BEAM() != null)
            processBeam(voice, rest, ctx.BEAM().getText());
        //TODO change lastNoteGroupOrRest duration to guarantee no seems
        currentVoiceIndex++;
    }

    @Override
    public void enterChord(MusicScriptParser.ChordContext ctx) {}
    @Override
    public void exitChord(MusicScriptParser.ChordContext ctx) {
        NoteType noteType = NoteType.QUARTER;
        if (ctx.WHOLE() != null)
            noteType = NoteType.WHOLE;
        else if (ctx.HALF() != null)
            noteType = NoteType.HALF;
        int flags = ctx.FLAG().size();
        if (flags > 0)
            noteType = NoteType.fromExponent(-flags - 2);

        //parse notes
        NoteGroup noteGroup = null;
        for (MusicScriptParser.NoteContext noteCtx : ctx.note()) {
            Accidental accidental = Accidental.NONE;
            if (noteCtx.ACC() != null) {
                switch (noteCtx.ACC().getText()) {
                    case "#", "b", "n", "x" -> accidental = Accidental.fromString(noteCtx.ACC().getText());
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
                if (currentVoiceIndex >= currentVoices.size()) {
                    newVoice();
                    System.out.printf("Missing voice start inserted at %s%n", currentTick.toString());
                }
                Voice voice = currentVoices.get(currentVoiceIndex);
                note = new Note(currentTick, voice, track.getStaff(currentStaffId), noteType, ctx.DOT().size(), calculatePitch(name, octave, accidental), name, octave, accidental);
                noteGroup = note.getOwner();
                if (ctx.STEM() != null)
                    noteGroup.setStem(ctx.STEM().getText().equals("up") ? Stem.UP : Stem.DOWN);
                if (ctx.BEAM() != null)
                    processBeam(voice, noteGroup, ctx.BEAM().getText());
                //TODO change lastNoteGroupOrRest duration to guarantee no seems
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

    @Override
    public void enterNote(MusicScriptParser.NoteContext ctx) {}

    @Override
    public void exitNote(MusicScriptParser.NoteContext ctx) {}

    @Override
    public void enterMeta(MusicScriptParser.MetaContext ctx) {}

    @Override
    public void exitMeta(MusicScriptParser.MetaContext ctx) {}

    @Override
    public void enterTime(MusicScriptParser.TimeContext ctx) {}

    @Override
    public void exitTime(MusicScriptParser.TimeContext ctx) {
        int slashLocation = ctx.SLASH().getSymbol().getStartIndex();
        StringBuilder numerator = new StringBuilder();
        StringBuilder denominator = new StringBuilder();
        for (TerminalNode digit : ctx.DIGIT()) {
            if (digit.getSymbol().getStartIndex() < slashLocation)
                numerator.append(digit.getText());
            else denominator.append(digit.getText());
        }
        new TimeSignatureRange(track.getStaff(currentStaffId), currentTick, new TimeSignature(Integer.parseInt(numerator.toString()), Integer.parseInt(denominator.toString())));
    }

    @Override
    public void enterKey(MusicScriptParser.KeyContext ctx) {}

    @Override
    public void exitKey(MusicScriptParser.KeyContext ctx) {
        int fifths = 0;     // default/naturals
        if (!ctx.KEY_SHP().isEmpty())
            fifths = ctx.KEY_SHP().size();
        else if (!ctx.KEY_FLT().isEmpty())
            fifths = -ctx.KEY_SHP().size();
        new TonalityRange(track.getStaff(currentStaffId), currentTick, Tonality.fromFifths(fifths, MajorMinor.Major));
        // reset active accidentals on that staff
        pendingAccidentals.put(currentStaffId, new HashMap<>());
    }

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
        String type = MusicScriptLexer.VOCABULARY.getSymbolicName(node.getSymbol().getType());
        if (type == null) return;
        String value = node.getText();
        switch (type) {
            case "BARL" -> {
                //TODO check if irregular

                pendingTies.clear();
                pendingBeams.clear();
                // reset active accidentals
                pendingAccidentals.clear();
                for (Staff staff : track.getStaffs()) {
                    pendingAccidentals.put(staff.getKey(), new HashMap<>());
                }
            }
            case "STAFF" -> {
                if (value.equals("&")) {
                    if (currentStaffId == 1)
                        throw new RuntimeException("Can not staff change if already in bass");
                    currentStaffId = 1;
                }
                else {
                    if (value.equals("T")) currentStaffId = 0;
                    else if (value.equals("L")) currentStaffId = 1;
                    updateVoiceBindings();
                }
            }
            case "CLEF" -> {
                switch (value) {
                    case "gclef" -> new ClefRange(track.getStaff(currentStaffId), currentTick, Clef.TREBLE);
                    case "fclef" -> new ClefRange(track.getStaff(currentStaffId), currentTick, Clef.BASS);
                    default -> throw new RuntimeException(String.format("Clef %s not recognized", value));
                }
            }
            case "NEWV" -> newVoice();
            case "VEND" -> activeVoices.remove(currentVoices.get(currentVoiceIndex-1));
        }
    }

    @Override
    public void visitErrorNode(ErrorNode node) {}

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {}

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {}


    private void newVoice() {
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
            insertIndex = activeVoices.indexOf(currentVoices.get(currentVoiceIndex-1)) + 1;
        activeVoices.add(insertIndex, newVoice);
        currentVoices.add(currentVoiceIndex, newVoice);
    }

    private void updateVoiceBindings() {
        currentVoiceIndex = 0;
        //create a new list of active voices sorted by the offset tick
        currentVoices.clear();
        currentVoices.addAll(activeVoices);
        currentVoices.sort(Comparator.comparing(Voice::getEnd)); //this keeps insertion order for elements with same tick
        if (!currentVoices.isEmpty()) {  // catch begin of song
            currentTick = currentVoices.get(0).getEnd();
        }
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
            if (!tonality.pitchIsNaturalInTonality(pitch)) {
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
