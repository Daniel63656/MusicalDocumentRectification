package net.scoreworks.omr.parsing;

import net.scoreworks.music.model.Score;
import net.scoreworks.omr.parsing.antlr.MusicScriptLexer;
import net.scoreworks.omr.parsing.antlr.MusicScriptParser;
import net.scoreworks.xml.CorruptXmlException;
import net.scoreworks.xml.XmlImport;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParsingTest {

    @Test
    public void testTokenizer() throws XmlPullParserException, CorruptXmlException, IOException {
        Score score = new XmlImport().skipRepetitions(true).decodeXML(Paths.get("src/test/resources/Bella Ciao.musicxml"));
        List<Integer> lineBreaks = new ArrayList<>();
        Tokenizer tokenizer = new Tokenizer(score, 21, lineBreaks);

        String sentence = tokenizer.getSentence().replace(",", "");
        System.out.println(sentence);

        MusicScriptLexer lexer = new MusicScriptLexer(CharStreams.fromString(sentence));
        MusicScriptParser parser = new MusicScriptParser(new CommonTokenStream(lexer));
        Interpreter interpreter = new Interpreter();
        parser.addParseListener(interpreter);
        parser.score(); //do the parsing
        score = interpreter.getScore();

        Tokenizer tokenizer2 = new Tokenizer(score, 21, lineBreaks);
        System.out.println(tokenizer2.getSentence().replace(",", ""));


        parser.score();
        System.out.println("done");
    }
}
