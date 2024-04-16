package net.scoreworks.omr.parsing;

import jakarta.xml.bind.JAXBException;
import net.scoreworks.music.model.*;
import net.scoreworks.music.utils.Fraction;
import net.scoreworks.xml.XmlExport;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    private Fraction currentTime = Fraction.ZERO, barOnset = Fraction.ZERO;
    private int currentStaffId, currentVoiceId, voiceIdx;
    private final List<VoiceState> voices = new ArrayList<>();
    private final List<MusicScriptParser.EventContext> events = new ArrayList<>();
    private final List<Note> pendingTies = new ArrayList<>();
    private final Map<Voice, Element> pendingBeams = new HashMap<>();
    private final Map<Integer, Map<Integer, Accidental>> pendingAccidentals = new HashMap<>();

    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        if (args.length != 2) {
            System.out.println("Usage: java -jar Interpreter.jar <filepath> <token_string>");
        }
        Interpreter interpreter = new Interpreter(args[1]);
        Score score = interpreter.getScore();
        XmlExport export = new XmlExport(score);
        export.writeToFile(new FileOutputStream(args[0]));
    }

    public Interpreter(String sentence) {
        score = new Score();
        track = new Track(score);
        MusicScriptLexer lexer = new MusicScriptLexer(CharStreams.fromString(sentence));
        MusicScriptParser parser = new MusicScriptParser(new CommonTokenStream(lexer));
        parser.addParseListener(this);
        parser.track(); //do the parsing with itself as listener
        for (MusicScriptParser.EventContext ctx : events) {
            dispatchEvent(ctx);
        }
    }

    public Score getScore() {
        return score;
    }

    @Override
    public void exitEvent(MusicScriptParser.EventContext ctx) {
        voiceIdx = 0;
        if (ctx.barline() != null) {
            currentTime = voices.isEmpty() ? currentTime : voices.get(voices.size()-1).offset;
            currentVoiceId = 0;
            voices.clear();
        }
        else {
            //sort voices based on offset
            Collections.sort(voices);
            //determine number of requested voices
            int vReq = 0;
            for (MusicScriptParser.StaffletContext stafflet : ctx.stafflet()) {
                vReq += stafflet.voicelet().size();
            }
            //if not first event, set event's onset to last requested one. Ideally, all first vReq voices share the same
            //offset. If not, this approach at least prevents clipping.
            //Clipping index is necessary:
            //  vReq >= voices.size() if event contains demand for new (not yet created) voices
            //  vReq < 0 if event contains no groups (like only clef change)
            currentTime = voices.isEmpty() ? currentTime : voices.get(Math.max(0, Math.min(vReq, voices.size()) - 1)).offset;
        }
        ctx.onset = currentTime;
        //TODO verify that voices 0 to vReq-1 share same offset and implement resolving strategies if not
        //bind groups to voices and advance voice offsets by group's duration
        for (MusicScriptParser.StaffletContext stafflet : ctx.stafflet()) {
            for (MusicScriptParser.VoiceletContext voicelet : stafflet.voicelet()) {
                bindToVoice(voicelet, ctx.onset, stafflet.staffId);
            }
        }
        events.add(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        switch (node.getSymbol().getText()) {
            case "T" -> {
                currentStaffId = 0;
                if (track.getStaffs().size() <= currentStaffId) createStaff(currentStaffId);
            }
            case "L", "&" -> {
                currentStaffId = 1;
                if (track.getStaffs().size() <= currentStaffId) createStaff(currentStaffId);
            }
        }
    }

    @Override
    public void exitStafflet(MusicScriptParser.StaffletContext ctx) {
        ctx.staffId = currentStaffId;
    }


    //---------- helper functions and dispatch -- move into respective classes eventually ----------------------------//

    private void createStaff(int staffId) {
        new Staff(track, staffId);
        for (Staff staff : track.getStaffs()) {
            new KeyRange(staff, Fraction.ZERO, new KeySignature(0, true)); // no visual signs is C major by default
            new TimeSignatureRange(staff, Fraction.ZERO, new TimeSignature(2, 4));
            pendingAccidentals.put(staff.getKey(), new HashMap<>());
        }
    }

    private void bindToVoice(MusicScriptParser.VoiceletContext voicelet, Fraction onset, int currentStaffId) {
        if (voicelet.NEWV() != null || voiceIdx >= voices.size()) {
            voices.add(voiceIdx, new VoiceState(onset, currentStaffId, currentVoiceId));
            currentVoiceId++;
        }
        for (TerminalNode ignored : voicelet.SKPV()) {
            voices.remove(voiceIdx);
            currentVoiceId--;
        }
        VoiceState vs = voices.get(voiceIdx);
        voicelet.voiceId = vs.voiceId;
        vs.offset = onset.add(determineGroupDuration(voicelet));
        voiceIdx++;
    }

    private Fraction determineGroupDuration(MusicScriptParser.VoiceletContext voicelet) {
        MusicScriptParser.ElementContext element = voicelet.element();
        if (element.rest() != null) {
            MusicScriptParser.RestContext rest = element.rest();
            element.noteType = NoteType.fromExponent(-Integer.parseInt(rest.REST().getText().substring(1)));
            element.dots = rest.DOT().size();
            return element.noteType.getValue(element.dots);
        }
        MusicScriptParser.ChordContext chord = element.chord().get(element.chord().size()-1);
        element.noteType = NoteType.QUARTER;
        if (!chord.note_open().isEmpty()) {
            element.noteType = NoteType.WHOLE;
            if (chord.STEM() != null)
                element.noteType = NoteType.HALF;
        }
        else if (chord.FLAG() != null) {
            element.noteType = NoteType.fromExponent(-Integer.parseInt(chord.FLAG().getText().substring(1)) - 2);
        }
        element.dots = chord.DOT().size();
        return element.noteType.getValue(element.dots);
    }

    private void dispatchEvent(MusicScriptParser.EventContext ctx) {
        currentTime = ctx.onset;
        //barline
        if (ctx.barline() != null && currentTime.compareTo(Fraction.ZERO) > 0) {   //exclude first bar line
            Fraction realBarDuration = currentTime.subtract(barOnset);
            for (Staff staff : track.getStaffs()) {
                Bar currentBar = staff.getBar(barOnset);
                //handle irregular bars / up beats
                if (realBarDuration.compareTo(currentBar.getDuration()) != 0) {
                    TimeSignatureRange tsr = currentBar.getTimeSignatureRange();
                    //make first in TimeSignatureRange if not already
                    if (currentBar.getRangeIndex() != 0)
                        tsr = new TimeSignatureRange(staff, barOnset, tsr.getTimeSignature());
                    tsr.setUpBeatCorrect(realBarDuration.subtract(currentBar.getDuration()));
                }
            }
            //reset bar specific pending collections
            pendingBeams.clear();
            pendingAccidentals.clear();
            for (Staff staff : track.getStaffs()) {
                pendingAccidentals.put(staff.getKey(), new HashMap<>());
            }
            barOnset = currentTime;
        }
        //stafflets
        for (MusicScriptParser.StaffletContext stafflet : ctx.stafflet()) {
            Staff staff = track.getStaff(stafflet.staffId);
            currentStaffId = stafflet.staffId;
            //meta events
            if (stafflet.CLEF() != null) {
                String value = stafflet.CLEF().getText();
                Clef clef;
                switch (value) {
                    case "G" -> clef = Clef.TREBLE;
                    case "F" -> clef = Clef.BASS;
                    default -> throw new RuntimeException(String.format("Clef %s not recognized", value));
                }
                ClefRange current = staff.getClefRange(currentTime);
                if (current == null || current.getClef() != clef)
                    new ClefRange(staff, currentTime, clef);
            }
            if (stafflet.time() != null) {
                TimeSignature timeSignature;
                if (stafflet.time().SLASH() != null) {
                    int slashLocation = stafflet.time().SLASH().getSymbol().getStartIndex();
                    StringBuilder numerator = new StringBuilder();
                    StringBuilder denominator = new StringBuilder();
                    for (TerminalNode digit : stafflet.time().DIGIT()) {
                        if (digit.getSymbol().getStartIndex() < slashLocation)
                            numerator.append(digit.getText());
                        else denominator.append(digit.getText());
                    }
                    timeSignature = new TimeSignature(Integer.parseInt(numerator.toString()), Integer.parseInt(denominator.toString()));
                }
                else {
                    String value = stafflet.time().getText();
                    if (value.equals("c"))
                        timeSignature = TimeSignature.createAllaSemibrevis();
                    else if (value.equals("/c"))
                        timeSignature = TimeSignature.createAllaBreve();
                    else throw new RuntimeException(String.format("Time signature %s not recognized", value));
                }
                TimeSignatureRange current = staff.getTimeSignatureRange(currentTime);
                if (current == null || current.getTimeSignature() != timeSignature)
                    new TimeSignatureRange(staff, currentTime, timeSignature);
            }
            if (stafflet.key() != null) {
                MusicScriptParser.KeyContext keyCtx = stafflet.key();
                int fifths = 0;     // default/naturals
                if (!keyCtx.SHARP().isEmpty())
                    fifths = keyCtx.SHARP().size();
                else if (!keyCtx.FLAT().isEmpty())
                    fifths = -keyCtx.FLAT().size();
                KeySignature key = new KeySignature(fifths, true);
                KeyRange current = staff.getKeyRange(currentTime);
                if (current == null || !Objects.equals(current.getKeySignature(), key)) {
                    new KeyRange(staff, currentTime, key);
                    // reset active accidentals on that staff
                    pendingAccidentals.put(currentStaffId, new HashMap<>());
                }
            }
            //do voicelets
            for (MusicScriptParser.VoiceletContext voicelet : stafflet.voicelet()) {
                MusicScriptParser.ElementContext element = voicelet.element();
                Voice voice = track.getVoice(voicelet.voiceId);
                if (voice == null) voice = new Voice(track, voicelet.voiceId);
                //rest
                if (element.rest() != null) {
                    Rest rest = new Rest(currentTime, voice, staff, element.noteType, element.dots);
                    if (element.rest().BEAM() != null)
                        processBeam(voice, rest, element.rest().BEAM().getText());
                }
                //chord
                else {
                    MusicScriptParser.ChordContext chordCtx = element.chord().get(element.chord().size() - 1);
                    Chord chord = null;
                    for (MusicScriptParser.Note_openContext note : chordCtx.note_open())
                        chord = dispatchNote(chord, staff, voice, element.noteType, element.dots, note.accidental(), Integer.parseInt(note.NOTE_OPEN().getText().substring(1)), note.TIE_END() != null, note.TIE_START() != null);
                    for (MusicScriptParser.Note_solidContext note : chordCtx.note_solid())
                        chord = dispatchNote(chord, staff, voice, element.noteType, element.dots, note.accidental(), Integer.parseInt(note.NOTE_SOLID().getText().substring(1)), note.TIE_END() != null, note.TIE_START() != null);
                    assert chord != null;
                    if (chordCtx.STEM() != null)
                        chord.setStem(chordCtx.STEM().getText().equals("u") ? Stem.UP : Stem.DOWN);
                    if (chordCtx.BEAM() != null)
                        processBeam(voice, chord, chordCtx.BEAM().getText());
                }
            }
        }
    }

    private Chord dispatchNote(Chord chord, Staff staff, Voice voice, NoteType noteType, int dots, MusicScriptParser.AccidentalContext acc, int referenceLine, boolean tieEnd, boolean tieStart) {
        Accidental accidental = Accidental.NONE;
        if (acc != null) {
            switch (acc.getText()) {
                case "#" -> accidental = Accidental.SHARP;
                case "b" -> accidental = Accidental.FLAT;
                case "n" -> accidental = Accidental.NATURAL;
                case "x" -> accidental = Accidental.DOUBLE_SHARP;
                case "-" -> accidental = Accidental.FLAT_FLAT;
            }
        }
        referenceLine -= staff.getClefRange(currentTime).getClef().getC0_referenceLine();
        //if (pendingOctaveShifts.containsKey(staff))
        //line -= pendingOctaveShifts.get(staff).octavation.getShiftOctaves()*7;
        NoteName name = NoteName.values()[referenceLine % 7];
        int octave = referenceLine / 7;
        if (accidental != Accidental.NONE) pendingAccidentals.get(currentStaffId).put(name.stepId(octave), accidental);
        int pitch = calculatePitch(name, octave, accidental);
        //instantiate
        Note note;
        if (chord == null) {
            note = new Note(currentTime, voice, staff, noteType, dots, pitch, name, octave, accidental);
            chord = (Chord) note.getOwner();
        }
        else note = new Note(chord, pitch, name, octave, accidental);
        if (tieStart) pendingTies.add(note);
        if (tieEnd && !linkNotes(note)) System.out.printf("Ignored erroneous tie at %s%n", currentTime.toString());
        return chord;
    }

    private int calculatePitch(NoteName name, int octave, Accidental accidental) {
        //pitch - alter = (octave+1)*12 + chromaticIndex
        int pitch = (octave+1)*12 + name.getChromaticIndex();
        //calculate alter
        if (accidental != Accidental.NONE) {
            pitch += accidental.getAlter();
        }
        else if (pendingAccidentals.get(currentStaffId).containsKey(name.stepId(octave))) {
            pitch += pendingAccidentals.get(currentStaffId).get(name.stepId(octave)).getAlter();
        }
        else {
            KeySignature key = track.getStaff(currentStaffId).getKeyRange(currentTime).getKeySignature();
            if (key.pitchHasAccidental(pitch)) {
                if (key.getFifths() > 0)
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

    private void processBeam(Voice voice, Element element, String beamValue) {
        if (beamValue.equals("["))
            pendingBeams.put(voice, element);
        else if (beamValue.equals("]")) {
            if (pendingBeams.containsKey(voice)) {
                new Beam(voice, pendingBeams.get(voice), element);
                pendingBeams.remove(voice);
            }
            else System.out.printf("Ignored erroneous beam end without start at %s%n", currentTime.toString());
        }
    }
}