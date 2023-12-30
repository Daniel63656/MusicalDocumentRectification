package net.scoreworks.omr.parsing;

import net.scoreworks.music.model.*;
import net.scoreworks.music.utils.Controller;
import net.scoreworks.music.utils.Fraction;
import net.scoreworks.xml.CorruptXmlException;
import net.scoreworks.xml.XmlImport;
import org.jetbrains.annotations.NotNull;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Tokenizer {
    private static class TokenGroup implements Comparable<TokenGroup> {
        Fraction tick, duration;
        int barId, staffId, voiceId;
        String tokens;

        public TokenGroup(Fraction tick, int barId, int staffId, int voiceId, String tokens) {
            this.tick = tick;
            this.barId = barId;
            this.staffId = staffId;
            this.voiceId = voiceId;
            this.tokens = tokens;
        }

        @Override
        public int compareTo(@NotNull TokenGroup other) {
            int tickComparison = this.tick.compareTo(other.tick);
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
    private final String sentence;

    public String getSentence() {
        return sentence;
    }

    public Tokenizer(Score score) {
        this(score, new HashSet<>());
    }

    public Tokenizer(Score score, Set<Integer> systemLineBreaks) {
        assert score.getTracks().size() == 1: "Found more than one track in score!";
        Track track = score.getTrack(0);
        Set<TokenGroup> sentence = new TreeSet<>();

        //add meta events
        track.getStaffs().forEach(s -> {
            s.getBars().forEach(b -> {
                assert s.getKey() == 0 || b.getStart().compareTo(track.getStaff(0).getBar(b.getStart()).getStart()) == 0 : "Found non synchronous bars in score!";
                if (systemLineBreaks.contains(b.getBarNumber()) && b.getBarNumber() > 0) {
                    Fraction tick = b.getStart();
                    int barNumber = b.getBarNumber();
                    tokenizeClef(sentence, s.getClefRange(tick), tick, barNumber, s.getKey());
                    tokenizeKey(sentence, null, s.getTonalityRange(tick), tick, barNumber, s.getKey());
                    // time signature is not added at system breaks
                    if (s.getOctaveShiftRange(tick) != null)
                        tokenizeShift(sentence, s.getOctaveShiftRange(tick), tick, barNumber, s.getKey(), true);
                }
            });
            // add (override) all context ranges of staff
            for (ClefRange range : s.getClefRanges())
                tokenizeClef(sentence, range, range.getStart(), s.getBar(range.getStart()).getBarNumber(), s.getKey());
            TonalityRange prior = null;
            for (TonalityRange range : s.getTonalityRanges()) {
                tokenizeKey(sentence, prior, range, range.getStart(), s.getBar(range.getStart()).getBarNumber(), s.getKey());
                prior = range;
            }
            for (TimeSignatureRange range : s.getTimeSignatureRanges())
                tokenizeTime(sentence, range, range.getStart(), s.getBar(range.getStart()).getBarNumber(), s.getKey());
            for (OctaveShiftRange range : s.getOctaveShiftRanges()) {
                tokenizeShift(sentence, range, range.getStart(), s.getBar(range.getStart()).getBarNumber(), s.getKey(), true);
                tokenizeShift(sentence, range, range.getEnd(), s.getBar(range.getStart()).getBarNumber(), s.getKey(), false);
            }
        });

        // add NoteGroupOrRest from voices
        track.getVoices().forEach(v -> v.getNoteGroupOrRests().forEach(ngor -> {
            StringBuilder tokens = new StringBuilder();
            if (ngor instanceof Rest) {
                tokenizeTuplet(tokens, ngor);
                tokens.append("r").append(-ngor.getNoteType().getBase2Exponent());
                tokenizeBeam(tokens, ngor);
            }
            else {
                NoteGroup ng = (NoteGroup) ngor;
                //TODO grace
                tokenizeTuplet(tokens, ngor);
                tokenizeChord(tokens, ng);
            }
            tokens.append(".".repeat(ngor.getDots()));
            TokenGroup group = new TokenGroup(ngor.getStart(), track.getStaff(0).getBar(ngor.getStart()).getBarNumber(), ngor.getStaff().getKey(), v.getKey(), tokens.toString());
            group.duration = ngor.getDuration();
            sentence.add(group);
        }));

        //create token string
        NavigableMap<Fraction, Integer> offsetTicks = new TreeMap<>();
        StringBuilder tokens = new StringBuilder();
        int lastStaffId = -1;
        Bar currentBar = null;  //triggers barLine at beginning
        Fraction lastTick = Fraction.getFraction(-1, 1);
        for (TokenGroup group : sentence) {
            if (currentBar != track.getStaff(0).getBar(group.tick)) {
                tokens.append("|");
                currentBar = track.getStaff(0).getBar(group.tick);
            }
            if (group.tick.compareTo(lastTick) > 0) {
                tokens.append(group.staffId == 0 ? "T" : "L");  // treble staff, lower staff
                lastTick = group.tick;
            }
            else if (group.staffId != lastStaffId) {
                tokens.append("&");
            }
            lastStaffId = group.staffId;



            tokens.append(group.tokens);
        }
        tokens.append("|");
        this.sentence = tokens.toString();
    }

    public static void main(String[] args) throws XmlPullParserException, CorruptXmlException, IOException {
        if (args.length < 2) {
            System.out.println("Please provide file paths as command-line arguments");
            return;
        }
        Set<Integer> systemLineBreaks = new HashSet<>();
        for (int i=2; i<args.length; i++)   //ignore trivial first system bar = 0
            systemLineBreaks.add(Integer.parseInt(args[i]));
        // load score and tokenize
        Score score = new XmlImport().skipRepetitions(true).decodeXML(Paths.get(args[0]));
        Tokenizer tokenizer = new Tokenizer(score, systemLineBreaks);

        // write to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]))) {
            writer.write(tokenizer.sentence);
            System.out.println("String written to file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void tokenizeChord(StringBuilder tokens, NoteGroup ng) {
        int base2exp = ng.getNoteType().getBase2Exponent();
        if (base2exp < 0) {
            // stem
            if (ng.getStem() == Stem.UP)
                tokens.append("u");
            else
                tokens.append("d");
            if (base2exp < -2) {
                tokenizeBeam(tokens, ng);
                tokens.append("f").append(-base2exp - 2);
            }
        }
        // notes
        boolean noteHeadsOpen = ng.getNoteType().getBase2Exponent() > -2;
        List<Note> notes = new ArrayList<>(ng.getNotes());
        notes.sort(Comparator.comparingInt(Note::getPitch));    // sort by pitch
        for (Note note : notes) {
            Accidental accidental = note.getAccidental();
            if (accidental != null && accidental != Accidental.NONE) {
                switch (accidental) {
                    case SHARP -> tokens.append("#");
                    case FLAT -> tokens.append("b");
                    case NATURAL -> tokens.append("n");
                    case DOUBLE_SHARP -> tokens.append("x");
                    case FLAT_FLAT -> tokens.append("-");
                    default -> throw new IllegalArgumentException("Invalid accidental: " + accidental);
                }
            }
            if (note.getPreviousTied() != null)
                tokens.append(")");
            int referenceLine = Controller.getReferenceLine(ng.getClefRange().getClef(), ng.getOctaveShiftRange(), note.getNoteName(), note.getOctaveRegion());
            tokens.append(noteHeadsOpen ? "o" : "s").append(referenceLine);
            if (note.getNextTied() != null)
                tokens.append("(");
        }
    }

    private static void tokenizeClef(Set<TokenGroup> sentence, ClefRange range, Fraction tick, int barId, int staffId) {
        switch (range.getClef()) {
            case TREBLE -> sentence.add(new TokenGroup(tick, barId, staffId, -10, "G"));
            case BASS -> sentence.add(new TokenGroup(tick, barId, staffId, -10, "F"));
            default -> throw new IllegalArgumentException("Invalid clef: " + range.getClef());
        }
    }
    private static void tokenizeKey(Set<TokenGroup> sentence, TonalityRange prior, TonalityRange range, Fraction tick, int barId, int staffId) {
        StringBuilder tokens = new StringBuilder();
        Tonality tonality = range.getTonality();
        if (tonality.getFifths() > 0) {
            tokens.append("#".repeat(range.getTonality().getFifths()));
        }
        else if (tonality.getFifths() < 0) {
            tokens.append("b".repeat(-range.getTonality().getFifths()));
        }
        else if (prior != null) {
            tokens.append("n".repeat(Math.abs(prior.getTonality().getFifths())));
        }
        sentence.add(new TokenGroup(tick, barId, staffId, -9, tokens.toString()));
    }
    private static void tokenizeTime(Set<TokenGroup> sentence, TimeSignatureRange range, Fraction tick, int barId, int staffId) {
        TimeSignature time = range.getTimeSignature();
        if (time.isFree())
            throw new IllegalArgumentException("Free time signature not supported");
        else if (time.isAllaSemibrevis())
            sentence.add(new TokenGroup(tick, barId, staffId, -8, "c"));
        else if (time.isAllaBreve())
            sentence.add(new TokenGroup(tick, barId, staffId, -8, "/c"));
        else {
            char[] characters = time.getFraction().toString().toCharArray();
            StringBuilder tokens = new StringBuilder();
            for (char c : characters)
                tokens.append(c);
            sentence.add(new TokenGroup(tick, barId, staffId, -8, tokens.toString()));
        }
    }
    private static void tokenizeShift(Set<TokenGroup> sentence, OctaveShiftRange range, Fraction tick, int barId, int staffId, boolean start) {
        int voiceId = start ? -7 : 100; // apply start before and end after groups
        switch (range.getOctavation()) {
            case O8va  -> sentence.add(new TokenGroup(tick, barId, staffId, voiceId, "va"));
            case O8vb  -> sentence.add(new TokenGroup(tick, barId, staffId, voiceId, "vb"));
            case O15ma -> sentence.add(new TokenGroup(tick, barId, staffId, voiceId, "ma"));
            case O15mb -> sentence.add(new TokenGroup(tick, barId, staffId, voiceId, "mb"));
            default -> throw new IllegalArgumentException("Invalid octave shift: " + range.getOctavation());
        }
    }

    private static void tokenizeBeam(StringBuilder tokens, NoteGroupOrRest ngor) {
        Beam beam = ngor.getBeam();
        if (beam != null) {
            if (beam.getStart().equals(ngor.getStart()))
                tokens.append("[");
            else if (beam.getEnd().equals(ngor.getStart()))
                tokens.append("]");
        }
    }

    private static void tokenizeTuplet(StringBuilder tokens, NoteGroupOrRest ngor) {
        List<Tuplet> tuplets = ngor.getTuplets();
        if (!tuplets.isEmpty()) {
            Tuplet tuplet = tuplets.get(0);
            if (tuplet.getStart().equals(ngor.getStart()))
                tokens.append("{");
            else if (tuplet.getEnd().equals(ngor.getStart()))
                tokens.append("}");
            else
                tokens.append("*");
        }
    }
}
