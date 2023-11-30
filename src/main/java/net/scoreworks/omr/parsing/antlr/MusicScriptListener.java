// Generated from C:/Users/Daniel/AppDevelopment/scoreworks/OpticalMusicRecognition/src/main/java/net/scoreworks/omr/parsing/MusicScript.g4 by ANTLR 4.13.1
package net.scoreworks.omr.parsing.antlr;
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
	 * Enter a parse tree produced by {@link MusicScriptParser#staff}.
	 * @param ctx the parse tree
	 */
	void enterStaff(MusicScriptParser.StaffContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#staff}.
	 * @param ctx the parse tree
	 */
	void exitStaff(MusicScriptParser.StaffContext ctx);
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
	 * Enter a parse tree produced by {@link MusicScriptParser#note}.
	 * @param ctx the parse tree
	 */
	void enterNote(MusicScriptParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#note}.
	 * @param ctx the parse tree
	 */
	void exitNote(MusicScriptParser.NoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#meta}.
	 * @param ctx the parse tree
	 */
	void enterMeta(MusicScriptParser.MetaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#meta}.
	 * @param ctx the parse tree
	 */
	void exitMeta(MusicScriptParser.MetaContext ctx);
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
	 * Enter a parse tree produced by {@link MusicScriptParser#ottavastart}.
	 * @param ctx the parse tree
	 */
	void enterOttavastart(MusicScriptParser.OttavastartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#ottavastart}.
	 * @param ctx the parse tree
	 */
	void exitOttavastart(MusicScriptParser.OttavastartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#ottavaend}.
	 * @param ctx the parse tree
	 */
	void enterOttavaend(MusicScriptParser.OttavaendContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#ottavaend}.
	 * @param ctx the parse tree
	 */
	void exitOttavaend(MusicScriptParser.OttavaendContext ctx);
}