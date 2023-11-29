package net.scoreworks.omr.parsing;

import net.scoreworks.xml.CorruptXmlException;
import org.junit.jupiter.api.Test;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class TokenizerTest {

    @Test
    public void testTokenizer() throws XmlPullParserException, CorruptXmlException, IOException {
        Tokenizer.main(new String[]{"src/test/resources/Bella Ciao.musicxml", "src/test/java/out.txt", "21", "0", "5", "9", "14", "18"});
    }
}
