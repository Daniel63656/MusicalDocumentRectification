// Generated from C:/Users/Daniel/AppDevelopment/scoreworks/OpticalMusicRecognition/src/main/java/net/scoreworks/omr/parsing/MusicScript.g4 by ANTLR 4.13.1
package net.scoreworks.omr.parsing;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MusicScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MusicScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#track}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrack(MusicScriptParser.TrackContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent(MusicScriptParser.EventContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#stafflet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStafflet(MusicScriptParser.StaffletContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#voicelet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoicelet(MusicScriptParser.VoiceletContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(MusicScriptParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#tuplet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTuplet(MusicScriptParser.TupletContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#rest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRest(MusicScriptParser.RestContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#chord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChord(MusicScriptParser.ChordContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#note_open}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote_open(MusicScriptParser.Note_openContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#note_solid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote_solid(MusicScriptParser.Note_solidContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#accidental}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccidental(MusicScriptParser.AccidentalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#barline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBarline(MusicScriptParser.BarlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#time}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTime(MusicScriptParser.TimeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#key}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKey(MusicScriptParser.KeyContext ctx);
}