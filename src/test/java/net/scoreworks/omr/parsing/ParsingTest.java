package net.scoreworks.omr.parsing;

import jakarta.xml.bind.JAXBException;
import net.scoreworks.music.model.Score;
import net.scoreworks.xml.XmlExport;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ParsingTest {
    @Test
    public void interpret() throws FileNotFoundException, JAXBException {
        String corr = "|TGbbbbbbd[f1s4&Fbbbbbbd[f2s0Ldf2s4s9Tdf2s9s11.&d]f2s7s11Lr4Td]f3s8s10Td[f1s8s10&d[f2s2Ldf2s7s11Td]f1s7s9&d]f2s9s14Lr4|";//Td[f1s7s9&u[f2s7ds3Luf2s12Tdf2s7s8.&uf2s10Lu]f2s7Td]f3s5s7Td[f1s5s7&uns7ds-2Td]f1s4s6|";
        String pred = "|TGbbbbbbd[f1s4&Fbbbbbbd[f2s0Ldf2s4s9Tdf2s9s11.&d]f2s7s11Td]f3s8s10&r4Td[f1s8s10&d[f2s2Ldf2s7s11Td]f1s7s9&d]f2s9s14Lr4|";//Td[f1s7s9&u[f2s7ds3Luf2s12Tdf2s7s8.&uf2s10Lu]f2s7Td]f3s5s7Td[f1s5s7&uns7ds-2Td]f1s4s6|";
        Interpreter interpreter = new Interpreter(pred);
        Score score = interpreter.getScore();
        XmlExport export = new XmlExport(score);
        export.writeToFile(new FileOutputStream("src/test/java/out.musicxml"));
    }

    @Test
    public void testBellaCiao() {
        new Interpreter("|TG#4/4r3&F#4/4r1Tu[f1s-3Tuf1s0Tu]f1s1|:Tu[f1s2&u[f1s-2Tu]f1s0(&uf1s5s7Tu)s0&uf1s-5Lu]f1s5s7Tr3&u[f1s-2Tu[f1s-3&uf1s5s7Tuf1s0&uf1s-5Tu]f1s1&u]f1s5s7|Tu[f1s2&u[f1s-2Tu]f1s0(&uf1s5s7Tu)s0&uf1s-5Lu]f1s5s7Tr3&u[f1s-2Tu[f1s-3&uf1s5s7Tuf1s0&uf1s-5Tu]f1s1&u]f1s5s7|Tus0s2&u[f1s-2Luf1s5s7Tu[f1s1&uf1s-5Tu]f1s0&u]f1s5s7Tus-1s2&u[f1s-3Luf1s4s6Tu[f1s1&uf1s-3Tu]f1s0&u]f1s4s6|Tus-2s0s4&u[f1s-4Luf1s3s5Tus-2s0s4&uf1s-4Lu]f1s3s5Tus-3#s-1s4&u[f1s-5Luf1s2#s4Tu[f1s1s3&uf1s-5Tu]f1s2s4&u]f1s2s4|TG#u[f1s0s5&F#u[f1s-6Tu]f1s0(s5(&uf1s3s5Tu)s0)s5&uf1s-2Lu]f1s3s5Tr3&u[f1s-6Tu[f1s2s5s7&uf1s3s5Tuf1s1s4s6&uf1s-4Tu]f1s0s3s5&u]f1s3s5|Tu[f1s1s5s7&u[f1s-2Tu]f1s0(s4(s6(&uf1s5s7Tu)s0)s4)s6&uf1s-5Lu]f1s5s7Tr2&u[f1s-2Luf1s5s7Tu[f1s1s3&uf1s-5Tu]f1s0s2&u]f1s5s7|Tu#s-1s1&u[f1s-1Luf1s2#s4s8Tus1s4&uf1s-5Lu]f1s2s4s8Tus-1s1&u[f1s-1Luf1s2s4s8Tus0s2&uf1s-5Lu]f1s2s4s8|Tuo-3o0&u[f1s-2Luf1s5s7Luf1s-5Lu]f1s5s7Tr3&u[f1s-2Tu[f1s-3&uf1s5s7Tuf1s0&uf1s-5Tu]f1s1&u]f1s5s7:|TG#uo-3o0.&F#u[f1s-2Luf1s5s7Luf1s-5Lu]f1s5s7Lu[f1s-2Luf1s5s7Tds4s7&uf1s-5Lu]f1s5s7|Tbbbbdo5o8&bbbbu[f1s-1Luf1s6s8Luf1s-4Lu]f1s6s8Tr3&u[f1s-1Tu[f1s-2&uf1s6s8Tuf1s1&uf1s-4Tu]f1s2&u]f1s6s8|:Tu[f1s3&u[f1s-1Tu]f1s1(&uf1s6s8Tu)s1&uf1s-4Lu]f1s6s8Tr3&u[f1s-1Tu[f1s-2&uf1s6s8Tuf1s1&uf1s-4Tu]f1s2&u]f1s6s8|Tu[f1s3&u[f1s-1Tu]f1s1(&uf1s6s8Tu)s1&uf1s-4Lu]f1s6s8Tr3&u[f1s-1Tu[f1s-2&uf1s6s8Tuf1s1&uf1s-4Tu]f1s2&u]f1s6s8|Tus1s3&u[f1s-1Luf1s6s8Tu[f1s2&uf1s-4Tu]f1s1&u]f1s6s8Tus0s3&u[f1s-2Luf1s5s7Tu[f1s2&uf1s-2Tu]f1s1&u]f1s5s7|TGbbbbus-1s1s5&Fbbbbu[f1s-3Luf1s4s6Tus-1s1s5&uf1s-3Lu]f1s4s6Tus-2ns0s5&u[f1s-4Luf1s3ns5Tu[f1s2s4&uf1s-4Tu]f1s3s5&u]f1s3s5|Tu[f1s1s6&u[f1s-5Tu]f1s1(s6(&uf1s4s6Tu)s1)s6&uf1s-1Lu]f1s4s6Tr3&u[f1s-5Td[f1s3s6s8&uf1s4s6Tdf1s2s5s7&uf1s-3Td]f1s1s4s6&u]f1s4s6|Td[f1s2s6s8&u[f1s-1Td]f1s1(s5(s7(&uf1s6s8Td)s1)s5)s7&uf1s-4Lu]f1s6s8Tr2&u[f1s-1Luf1s6s8Tu[f1s2s4&uf1s-4Tu]f1s1s3&u]f1s6s8|Tuns0s2&u[f1s0Luf1s3ns5s9Tus2s5&uf1s-4Lu]f1s3s5s9Tus0s2&u[f1s0Luf1s3s5s9Tus1s3&uf1s-4Lu]f1s3s5s9|TGbbbbuo-2o1&Fbbbbu[f1s-1Luf1s6s8Luf1s-4Lu]f1s6s8Tr3&u[f1s-1Tu[f1s-2&uf1s6s8Tuf1s1&uf1s-4Tu]f1s2&u]f1s6s8:|Tuo-2o1.&u[f1s-1Luf1s6s8Luf1s-4Lu]f1s6s8Lu[f1s-1Luf1s6s8Tds5s8&uf1s-4Lu]f1s6s8|To-2o1&o-1o6|");
    }

    @Test
    public void testPrelude() {
        new Interpreter("|TFbbb4/4ds7s10s12s14&Fbbb4/4us-4s3Tds8s10s12s15&us-8s-1Tu[f1s12s14.+ds7ns9&us-7s0Tu]f2s11s13Tds5s7s10s12&;us-4s0s3|Tds5s8s10s12&us-6s1Tds6s8bs11s13&ubs-10bs-3Tu[f1s10s12.+dbs4s5s7&us-9s-2Tu]f2s9s11Tds3s5s8s10&;us-6s1|Tdns4s6ns9ns11&us-7s0Tdns5s7bs9s10ns12&us-11s-4Tu[f1s14.+ds8s10&us-8s-1Tu]f2s13Tds7s10s12&;us-4s3|Td#s6s10s11&us-3ns1s4Tds7ns9s11s14&us-7s0TGu[f1ns4.+ds-2s-1#s1&us-10s-3Tu]f2ns3Tus-3s-1s2&;us-7s0|TGbbbubs0s2bs7&Fbbbus-4s3Tus0bs3s7&ds3s10Tus-1s6+d[f1s3.&dns2ns9Td]f2#s1Tus-1s2s6&;dbs2bs9|Tus-2s2s5&dns1ns8Tus-2s-1#s1s6&dbs1bs8Tu[f1s-1s2ns4.&us0s7Tu]f2s-2ns3Tuns-3s-1s2&uns-1ns6|Tus-2s2s5&us-2s5Tus-4s-2bs3&us-1s6Tu[f1s2.+ds-5s-1&uns-5ns2Tu]f2s1Tus-5s-2s0&;us-4s3TF|Tds5s8s10s12&us-6s1Tds6s8bs11s13&ubs-10bs-3Tu[f1s12.+ds6s7ns9&us-7s0Tu]f2ns11Tds5s7s10&;us-11s-4TG|TGbbbubs0s2bs7&Fbbbus-4s3Tus0bs3s7&ds3s10Tus-1s6+d[f1s3.&dns2ns9Td]f2#s1Tus-1s2s6&;dbs2bs9|Tus-2s2s5&dns1ns8Tus-2s-1#s1s6&dbs1bs8Tu[f1s-1s2ns4.&us0s7Tu]f2s-2ns3Tuns-3s-1s2&uns-1ns6|Tus-2s2s5&us-2s5Tus-4s-2bs3&us-1s6Tu[f1s2.+ds-5s-1&uns-5ns2Tu]f2s1Tus-5s-2s0&;us-4s3TF|Tds5s8s10s12&us-6s1Tds6s8bs11s13&ubs-10bs-3Tu[f1s12.+ds6s7ns9&us-7s0Tu]f2ns11Tds5s7s10&;us-11s-4TG|To-2o0o2o5&o3o7|");
    }


    /*@Test
    public void testDataset() throws XmlPullParserException, CorruptXmlException, IOException {
        Path path = Paths.get("src", "test", "resources");
        parseDirectoryRecursively(path.toFile());
    }*/

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
