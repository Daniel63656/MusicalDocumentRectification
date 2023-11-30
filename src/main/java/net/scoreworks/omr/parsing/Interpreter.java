package net.scoreworks.omr.parsing;

import jakarta.xml.bind.JAXBException;
import net.scoreworks.music.model.*;
import net.scoreworks.music.utils.Fraction;
import net.scoreworks.xml.ProgressQualifier;
import net.scoreworks.xml.XmlExport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

public class Interpreter {
    private final Score score = new Score();
    private final Track track;
    private int currentStaffId;
    private Fraction currentTick = Fraction.ZERO;
    private final List<Voice> activeVoices = new ArrayList<>();
    private final List<Voice> urgentVoices = new ArrayList<>();
    private int currentVoiceIndex;  //point to the location of next voice to add a group to in urgentVoices
    private final List<List<Token>> currentNotes = new ArrayList<>();
    private final List<Note> pendingTies = new ArrayList<>();
    private final Map<Voice, NoteGroupOrRest> pendingBeams = new HashMap<>();
    private final Map<Integer, Map<Integer, Accidental>> pendingAccidentals = new HashMap<>();

    public Interpreter() {
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

    public void exportToMusicxml(String filePath) throws FileNotFoundException, JAXBException {
        XmlExport export = new XmlExport(score);
        export.writeToFile(new FileOutputStream(filePath));
    }

    public void onBarLine() {
        //TODO check if irregular

        pendingTies.clear();
        pendingBeams.clear();
        // reset active accidentals
        pendingAccidentals.clear();
        for (Staff staff : track.getStaffs()) {
            pendingAccidentals.put(staff.getKey(), new HashMap<>());
        }
    }

    public void onStaff(String value) {
        switch (value) {
            case "T" -> {
                currentStaffId = 0;
                updateVoiceBindings();
            }
            case "L" -> {
                currentStaffId = 1;
                updateVoiceBindings();
            }
            case "&" -> {
                if (currentStaffId == 1)
                    throw new RuntimeException("Can not staff change if already in bass");
                currentStaffId = 1;
            }
        }
    }

    private void updateVoiceBindings() {
        currentVoiceIndex = 0;
        //create a new list of active voices sorted by the offset tick
        urgentVoices.clear();
        urgentVoices.addAll(activeVoices);
        urgentVoices.sort(Comparator.comparing(Voice::getEnd)); //this keeps insertion order for elements with same tick
        if (!urgentVoices.isEmpty()) {  // catch begin of song

            for (NoteGroupOrRest ng : urgentVoices.get(0).getNoteGroupOrRests().toList()) {
                System.out.println(ng.getStart() + ", " + ng.getDuration());
            }

            currentTick = urgentVoices.get(0).getEnd();
        }
    }

    public void onClef(String value) {
        switch (value) {
            case "gclef" -> new ClefRange(track.getStaff(currentStaffId), currentTick, Clef.TREBLE);
            case "fclef" -> new ClefRange(track.getStaff(currentStaffId), currentTick, Clef.BASS);
            default -> throw new RuntimeException(String.format("Clef %s not recognized", value));
        }
    }

    public void onKey(List<Token> tokens) {
        int fifths = tokens.size();
        if (tokens.get(0).type() == Terminal.KEY_FLT)
            fifths *= -1;
        else if (tokens.get(0).type() == Terminal.KEY_NAT)
            fifths = 0;
        new TonalityRange(track.getStaff(currentStaffId), currentTick, Tonality.fromFifths(fifths, MajorMinor.Major));
        // reset active accidentals on that staff
        pendingAccidentals.put(currentStaffId, new HashMap<>());
    }

    public void onTime(List<Token> tokens) {
        StringBuilder strb = new StringBuilder();
        int numerator = 0, denominator;
        for (Token token : tokens) {
            if (token.type() == Terminal.SLASH) {
                numerator = Integer.parseInt(strb.toString());
                strb = new StringBuilder();
            }
            else strb.append(token.value());
        }
        denominator = Integer.parseInt(strb.toString());
        new TimeSignatureRange(track.getStaff(currentStaffId), currentTick, new TimeSignature(numerator, denominator));
    }

    public void onNewVoice() {
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
        if (!urgentVoices.isEmpty())
            insertIndex = activeVoices.indexOf(urgentVoices.get(currentVoiceIndex-1)) + 1;
        activeVoices.add(insertIndex, newVoice);
        urgentVoices.add(currentVoiceIndex, newVoice);
    }

    public void onVoiceEnd() {
        Voice voiceToRemove = urgentVoices.get(currentVoiceIndex-1);
        activeVoices.remove(voiceToRemove);
    }

    public void onRest(List<Token> tokens) {
        NoteType noteType = null;
        int dots = 0;
        ProgressQualifier beam = null;
        for (Token token : tokens) {
            switch (token.type()) {
                case REST -> noteType = NoteType.fromExponent(-Integer.parseInt(token.value().substring(1)));
                case BEAM -> {
                    if (token.value().equals("[")) beam = ProgressQualifier.START;
                    else if (token.value().equals("]")) beam = ProgressQualifier.STOP;
                }
                case DOT -> dots++;
            }
        }

        // create the Rest instance
        if (currentVoiceIndex >= urgentVoices.size()) {
            onNewVoice();
            System.out.printf("Missing voice start inserted at %s%n", currentTick.toString());
        }
        Voice voice = urgentVoices.get(currentVoiceIndex);
        Rest rest = new Rest(currentTick, voice, track.getStaff(currentStaffId), noteType, dots);
        processBeam(voice, rest, beam);
        //TODO change lastNoteGroupOrRest duration to guarantee no seems
        currentVoiceIndex++;
    }

    public void onChord(List<Token> tokens) {
        NoteType noteType = NoteType.QUARTER;
        ProgressQualifier beam = null;
        int flags = 0, dots = 0;
        boolean stemUp = false;
        for (Token token : tokens) {
            if (token == null)
                continue;
            switch (token.type()) {
                case WHOLE -> noteType = NoteType.WHOLE;
                case HALF -> noteType = NoteType.HALF;
                case STEM -> stemUp = token.value().equals("up");
                case BEAM -> {
                    if (token.value().equals("[")) beam = ProgressQualifier.START;
                    else if (token.value().equals("]")) beam = ProgressQualifier.STOP;
                }
                case FLAG -> flags++;
                case DOT -> dots++;
            }
        }
        if (flags > 0) {
            noteType = NoteType.fromExponent(-flags - 2);
        }

        //parse notes
        NoteGroup noteGroup = null;
        for (List<Token> noteTokens : currentNotes) {
            Accidental accidental = Accidental.NONE;
            NoteName name = null;
            OctaveRegion octave = null;
            boolean tieStart = false, tieEnd = false;
            for (Token token : noteTokens) {
                switch (token.type()) {
                    case ACC -> {
                        switch (token.value()) {
                            case "#", "b", "n", "x" -> accidental = Accidental.fromString(token.value());
                            case "-" -> accidental = Accidental.FLAT_FLAT;
                        }
                    }
                    case NAME -> name = NoteName.valueOf(token.value());
                    case OCTV -> octave = OctaveRegion.fromNumber(Integer.parseInt(token.value()));
                    case TIE_START -> tieStart = true;
                    case TIE_END -> tieEnd = true;
                }
            }
            assert name != null;
            assert octave != null;
            if (accidental != Accidental.NONE) pendingAccidentals.get(currentStaffId).put(name.noteLineId(octave), accidental);
            // instantiate Notes and NoteGroup
            Note note;
            if (noteGroup == null) {
                if (currentVoiceIndex >= urgentVoices.size()) {
                    onNewVoice();
                    System.out.printf("Missing voice start inserted at %s%n", currentTick.toString());
                }
                Voice voice = urgentVoices.get(currentVoiceIndex);
                note = new Note(currentTick, voice, track.getStaff(currentStaffId), noteType, dots, calculatePitch(name, octave, accidental), name, octave, accidental);
                noteGroup = note.getOwner();
                noteGroup.setStem(stemUp ? Stem.UP : Stem.DOWN);
                processBeam(voice, noteGroup, beam);
                //TODO change lastNoteGroupOrRest duration to guarantee no seems
                currentVoiceIndex++;
            }
            else
                note = new Note(noteGroup, calculatePitch(name, octave, accidental), name, octave, accidental);
            //tie
            if (tieStart)
                pendingTies.add(note);
            if (tieEnd && !linkNotes(note))
                System.out.printf("Ignored erroneous tie at %s%n", currentTick.toString());
        }
        currentNotes.clear();
    }

    public void onNote(List<Token> tokens) {
        //save note tokens to be processed once chord is complete
        currentNotes.add(tokens);
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

    private void processBeam(Voice voice, NoteGroupOrRest ngor, ProgressQualifier beamInfo) {
        if (beamInfo == ProgressQualifier.START)
            pendingBeams.put(voice, ngor);
        else if (beamInfo == ProgressQualifier.STOP) {
            if (pendingBeams.containsKey(voice)) {
                new Beam(voice, pendingBeams.get(voice), ngor);
                pendingBeams.remove(voice);
            }
            else System.out.printf("Ignored erroneous beam at %s%n", currentTick.toString());
        }
    }
}