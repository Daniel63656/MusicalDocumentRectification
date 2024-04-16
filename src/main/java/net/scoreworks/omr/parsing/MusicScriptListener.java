// Generated from C:/Users/Daniel/AppDevelopment/scoreworks/OpticalMusicRecognition/src/main/java/net/scoreworks/omr/parsing/MusicScript.g4 by ANTLR 4.13.1
package net.scoreworks.omr.parsing;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MusicScriptParser}.
 */
public interface MusicScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#track}.
	 * @param ctx the parse tree
	 */
	void enterTrack(MusicScriptParser.TrackContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#track}.
	 * @param ctx the parse tree
	 */
	void exitTrack(MusicScriptParser.TrackContext ctx);
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
	 * Enter a parse tree produced by {@link MusicScriptParser#stafflet}.
	 * @param ctx the parse tree
	 */
	void enterStafflet(MusicScriptParser.StaffletContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#stafflet}.
	 * @param ctx the parse tree
	 */
	void exitStafflet(MusicScriptParser.StaffletContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#voicelet}.
	 * @param ctx the parse tree
	 */
	void enterVoicelet(MusicScriptParser.VoiceletContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#voicelet}.
	 * @param ctx the parse tree
	 */
	void exitVoicelet(MusicScriptParser.VoiceletContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(MusicScriptParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(MusicScriptParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MusicScriptParser#tuplet}.
	 * @param ctx the parse tree
	 */
	void enterTuplet(MusicScriptParser.TupletContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#tuplet}.
	 * @param ctx the parse tree
	 */
	void exitTuplet(MusicScriptParser.TupletContext ctx);
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
	 * Enter a parse tree produced by {@link MusicScriptParser#barline}.
	 * @param ctx the parse tree
	 */
	void enterBarline(MusicScriptParser.BarlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link MusicScriptParser#barline}.
	 * @param ctx the parse tree
	 */
	void exitBarline(MusicScriptParser.BarlineContext ctx);
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
}