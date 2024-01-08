// Generated from C:/Users/Daniel/AppDevelopment/scoreworks/OpticalMusicRecognition/src/main/java/net/scoreworks/omr/parsing/MusicScript.g4 by ANTLR 4.13.1
package net.scoreworks.omr.parsing;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MusicScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, REPEAT=8, BARL=9, 
		NEWV=10, SKPV=11, GRACE=12, REST=13, DOT=14, TIE_START=15, TIE_END=16, 
		FLAG=17, BEAM=18, TUPL=19, STEM=20, NOTE_OPEN=21, NOTE_SOLID=22, SHARP=23, 
		FLAT=24, NATURAL=25, CLEF=26, DIGIT=27, SLASH=28, OTTV=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "REPEAT", "BARL", 
			"NEWV", "SKPV", "GRACE", "REST", "DOT", "TIE_START", "TIE_END", "FLAG", 
			"BEAM", "TUPL", "STEM", "NOTE_OPEN", "NOTE_SOLID", "SHARP", "FLAT", "NATURAL", 
			"CLEF", "DIGIT", "SLASH", "OTTV"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'T'", "'&'", "'L'", "'x'", "'-'", "'c'", "'/c'", "':'", "'|'", 
			"'+'", "';'", "'g'", null, "'.'", "'('", "')'", null, null, null, null, 
			null, null, "'#'", "'b'", "'n'", null, null, "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "REPEAT", "BARL", "NEWV", 
			"SKPV", "GRACE", "REST", "DOT", "TIE_START", "TIE_END", "FLAG", "BEAM", 
			"TUPL", "STEM", "NOTE_OPEN", "NOTE_SOLID", "SHARP", "FLAT", "NATURAL", 
			"CLEF", "DIGIT", "SLASH", "OTTV"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MusicScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MusicScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001d\u008e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0003\u0014i\b\u0014\u0001\u0014"+
		"\u0004\u0014l\b\u0014\u000b\u0014\f\u0014m\u0001\u0015\u0001\u0015\u0003"+
		"\u0015r\b\u0015\u0001\u0015\u0004\u0015u\b\u0015\u000b\u0015\f\u0015v"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0003\u001c\u008d\b\u001c\u0000\u0000\u001d\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c9\u001d\u0001\u0000\u0006\u0001\u0000"+
		"07\u0001\u000015\u0002\u0000[[]]\u0003\u0000**{{}}\u0002\u0000dduu\u0001"+
		"\u000009\u0094\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0001;\u0001\u0000\u0000"+
		"\u0000\u0003=\u0001\u0000\u0000\u0000\u0005?\u0001\u0000\u0000\u0000\u0007"+
		"A\u0001\u0000\u0000\u0000\tC\u0001\u0000\u0000\u0000\u000bE\u0001\u0000"+
		"\u0000\u0000\rG\u0001\u0000\u0000\u0000\u000fJ\u0001\u0000\u0000\u0000"+
		"\u0011L\u0001\u0000\u0000\u0000\u0013N\u0001\u0000\u0000\u0000\u0015P"+
		"\u0001\u0000\u0000\u0000\u0017R\u0001\u0000\u0000\u0000\u0019T\u0001\u0000"+
		"\u0000\u0000\u001bW\u0001\u0000\u0000\u0000\u001dY\u0001\u0000\u0000\u0000"+
		"\u001f[\u0001\u0000\u0000\u0000!]\u0001\u0000\u0000\u0000#`\u0001\u0000"+
		"\u0000\u0000%b\u0001\u0000\u0000\u0000\'d\u0001\u0000\u0000\u0000)f\u0001"+
		"\u0000\u0000\u0000+o\u0001\u0000\u0000\u0000-x\u0001\u0000\u0000\u0000"+
		"/z\u0001\u0000\u0000\u00001|\u0001\u0000\u0000\u00003~\u0001\u0000\u0000"+
		"\u00005\u0080\u0001\u0000\u0000\u00007\u0082\u0001\u0000\u0000\u00009"+
		"\u008c\u0001\u0000\u0000\u0000;<\u0005T\u0000\u0000<\u0002\u0001\u0000"+
		"\u0000\u0000=>\u0005&\u0000\u0000>\u0004\u0001\u0000\u0000\u0000?@\u0005"+
		"L\u0000\u0000@\u0006\u0001\u0000\u0000\u0000AB\u0005x\u0000\u0000B\b\u0001"+
		"\u0000\u0000\u0000CD\u0005-\u0000\u0000D\n\u0001\u0000\u0000\u0000EF\u0005"+
		"c\u0000\u0000F\f\u0001\u0000\u0000\u0000GH\u0005/\u0000\u0000HI\u0005"+
		"c\u0000\u0000I\u000e\u0001\u0000\u0000\u0000JK\u0005:\u0000\u0000K\u0010"+
		"\u0001\u0000\u0000\u0000LM\u0005|\u0000\u0000M\u0012\u0001\u0000\u0000"+
		"\u0000NO\u0005+\u0000\u0000O\u0014\u0001\u0000\u0000\u0000PQ\u0005;\u0000"+
		"\u0000Q\u0016\u0001\u0000\u0000\u0000RS\u0005g\u0000\u0000S\u0018\u0001"+
		"\u0000\u0000\u0000TU\u0005r\u0000\u0000UV\u0007\u0000\u0000\u0000V\u001a"+
		"\u0001\u0000\u0000\u0000WX\u0005.\u0000\u0000X\u001c\u0001\u0000\u0000"+
		"\u0000YZ\u0005(\u0000\u0000Z\u001e\u0001\u0000\u0000\u0000[\\\u0005)\u0000"+
		"\u0000\\ \u0001\u0000\u0000\u0000]^\u0005f\u0000\u0000^_\u0007\u0001\u0000"+
		"\u0000_\"\u0001\u0000\u0000\u0000`a\u0007\u0002\u0000\u0000a$\u0001\u0000"+
		"\u0000\u0000bc\u0007\u0003\u0000\u0000c&\u0001\u0000\u0000\u0000de\u0007"+
		"\u0004\u0000\u0000e(\u0001\u0000\u0000\u0000fh\u0005o\u0000\u0000gi\u0005"+
		"-\u0000\u0000hg\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0001"+
		"\u0000\u0000\u0000jl\u0007\u0005\u0000\u0000kj\u0001\u0000\u0000\u0000"+
		"lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000"+
		"\u0000n*\u0001\u0000\u0000\u0000oq\u0005s\u0000\u0000pr\u0005-\u0000\u0000"+
		"qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0001\u0000\u0000"+
		"\u0000su\u0007\u0005\u0000\u0000ts\u0001\u0000\u0000\u0000uv\u0001\u0000"+
		"\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000w,\u0001"+
		"\u0000\u0000\u0000xy\u0005#\u0000\u0000y.\u0001\u0000\u0000\u0000z{\u0005"+
		"b\u0000\u0000{0\u0001\u0000\u0000\u0000|}\u0005n\u0000\u0000}2\u0001\u0000"+
		"\u0000\u0000~\u007f\u0002FG\u0000\u007f4\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0007\u0005\u0000\u0000\u00816\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005/\u0000\u0000\u00838\u0001\u0000\u0000\u0000\u0084\u0085\u0005v"+
		"\u0000\u0000\u0085\u008d\u0005a\u0000\u0000\u0086\u0087\u0005v\u0000\u0000"+
		"\u0087\u008d\u0005b\u0000\u0000\u0088\u0089\u0005m\u0000\u0000\u0089\u008d"+
		"\u0005a\u0000\u0000\u008a\u008b\u0005m\u0000\u0000\u008b\u008d\u0005b"+
		"\u0000\u0000\u008c\u0084\u0001\u0000\u0000\u0000\u008c\u0086\u0001\u0000"+
		"\u0000\u0000\u008c\u0088\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000"+
		"\u0000\u0000\u008d:\u0001\u0000\u0000\u0000\u0006\u0000hmqv\u008c\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}