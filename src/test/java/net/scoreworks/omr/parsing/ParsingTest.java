package net.scoreworks.omr.parsing;

import jakarta.xml.bind.JAXBException;
import net.scoreworks.music.model.Score;
import net.scoreworks.xml.XmlExport;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ParsingTest {

    /*@Test
    public void testDataset() throws XmlPullParserException, CorruptXmlException, IOException {
        Path path = Paths.get("src", "test", "resources");
        parseDirectoryRecursively(path.toFile());
    }*/

    @Test
    public void interpret() throws FileNotFoundException, JAXBException {
        Interpreter interpreter = new Interpreter("|TG#4/4r3&F#4/4r1Tu[f1s-3Tuf1s0Tu]f1s1|:Tu[f1s2&u[f1s-2Tu]f1s0(&uf1s5s7Tu)s0&uf1s-5Lu]f1s5s7Tr3&u[f1s-2Tu[f1s-3&uf1s5s7Tuf1s0&uf1s-5Tu]f1s1&u]f1s5s7|Tu[f1s2&u[f1s-2Tu]f1s0(&uf1s5s7Tu)s0&uf1s-5Lu]f1s5s7Tr3&u[f1s-2Tu[f1s-3&uf1s5s7Tuf1s0&uf1s-5Tu]f1s1&u]f1s5s7|Tus0s2&u[f1s-2Luf1s5s7Tu[f1s1&uf1s-5Tu]f1s0&u]f1s5s7Tus-1s2&u[f1s-3Luf1s4s6Tu[f1s1&uf1s-3Tu]f1s0&u]f1s4s6|Tus-2s0s4&u[f1s-4Luf1s3s5Tus-2s0s4&uf1s-4Lu]f1s3s5Tus-3#s-1s4&u[f1s-5Luf1s2#s4Tu[f1s1s3&uf1s-5Tu]f1s2s4&u]f1s2s4|");
        Score score = interpreter.getScore();
        XmlExport export = new XmlExport(score);
        export.writeToFile(new FileOutputStream("src/test/java/out.musicxml"));
    }



    /*private void parseDirectoryRecursively(File dir) throws XmlPullParserException, CorruptXmlException, IOException {
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
                parser.score(); //do the parsing
                score = interpreter.getScore();

                Tokenizer tokenizer2 = new Tokenizer(score, lineBreaks);
                //Assertions.assertEquals(sentence, tokenizer2.getSentence().replace(",", ""));
            }
        }
    }*/
}
