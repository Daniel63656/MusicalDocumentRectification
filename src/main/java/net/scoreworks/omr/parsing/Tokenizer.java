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

    public Tokenizer(Score score, int numMeasures, List<Integer> systemLineBreaks) {
        //assert numMeasures == score.getTrack(0).getStaff(0).getBars().count() : "Number of measures disagree";
        Set<TokenGroup> sentence = new TreeSet<>();

        //add meta events
        score.getStaffs().forEach(s -> {
            // add bars only once (first and last barline will be omitted))
            if (s.getKey() == 0)
                s.getBars().forEach(b -> sentence.add(new TokenGroup(b.getStart(), -1, -1, "|,")));
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

        //add line break each system and context if not changing anyway
        for (int i : systemLineBreaks) {
            score.getStaffs().forEach(s -> {
                Bar bar = s.getBarByBarNumber(i);
                sentence.add(new TokenGroup(bar.getStart(), -1, -2, "eos\nbos,"));
                Fraction tick = bar.getStart();
                tokenizeClef(sentence, s.getClefRange(tick), tick, s.getKey());
                tokenizeKey(sentence, null, s.getTonalityRange(tick), tick, s.getKey());
                // time signature is not added at system breaks
                if (s.getOctaveShiftRange(tick) != null)
                    tokenizeShift(sentence, s.getOctaveShiftRange(tick), tick, s.getKey(), true);
            });
        }

        // add NoteGroupOrRest from voices
        score.getVoices().forEach(v -> v.getNoteGroupOrRests().forEach(ngor -> {
            StringBuilder tokens = new StringBuilder();
            // check for voice start
            NoteGroupOrRest prior = v.lowerNoteGroupOrRest(ngor.getStart());
            if (prior == null || prior.getEnd().compareTo(ngor.getStart()) < 0)
                tokens.append("<,");
            // go on with Rest or NoteGroup
            if (ngor instanceof Rest) {
                tokens.append("r").append(-ngor.getNoteType().getBase2Exponent()).append(",");
                tokenizeBeam(tokens, ngor);
            }
            else {
                NoteGroup ng = (NoteGroup) ngor;
                if (ngor.getNoteType() == NoteType.WHOLE)
                    tokens.append("w,");
                else if (ngor.getNoteType() == NoteType.HALF)
                    tokens.append("h,");
                int base2exp = ngor.getNoteType().getBase2Exponent();
                if (base2exp < 0) {
                    // stem
                    if (ng.getStem() == Stem.UP)
                        tokens.append("up,");
                    else
                        tokens.append("dn,");
                    if (base2exp < -2) {
                        tokenizeBeam(tokens, ngor);
                        tokens.append("f").append(-base2exp - 2).append(",");
                    }
                }
                // notes
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
                    int referenceLine = Controller.getReferenceLine(ngor.getClefRange().getClef(), ngor.getOctaveShiftRange(), note.getNoteName(), note.getOctaveRegion());
                    tokens.append("l").append(referenceLine).append(",");
                    if (note.getNextTied() != null)
                        tokens.append("(,");
                }
            }
            // continue with similar tokens again
            tokens.append(".,".repeat(ngor.getDots()));
            //check for voice end
            NoteGroupOrRest next = v.higherNoteGroupOrRest(ngor.getStart());
            if (next == null || ngor.getEnd().compareTo(next.getStart()) < 0)
                tokens.append(">,");
            sentence.add(new TokenGroup(ngor.getStart(), ngor.getStaff().getKey(), v.getKey(), tokens.toString()));
        }));

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
        List<Integer> systemLineBreaks = new ArrayList<>();
        for (int i=4; i<args.length; i++)   //ignore trivial first system bar = 0
            systemLineBreaks.add(Integer.parseInt(args[i]));
        // load score and tokenize
        Score score = new XmlImport().skipRepetitions(true).decodeXML(Paths.get(args[0]));
        Tokenizer tokenizer = new Tokenizer(score, Integer.parseInt(args[2]), systemLineBreaks);

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
            case TREBLE -> sentence.add(new TokenGroup(tick, staffId, -10, "gclef,"));
            case BASS -> sentence.add(new TokenGroup(tick, staffId, -10, "fclef,"));
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
        char[] characters = time.getFraction().toString().toCharArray();
        StringBuilder tokens = new StringBuilder();
        for (char c : characters)
            tokens.append(c).append(",");
        sentence.add(new TokenGroup(tick, staffId, -8, tokens.toString()));
    }
    private static void tokenizeShift(Set<TokenGroup> sentence, OctaveShiftRange range, Fraction tick, int staffId, boolean start) {
        int voiceId = start ? -7 : 100; // apply start before and end after groups
        switch (range.getOctavation()) {
            case O8va -> sentence.add(new TokenGroup(tick, staffId, voiceId, "8va,"));
            case O8vb -> sentence.add(new TokenGroup(tick, staffId, voiceId, "8vb,"));
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
                tokens.append("=,");
        }
    }
}
