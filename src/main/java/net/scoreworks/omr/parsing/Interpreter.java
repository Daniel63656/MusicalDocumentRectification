package net.scoreworks.omr.parsing;

import net.scoreworks.music.model.*;
import net.scoreworks.music.utils.Fraction;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Interpreter extends MusicScriptBaseListener {
    private static class VoiceState implements Comparable<VoiceState> {
        Fraction offset;
        int staffId, voiceId;

        public VoiceState(Fraction offset, int staffId, int voiceId) {
            this.offset = offset;
            this.staffId = staffId;
            this.voiceId = voiceId;
        }

        @Override
        public int compareTo(@NotNull VoiceState other) {
            int tickComparison = this.offset.compareTo(other.offset);
            if (tickComparison != 0) {
                return tickComparison;
            }
            int staffComparison = Integer.compare(this.staffId, other.staffId);
            if (staffComparison != 0) {
                return staffComparison;
            }
            return Integer.compare(this.voiceId, other.voiceId);
        }
    }
    private final Score score;
    private final Track track;
    private Fraction currentTick = Fraction.ZERO, barStartTick = Fraction.ZERO;
    private int currentStaffId, currentVoiceId, voiceIdx;
    private final List<VoiceState> voices = new ArrayList<>();
    private final List<MusicScriptParser.EventContext> events = new ArrayList<>();
    private final List<Note> pendingTies = new ArrayList<>();
    private final Map<Voice, NoteGroupOrRest> pendingBeams = new HashMap<>();
    private final Map<Integer, Map<Integer, Accidental>> pendingAccidentals = new HashMap<>();

    public Interpreter(String tokens) {
        MusicScriptLexer lexer = new MusicScriptLexer(CharStreams.fromString(tokens));
        MusicScriptParser parser = new MusicScriptParser(new CommonTokenStream(lexer));
        parser.addParseListener(this);
        parser.score(); //do the parsing with itself as listener
        //build score
        score = new Score();
        track = new Track(score);
        new Staff(track, 0);
        new Staff(track, 1);
        for (Staff staff : track.getStaffs()) {
            new TonalityRange(staff, Fraction.ZERO, Tonality.Cmajor); // no visual signs is C major by default
            new TimeSignatureRange(staff, Fraction.ZERO, new TimeSignature(4, 4));
            pendingAccidentals.put(staff.getKey(), new HashMap<>());
        }
        for (MusicScriptParser.EventContext ctx : events) {
            dispatchEvent(ctx);
        }
    }

    public Score getScore() {
        return score;
    }

    @Override
    public void enterEvent(MusicScriptParser.EventContext ctx) {
        Collections.sort(voices);
        voiceIdx = 0;
        if (!voices.isEmpty())
            currentTick = voices.get(0).offset;
    }

    @Override
    public void exitEvent(MusicScriptParser.EventContext ctx) {
        ctx.tick = currentTick;
        events.add(ctx);
    }

    @Override
    public void exitSegment(MusicScriptParser.SegmentContext ctx) {
        ctx.staffId = currentStaffId;
    }

    @Override
    public void exitGroup(MusicScriptParser.GroupContext ctx) {
        //bind to voice
        if (ctx.NEWV() != null || voiceIdx >= voices.size()) {
            voices.add(voiceIdx, new VoiceState(currentTick, currentStaffId, currentVoiceId));
            currentVoiceId++;
        }
        for (TerminalNode ignored : ctx.SKPV()) {
            voices.remove(voiceIdx);
            currentVoiceId--;
        }
        VoiceState vs = voices.get(voiceIdx);
        ctx.voiceId = vs.voiceId;
        vs.offset = vs.offset.add(getGroupDuration(ctx));
        voiceIdx++;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        if (node.getSymbol().getType() == MusicScriptLexer.BARL) {
            currentVoiceId = 0;
            voiceIdx = 0;
            voices.clear();
        }
        switch (node.getSymbol().getText()) {
            case "T" -> currentStaffId = 0;
            case "L", "&" -> currentStaffId = 1;
        }
    }

    private Fraction getGroupDuration(MusicScriptParser.GroupContext group) {
        if (group.rest() != null) {
            MusicScriptParser.RestContext rest = group.rest();
            group.noteType = NoteType.fromExponent(-Integer.parseInt(rest.REST().getText().substring(1)));
            group.dots = rest.DOT().size();
            return group.noteType.getValue(group.dots);
        }
        MusicScriptParser.ChordContext chord = group.chord().get(group.chord().size()-1);
        group.noteType = NoteType.QUARTER;
        if (!chord.note_open().isEmpty()) {
            group.noteType = NoteType.WHOLE;
            if (chord.STEM() != null)
                group.noteType = NoteType.HALF;
        }
        else if (chord.FLAG() != null) {
            group.noteType = NoteType.fromExponent(-Integer.parseInt(chord.FLAG().getText().substring(1)) - 2);
        }
        group.dots = chord.DOT().size();
        return group.noteType.getValue(group.dots);
    }

    private void dispatchEvent(MusicScriptParser.EventContext ctx) {
        currentTick = ctx.tick;
        if (ctx.BARL() != null && currentTick.compareTo(Fraction.ZERO) > 0) {   //not called on first and last bar line in score
            //handle irregular bars / up beats
            Fraction realBarDuration = currentTick.subtract(barStartTick);
            for (Staff staff : track.getStaffs()) {
                Bar currentBar = staff.getBar(barStartTick);
                if (realBarDuration.compareTo(currentBar.getDuration()) != 0) {
                    TimeSignatureRange tsr = currentBar.getOwner();
                    //make first in TimeSignatureRange if not already
                    if (currentBar.getKey() != 0)
                        tsr = new TimeSignatureRange(staff, currentTick, tsr.getTimeSignature());
                    Fraction z = realBarDuration.subtract(currentBar.getDuration());
                    tsr.setUpBeatCorrect(z);
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
        //segments
        for (MusicScriptParser.SegmentContext segment : ctx.segment()) {
            Staff staff = track.getStaff(segment.staffId);
            currentStaffId = segment.staffId;
            //meta events
            if (segment.CLEF() != null) {
                String value = segment.CLEF().getText();
                Clef clef;
                switch (value) {
                    case "G" -> clef = Clef.TREBLE;
                    case "F" -> clef = Clef.BASS;
                    default -> throw new RuntimeException(String.format("Clef %s not recognized", value));
                }
                ClefRange current = staff.getClefRange(currentTick);
                if (current == null || current.getClef() != clef)
                    new ClefRange(staff, currentTick, clef);
            }
            if (segment.time() != null) {
                TimeSignature timeSignature;
                if (segment.time().SLASH() != null) {
                    int slashLocation = segment.time().SLASH().getSymbol().getStartIndex();
                    StringBuilder numerator = new StringBuilder();
                    StringBuilder denominator = new StringBuilder();
                    for (TerminalNode digit : segment.time().DIGIT()) {
                        if (digit.getSymbol().getStartIndex() < slashLocation)
                            numerator.append(digit.getText());
                        else denominator.append(digit.getText());
                    }
                    timeSignature = new TimeSignature(Integer.parseInt(numerator.toString()), Integer.parseInt(denominator.toString()));
                }
                else {
                    String value = segment.time().getText();
                    if (value.equals("c"))
                        timeSignature = TimeSignature.createAllaSemibrevis();
                    else if (value.equals("/c"))
                        timeSignature = TimeSignature.createAllaBreve();
                    else throw new RuntimeException(String.format("Time signature %s not recognized", value));
                }
                TimeSignatureRange current = staff.getTimeSignatureRange(currentTick);
                if (current == null || current.getTimeSignature() != timeSignature)
                    new TimeSignatureRange(staff, currentTick, timeSignature);
            }
            if (segment.key() != null) {
                MusicScriptParser.KeyContext keyCtx = segment.key();
                int fifths = 0;     // default/naturals
                if (!keyCtx.SHARP().isEmpty())
                    fifths = keyCtx.SHARP().size();
                else if (!keyCtx.FLAT().isEmpty())
                    fifths = -keyCtx.FLAT().size();
                Tonality tonality = Tonality.fromFifths(fifths, MajorMinor.Major);
                TonalityRange current = staff.getTonalityRange(currentTick);
                if (current == null || current.getTonality() != tonality) {
                    new TonalityRange(staff, currentTick, tonality);
                    // reset active accidentals on that staff
                    pendingAccidentals.put(currentStaffId, new HashMap<>());
                }
            }
            //do groups
            for (MusicScriptParser.GroupContext group : segment.group()) {
                Voice voice = track.getVoice(group.voiceId);
                if (voice == null) voice = new Voice(track, group.voiceId);
                //rest
                if (group.rest() != null) {
                    Rest rest = new Rest(currentTick, voice, staff, group.noteType, group.dots);
                    if (group.rest().BEAM() != null)
                        processBeam(voice, rest, group.rest().BEAM().getText());
                }
                //chord
                else {
                    MusicScriptParser.ChordContext chord = group.chord().get(group.chord().size() - 1);
                    NoteGroup noteGroup = null;
                    for (MusicScriptParser.Note_openContext note : chord.note_open())
                        noteGroup = dispatchNote(noteGroup, staff, voice, group.noteType, group.dots, note.accidental(), Integer.parseInt(note.NOTE_OPEN().getText().substring(1)), note.TIE_END() != null, note.TIE_START() != null);
                    for (MusicScriptParser.Note_solidContext note : chord.note_solid())
                        noteGroup = dispatchNote(noteGroup, staff, voice, group.noteType, group.dots, note.accidental(), Integer.parseInt(note.NOTE_SOLID().getText().substring(1)), note.TIE_END() != null, note.TIE_START() != null);
                    assert noteGroup != null;
                    if (chord.STEM() != null)
                        noteGroup.setStem(chord.STEM().getText().equals("u") ? Stem.UP : Stem.DOWN);
                    if (chord.BEAM() != null)
                        processBeam(voice, noteGroup, chord.BEAM().getText());
                }
            }
        }
    }

    private NoteGroup dispatchNote(NoteGroup noteGroup, Staff staff, Voice voice, NoteType noteType, int dots, MusicScriptParser.AccidentalContext acc, int referenceLine, boolean tieEnd, boolean tieStart) {
        Accidental accidental = Accidental.NONE;
        if (acc != null) {
            switch (acc.getText()) {
                case "#", "b", "n", "x" -> accidental = Accidental.fromString(acc.getText());
                case "-" -> accidental = Accidental.FLAT_FLAT;
            }
        }
        referenceLine -= staff.getClefRange(currentTick).getClef().getC0_referenceLine();
        //if (pendingOctaveShifts.containsKey(staff))
            //line -= pendingOctaveShifts.get(staff).octavation.getShiftOctaves()*7;
        NoteName name = NoteName.values()[referenceLine % 7];
        OctaveRegion octave = OctaveRegion.fromNumber(referenceLine / 7);
        if (accidental != Accidental.NONE) pendingAccidentals.get(currentStaffId).put(name.noteLineId(octave), accidental);
        int pitch = calculatePitch(name, octave, accidental);
        //instantiate
        Note note;
        if (noteGroup == null) {
            note = new Note(currentTick, voice, staff, noteType, dots, pitch, name, octave, accidental);
            noteGroup = note.getOwner();
        }
        else note = new Note(noteGroup, pitch, name, octave, accidental);
        if (tieStart) pendingTies.add(note);
        if (tieEnd && !linkNotes(note)) System.out.printf("Ignored erroneous tie at %s%n", currentTick.toString());
        return noteGroup;
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
        if (beamValue.equals("["))
            pendingBeams.put(voice, ngor);
        else if (beamValue.equals("]")) {
            if (pendingBeams.containsKey(voice)) {
                new Beam(voice, pendingBeams.get(voice), ngor);
                pendingBeams.remove(voice);
            }
            else System.out.printf("Ignored erroneous beam end without start at %s%n", currentTick.toString());
        }
    }
}