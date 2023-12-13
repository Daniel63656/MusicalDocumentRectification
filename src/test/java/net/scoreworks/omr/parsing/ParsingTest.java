package net.scoreworks.omr.parsing;

import jakarta.xml.bind.JAXBException;
import net.scoreworks.music.model.Score;
import net.scoreworks.omr.parsing.antlr.MusicScriptLexer;
import net.scoreworks.omr.parsing.antlr.MusicScriptParser;
import net.scoreworks.xml.CorruptXmlException;
import net.scoreworks.xml.XmlExport;
import net.scoreworks.xml.XmlImport;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xmlpull.v1.XmlPullParserException;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ParsingTest {

    @Test
    public void testDataset() throws XmlPullParserException, CorruptXmlException, IOException {
        Path path = Paths.get("src", "test", "resources");
        parseDirectoryRecursively(path.toFile());
    }

    @Test
    public void testOneSong() throws XmlPullParserException, CorruptXmlException, IOException, JAXBException {
        Score score = new XmlImport().skipRepetitions(true).decodeXML(Paths.get("src/test/resources/Bella Ciao.musicxml"));
        Tokenizer tokenizer = new Tokenizer(score);

        String sentence = tokenizer.getSentence().replace(",", "");
        System.out.println(sentence);
    }

    @Test
    public void testTokenizationWithLineBreaks() throws XmlPullParserException, CorruptXmlException, IOException {
        Score score = new XmlImport().skipRepetitions(true).decodeXML(Paths.get("src/test/resources/Bella Ciao.musicxml"));
        Set<Integer> lineBreaks = new HashSet<>();
        lineBreaks.add(0);
        lineBreaks.add(5);
        lineBreaks.add(9);
        lineBreaks.add(14);
        lineBreaks.add(18);
        Tokenizer tokenizer = new Tokenizer(score, lineBreaks);

        String sentence = tokenizer.getSentence().replace(",", "");
        Assertions.assertEquals(5, StringUtils.countMatches(sentence, "bos"));
        String[] systems = sentence.split("\n");
        for (String system : systems) {
            Assertions.assertEquals(2, StringUtils.countMatches(system, "<"));
            Assertions.assertEquals(2, StringUtils.countMatches(system, ">"));
            System.out.println(system);
        }
    }

    @Test
    public void teeerks() throws XmlPullParserException, CorruptXmlException, IOException {
        Score score = new XmlImport().skipRepetitions(true).decodeXML(Paths.get("src/test/resources/Bach_Prelude_bwv_865.musicxml"));
        Set<Integer> lineBreaks = new HashSet<>();
        lineBreaks.add(0);
        lineBreaks.add(3);
        lineBreaks.add(5);
        lineBreaks.add(7);
        lineBreaks.add(9);
        lineBreaks.add(11);
        lineBreaks.add(13);
        lineBreaks.add(15);
        lineBreaks.add(17);
        lineBreaks.add(19);
        lineBreaks.add(21);
        lineBreaks.add(23);
        lineBreaks.add(25);
        lineBreaks.add(27);
        Tokenizer tokenizer = new Tokenizer(score, lineBreaks);

        String sentence = tokenizer.getSentence().replace(",", "");
        String[] systems = sentence.split("\n");
        for (String system : systems) {
            System.out.println(system);
        }
    }

    @Test
    public void interpret() throws JAXBException, FileNotFoundException {
        String[] args = {"bosTgclefupl0#l1.&fclefwl-12l-5eos", "output.musicxml"};
        Interpreter.main(args);
    }



    private void parseDirectoryRecursively(File dir) throws XmlPullParserException, CorruptXmlException, IOException {
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isDirectory()) {
                parseDirectoryRecursively(file);
            }
            else {
                System.out.println(">>>Doing: "+file);
                Score score = new XmlImport().skipRepetitions(true).decodeXML(file.toPath());
                Set<Integer> lineBreaks = new HashSet<>();
                Tokenizer tokenizer = new Tokenizer(score, lineBreaks);

                String sentence = tokenizer.getSentence().replace(",", "");
                //System.out.println(sentence);

                MusicScriptLexer lexer = new MusicScriptLexer(CharStreams.fromString(sentence));
                MusicScriptParser parser = new MusicScriptParser(new CommonTokenStream(lexer));
                Interpreter interpreter = new Interpreter();
                parser.addParseListener(interpreter);
                parser.bar(); //do the parsing
                score = interpreter.getScore();

                Tokenizer tokenizer2 = new Tokenizer(score, lineBreaks);
                //Assertions.assertEquals(sentence, tokenizer2.getSentence().replace(",", ""));
            }
        }
    }
}
