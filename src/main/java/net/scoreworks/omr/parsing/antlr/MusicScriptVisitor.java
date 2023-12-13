// Generated from C:/Users/Daniel/AppDevelopment/scoreworks/OpticalMusicRecognition/src/main/java/net/scoreworks/omr/parsing/MusicScript.g4 by ANTLR 4.13.1
package net.scoreworks.omr.parsing.antlr;
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
	 * Visit a parse tree produced by {@link MusicScriptParser#bar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBar(MusicScriptParser.BarContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#event}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent(MusicScriptParser.EventContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#staff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaff(MusicScriptParser.StaffContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(MusicScriptParser.GroupContext ctx);
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
	 * Visit a parse tree produced by {@link MusicScriptParser#meta}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeta(MusicScriptParser.MetaContext ctx);
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
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#ottavastart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOttavastart(MusicScriptParser.OttavastartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MusicScriptParser#ottavaend}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOttavaend(MusicScriptParser.OttavaendContext ctx);
}