package net.scoreworks.omr.parsing;

import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class InterpreterTest {

    @Test
    public void testInterpreter() throws JAXBException, FileNotFoundException {
        Interpreter interpreter = new Interpreter();
        interpreter.onBarLine();
        interpreter.onStaff("T");
        interpreter.onClef("gclef");
        List<Token> tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.DIGIT, "4"));
        tokens.add(new Token(Terminal.SLASH, "/"));
        tokens.add(new Token(Terminal.DIGIT, "4"));
        interpreter.onTime(tokens);

        tokens = new ArrayList<>();
        interpreter.onNewVoice();
        tokens.add(new Token(Terminal.NAME, "C"));
        tokens.add(new Token(Terminal.OCTV, "4"));
        interpreter.onNote(tokens);
        tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.WHOLE, "whole"));
        interpreter.onChord(tokens);

        interpreter.onStaff("&");
        interpreter.onClef("fclef");
        tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.DIGIT, "4"));
        tokens.add(new Token(Terminal.SLASH, "/"));
        tokens.add(new Token(Terminal.DIGIT, "4"));
        interpreter.onTime(tokens);

        tokens = new ArrayList<>();
        interpreter.onNewVoice();
        tokens.add(new Token(Terminal.NAME, "F"));
        tokens.add(new Token(Terminal.OCTV, "3"));
        interpreter.onNote(tokens);
        tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.WHOLE, "whole"));
        interpreter.onChord(tokens);

        interpreter.onBarLine();

        interpreter.onStaff("T");
        tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.NAME, "D"));
        tokens.add(new Token(Terminal.OCTV, "4"));
        interpreter.onNote(tokens);
        tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.STEM, "up"));
        interpreter.onChord(tokens);

        interpreter.onStaff("&");
        tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.NAME, "C"));
        tokens.add(new Token(Terminal.OCTV, "3"));
        interpreter.onNote(tokens);
        tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.HALF, "half"));
        tokens.add(new Token(Terminal.STEM, "up"));
        interpreter.onChord(tokens);

        interpreter.onStaff("T");
        tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.NAME, "D"));
        tokens.add(new Token(Terminal.OCTV, "4"));
        interpreter.onNote(tokens);
        tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.STEM, "up"));
        interpreter.onChord(tokens);

        interpreter.onStaff("T");
        tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.REST, "r1"));
        interpreter.onRest(tokens);

        interpreter.onStaff("&");
        tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.NAME, "E"));
        tokens.add(new Token(Terminal.OCTV, "2"));
        interpreter.onNote(tokens);
        tokens = new ArrayList<>();
        tokens.add(new Token(Terminal.HALF, "half"));
        tokens.add(new Token(Terminal.STEM, "up"));
        interpreter.onChord(tokens);

        interpreter.exportToMusicxml("src/test/java/out.musicxml");
    }
}
