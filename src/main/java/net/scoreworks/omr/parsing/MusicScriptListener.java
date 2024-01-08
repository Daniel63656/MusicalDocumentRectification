// Generated from C:/Users/Daniel/AppDevelopment/scoreworks/OpticalMusicRecognition/src/main/java/net/scoreworks/omr/parsing/MusicScript.g4 by ANTLR 4.13.1
package net.scoreworks.omr.parsing;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MusicScriptParser}.
 */
public interface MusicScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#score}.
	 * @param ctx the parse tree
	 */
	void enterScore(MusicScriptParser.ScoreContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#score}.
	 * @param ctx the parse tree
	 */
	void exitScore(MusicScriptParser.ScoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#event}.
	 * @param ctx the parse tree
	 */
	void enterEvent(MusicScriptParser.EventContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#event}.
	 * @param ctx the parse tree
	 */
	void exitEvent(MusicScriptParser.EventContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#segment}.
	 * @param ctx the parse tree
	 */
	void enterSegment(MusicScriptParser.SegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#segment}.
	 * @param ctx the parse tree
	 */
	void exitSegment(MusicScriptParser.SegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(MusicScriptParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(MusicScriptParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#rest}.
	 * @param ctx the parse tree
	 */
	void enterRest(MusicScriptParser.RestContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#rest}.
	 * @param ctx the parse tree
	 */
	void exitRest(MusicScriptParser.RestContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#chord}.
	 * @param ctx the parse tree
	 */
	void enterChord(MusicScriptParser.ChordContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#chord}.
	 * @param ctx the parse tree
	 */
	void exitChord(MusicScriptParser.ChordContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#note_open}.
	 * @param ctx the parse tree
	 */
	void enterNote_open(MusicScriptParser.Note_openContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#note_open}.
	 * @param ctx the parse tree
	 */
	void exitNote_open(MusicScriptParser.Note_openContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#note_solid}.
	 * @param ctx the parse tree
	 */
	void enterNote_solid(MusicScriptParser.Note_solidContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#note_solid}.
	 * @param ctx the parse tree
	 */
	void exitNote_solid(MusicScriptParser.Note_solidContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#accidental}.
	 * @param ctx the parse tree
	 */
	void enterAccidental(MusicScriptParser.AccidentalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#accidental}.
	 * @param ctx the parse tree
	 */
	void exitAccidental(MusicScriptParser.AccidentalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(MusicScriptParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(MusicScriptParser.TimeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(MusicScriptParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(MusicScriptParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#barline}.
	 * @param ctx the parse tree
	 */
	void enterBarline(MusicScriptParser.BarlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#barline}.
	 * @param ctx the parse tree
	 */
	void exitBarline(MusicScriptParser.BarlineContext ctx);
}