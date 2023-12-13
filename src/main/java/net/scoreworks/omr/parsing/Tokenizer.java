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
        Fraction tick;
        int staffId, voiceId;
        String tokens;

        public TokenGroup(Fraction tick, int staffId, int voiceId, String tokens) {
            this.tick = tick;
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
                if (b.getStart().compareTo(Fraction.ZERO) > 0) {
                    if (s.getKey() == 0)
                        sentence.add(new TokenGroup(b.getStart(), -1, -1, "eos\nbos,"));
                    else
                        assert b.getStart().compareTo(track.getStaff(0).getBar(b.getStart()).getStart()) == 0 : "Found non synchronous bars in score!";
                    //re-add context at line breaks
                    if (systemLineBreaks.contains(b.getBarNumber())) {
                        Fraction tick = b.getStart();
                        tokenizeClef(sentence, s.getClefRange(tick), tick, s.getKey());
                        tokenizeKey(sentence, null, s.getTonalityRange(tick), tick, s.getKey());
                        // time signature is not added at system breaks
                        if (s.getOctaveShiftRange(tick) != null)
                            tokenizeShift(sentence, s.getOctaveShiftRange(tick), tick, s.getKey(), true);
                    }
                }
            });
            // add (override) all context ranges of staff
            for (ClefRange range : s.getClefRanges())
                tokenizeClef(sentence, range, range.getStart(), s.getKey());
            TonalityRange prior = null;
            for (TonalityRange range : s.getTonalityRanges()) {
                tokenizeKey(sentence, prior, range, range.getStart(), s.getKey());
                prior = range;
            }
            for (TimeSignatureRange range : s.getTimeSignatureRanges())
                tokenizeTime(sentence, range, range.getStart(), s.getKey());
            for (OctaveShiftRange range : s.getOctaveShiftRanges()) {
                tokenizeShift(sentence, range, range.getStart(), s.getKey(), true);
                tokenizeShift(sentence, range, range.getEnd(), s.getKey(), false);
            }
        });

        // add NoteGroupOrRest from voices
        track.getVoices().forEach(v -> {
            //if (!v.getTuplets().isEmpty())
                //throw new RuntimeException("Found tuplets which currently are not modelled!");
            v.getNoteGroupOrRests().forEach(ngor -> {
                StringBuilder tokens = new StringBuilder();
                // check for voice start
                NoteGroupOrRest prior = v.lowerNoteGroupOrRest(ngor.getStart());
                if (prior == null || prior.getEnd().compareTo(ngor.getStart()) < 0 || prior.getBar() != ngor.getBar())
                    tokens.append("<,");
                // go on with Rest or NoteGroup
                if (ngor instanceof Rest) {
                    tokens.append("r").append(-ngor.getNoteType().getBase2Exponent()).append(",");
                    tokenizeBeam(tokens, ngor);
                } else {
                    NoteGroup ng = (NoteGroup) ngor;
                    int base2exp = ngor.getNoteType().getBase2Exponent();
                    if (base2exp < 0) {
                        // stem
                        if (ng.getStem() == Stem.UP)
                            tokens.append("u,");
                        else
                            tokens.append("d,");
                        if (base2exp < -2) {
                            tokens.append("f").append(-base2exp - 2).append(",");
                            tokenizeBeam(tokens, ngor);
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
                                case SHARP -> tokens.append("#,");
                                case FLAT -> tokens.append("b,");
                                case NATURAL -> tokens.append("n,");
                                case DOUBLE_SHARP -> tokens.append("x,");
                                case FLAT_FLAT -> tokens.append("-,");
                                default -> throw new IllegalArgumentException("Invalid accidental: " + accidental);
                            }
                        }
                        if (note.getPreviousTied() != null)
                            tokens.append("),");
                        tokens.append(noteHeadsOpen ? "o,l" : "s,l");
                        int referenceLine = Controller.getReferenceLine(ngor.getClefRange().getClef(), ngor.getOctaveShiftRange(), note.getNoteName(), note.getOctaveRegion());
                        if (referenceLine < -14)
                            throw new RuntimeException(String.format("Found too low reference line %d", referenceLine));
                        if (referenceLine > 22)
                            throw new RuntimeException(String.format("Found too high reference line %d", referenceLine));
                        tokens.append(referenceLine).append(",");
                        if (note.getNextTied() != null)
                            tokens.append("(,");
                    }
                }
                // continue with similar tokens again
                tokens.append(".,".repeat(ngor.getDots()));
                //check for voice end
                NoteGroupOrRest next = v.higherNoteGroupOrRest(ngor.getStart());
                if (next == null || ngor.getEnd().compareTo(next.getStart()) < 0 || next.getBar() != ngor.getBar())
                    tokens.append(">,");
                sentence.add(new TokenGroup(ngor.getStart(), ngor.getStaff().getKey(), v.getKey(), tokens.toString()));
            });
        });

        StringBuilder combined = new StringBuilder("bos,");
        int lastStaffId = -1;
        Fraction lastTick = Fraction.getFraction(-1, 1);
        for (TokenGroup group : sentence) {
            if (group.staffId != -1) {  // ignore bars
                if (group.tick.compareTo(lastTick) > 0) {
                    combined.append(group.staffId == 0 ? "T," : "L,");  // treble staff, lower staff
                    lastTick = group.tick;
                    lastStaffId = group.staffId;
                }
                else if (group.staffId != lastStaffId) {
                    combined.append("&,");
                    lastStaffId = group.staffId;
                }
            }
            combined.append(group.tokens);
        }
        combined.append("eos");
        this.sentence = combined.toString().replace("bos,|,", "bos,");  // remove redundant bar token at bos
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

    private static void tokenizeClef(Set<TokenGroup> sentence, ClefRange range, Fraction tick, int staffId) {
        switch (range.getClef()) {
            case TREBLE -> sentence.add(new TokenGroup(tick, staffId, -10, "G,"));
            case BASS -> sentence.add(new TokenGroup(tick, staffId, -10, "F,"));
            default -> throw new IllegalArgumentException("Invalid clef: " + range.getClef());
        }
    }
    private static void tokenizeKey(Set<TokenGroup> sentence, TonalityRange prior, TonalityRange range, Fraction tick, int staffId) {
        StringBuilder tokens = new StringBuilder();
        Tonality tonality = range.getTonality();
        if (tonality.getFifths() > 0) {
            tokens.append("#,".repeat(range.getTonality().getFifths()));
        }
        else if (tonality.getFifths() < 0) {
            tokens.append("b,".repeat(-range.getTonality().getFifths()));
        }
        else if (prior != null) {
            tokens.append("n,".repeat(Math.abs(prior.getTonality().getFifths())));
        }
        sentence.add(new TokenGroup(tick, staffId, -9, tokens.toString()));
    }
    private static void tokenizeTime(Set<TokenGroup> sentence, TimeSignatureRange range, Fraction tick, int staffId) {
        TimeSignature time = range.getTimeSignature();
        if (time.isFree())
            throw new IllegalArgumentException("Free time signature not supported");
        /*else if (time.isAllaSemibrevis())
            sentence.add(new TokenGroup(tick, staffId, -8, "c"));
        else if (time.isAllaBreve())
            sentence.add(new TokenGroup(tick, staffId, -8, "/c"));*/
        else {
            char[] characters = time.getFraction().toString().toCharArray();
            StringBuilder tokens = new StringBuilder();
            for (char c : characters)
                tokens.append(c).append(",");
            sentence.add(new TokenGroup(tick, staffId, -8, tokens.toString()));
        }
    }
    private static void tokenizeShift(Set<TokenGroup> sentence, OctaveShiftRange range, Fraction tick, int staffId, boolean start) {
        int voiceId = start ? -7 : 100; // apply start before and end after groups
        switch (range.getOctavation()) {
            case O8va  -> sentence.add(new TokenGroup(tick, staffId, voiceId, "va,"));
            case O8vb  -> sentence.add(new TokenGroup(tick, staffId, voiceId, "vb,"));
            case O15ma -> sentence.add(new TokenGroup(tick, staffId, voiceId, "ma,"));
            case O15mb -> sentence.add(new TokenGroup(tick, staffId, voiceId, "mb,"));
            default -> throw new IllegalArgumentException("Invalid octave shift: " + range.getOctavation());
        }
    }

    private static void tokenizeBeam(StringBuilder tokens, NoteGroupOrRest ngor) {
        Beam beam = ngor.getBeam();
        if (beam != null) {
            if (beam.getStart().equals(ngor.getStart()))
                tokens.append("[,");
            else if (beam.getEnd().equals(ngor.getStart()))
                tokens.append("],");
            else
                tokens.append("+,");
        }
    }
}
