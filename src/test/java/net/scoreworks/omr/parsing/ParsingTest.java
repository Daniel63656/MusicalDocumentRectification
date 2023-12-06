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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParsingTest {

    @Test
    public void testDataset() throws XmlPullParserException, CorruptXmlException, IOException {
        Path path = Paths.get("src", "test", "resources");
        parseDirectoryRecursively(path.toFile());
    }

    @Test
    public void testOneSong() throws XmlPullParserException, CorruptXmlException, IOException, JAXBException {
        Score score = new XmlImport().skipRepetitions(true).decodeXML(Paths.get("src/test/resources/In The Hall Of The Mountain King.musicxml"));
        List<Integer> lineBreaks = new ArrayList<>();
        Tokenizer tokenizer = new Tokenizer(score, lineBreaks);

        String sentence = tokenizer.getSentence().replace(",", "");
        System.out.println(sentence);

        MusicScriptLexer lexer = new MusicScriptLexer(CharStreams.fromString(sentence));
        MusicScriptParser parser = new MusicScriptParser(new CommonTokenStream(lexer));
        Interpreter interpreter = new Interpreter();
        parser.addParseListener(interpreter);
        parser.score(); //do the parsing
        score = interpreter.getScore();

        XmlExport export = new XmlExport(score);
        export.writeToFile(new FileOutputStream("src/test/java/out.musicxml"));

        Tokenizer tokenizer2 = new Tokenizer(score, lineBreaks);
        Assertions.assertEquals(sentence, tokenizer2.getSentence().replace(",", ""));
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
                List<Integer> lineBreaks = new ArrayList<>();
                Tokenizer tokenizer = new Tokenizer(score, lineBreaks);

                String sentence = tokenizer.getSentence().replace(",", "");
                //System.out.println(sentence);

                MusicScriptLexer lexer = new MusicScriptLexer(CharStreams.fromString(sentence));
                MusicScriptParser parser = new MusicScriptParser(new CommonTokenStream(lexer));
                Interpreter interpreter = new Interpreter();
                parser.addParseListener(interpreter);
                parser.score(); //do the parsing
                score = interpreter.getScore();

                Tokenizer tokenizer2 = new Tokenizer(score, lineBreaks);
                //Assertions.assertEquals(sentence, tokenizer2.getSentence().replace(",", ""));
            }
        }
    }
}
