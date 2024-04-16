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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, BARL=11, REPEAT=12, NEWV=13, SKPV=14, GRACE=15, REST=16, DOT=17, 
		TIE_START=18, TIE_END=19, FLAG=20, BEAM=21, STEM=22, NOTE_OPEN=23, NOTE_SOLID=24, 
		SHARP=25, FLAT=26, NATURAL=27, CLEF=28, DIGIT=29, SLASH=30, OTTV=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "BARL", "REPEAT", "NEWV", "SKPV", "GRACE", "REST", "DOT", "TIE_START", 
			"TIE_END", "FLAG", "BEAM", "STEM", "NOTE_OPEN", "NOTE_SOLID", "SHARP", 
			"FLAT", "NATURAL", "CLEF", "DIGIT", "SLASH", "OTTV"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'T'", "'&'", "'L'", "'{'", "'}'", "'w'", "'x'", "'-'", "'c'", 
			"'/c'", "'|'", "':'", "'+'", "';'", "'g'", null, "'.'", "'('", "')'", 
			null, null, null, null, null, "'#'", "'b'", "'n'", null, null, "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "BARL", 
			"REPEAT", "NEWV", "SKPV", "GRACE", "REST", "DOT", "TIE_START", "TIE_END", 
			"FLAG", "BEAM", "STEM", "NOTE_OPEN", "NOTE_SOLID", "SHARP", "FLAT", "NATURAL", 
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
		"\u0004\u0000\u001f\u0096\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0002\u001e\u0007\u001e\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0003\u0016"+
		"q\b\u0016\u0001\u0016\u0004\u0016t\b\u0016\u000b\u0016\f\u0016u\u0001"+
		"\u0017\u0001\u0017\u0003\u0017z\b\u0017\u0001\u0017\u0004\u0017}\b\u0017"+
		"\u000b\u0017\f\u0017~\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u0095\b\u001e"+
		"\u0000\u0000\u001f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e=\u001f"+
		"\u0001\u0000\u0005\u0001\u000007\u0001\u000015\u0002\u0000[[]]\u0002\u0000"+
		"dduu\u0001\u000009\u009c\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001"+
		"\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0001?\u0001\u0000\u0000"+
		"\u0000\u0003A\u0001\u0000\u0000\u0000\u0005C\u0001\u0000\u0000\u0000\u0007"+
		"E\u0001\u0000\u0000\u0000\tG\u0001\u0000\u0000\u0000\u000bI\u0001\u0000"+
		"\u0000\u0000\rK\u0001\u0000\u0000\u0000\u000fM\u0001\u0000\u0000\u0000"+
		"\u0011O\u0001\u0000\u0000\u0000\u0013Q\u0001\u0000\u0000\u0000\u0015T"+
		"\u0001\u0000\u0000\u0000\u0017V\u0001\u0000\u0000\u0000\u0019X\u0001\u0000"+
		"\u0000\u0000\u001bZ\u0001\u0000\u0000\u0000\u001d\\\u0001\u0000\u0000"+
		"\u0000\u001f^\u0001\u0000\u0000\u0000!a\u0001\u0000\u0000\u0000#c\u0001"+
		"\u0000\u0000\u0000%e\u0001\u0000\u0000\u0000\'g\u0001\u0000\u0000\u0000"+
		")j\u0001\u0000\u0000\u0000+l\u0001\u0000\u0000\u0000-n\u0001\u0000\u0000"+
		"\u0000/w\u0001\u0000\u0000\u00001\u0080\u0001\u0000\u0000\u00003\u0082"+
		"\u0001\u0000\u0000\u00005\u0084\u0001\u0000\u0000\u00007\u0086\u0001\u0000"+
		"\u0000\u00009\u0088\u0001\u0000\u0000\u0000;\u008a\u0001\u0000\u0000\u0000"+
		"=\u0094\u0001\u0000\u0000\u0000?@\u0005T\u0000\u0000@\u0002\u0001\u0000"+
		"\u0000\u0000AB\u0005&\u0000\u0000B\u0004\u0001\u0000\u0000\u0000CD\u0005"+
		"L\u0000\u0000D\u0006\u0001\u0000\u0000\u0000EF\u0005{\u0000\u0000F\b\u0001"+
		"\u0000\u0000\u0000GH\u0005}\u0000\u0000H\n\u0001\u0000\u0000\u0000IJ\u0005"+
		"w\u0000\u0000J\f\u0001\u0000\u0000\u0000KL\u0005x\u0000\u0000L\u000e\u0001"+
		"\u0000\u0000\u0000MN\u0005-\u0000\u0000N\u0010\u0001\u0000\u0000\u0000"+
		"OP\u0005c\u0000\u0000P\u0012\u0001\u0000\u0000\u0000QR\u0005/\u0000\u0000"+
		"RS\u0005c\u0000\u0000S\u0014\u0001\u0000\u0000\u0000TU\u0005|\u0000\u0000"+
		"U\u0016\u0001\u0000\u0000\u0000VW\u0005:\u0000\u0000W\u0018\u0001\u0000"+
		"\u0000\u0000XY\u0005+\u0000\u0000Y\u001a\u0001\u0000\u0000\u0000Z[\u0005"+
		";\u0000\u0000[\u001c\u0001\u0000\u0000\u0000\\]\u0005g\u0000\u0000]\u001e"+
		"\u0001\u0000\u0000\u0000^_\u0005r\u0000\u0000_`\u0007\u0000\u0000\u0000"+
		"` \u0001\u0000\u0000\u0000ab\u0005.\u0000\u0000b\"\u0001\u0000\u0000\u0000"+
		"cd\u0005(\u0000\u0000d$\u0001\u0000\u0000\u0000ef\u0005)\u0000\u0000f"+
		"&\u0001\u0000\u0000\u0000gh\u0005f\u0000\u0000hi\u0007\u0001\u0000\u0000"+
		"i(\u0001\u0000\u0000\u0000jk\u0007\u0002\u0000\u0000k*\u0001\u0000\u0000"+
		"\u0000lm\u0007\u0003\u0000\u0000m,\u0001\u0000\u0000\u0000np\u0005o\u0000"+
		"\u0000oq\u0005-\u0000\u0000po\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000"+
		"\u0000qs\u0001\u0000\u0000\u0000rt\u0007\u0004\u0000\u0000sr\u0001\u0000"+
		"\u0000\u0000tu\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001"+
		"\u0000\u0000\u0000v.\u0001\u0000\u0000\u0000wy\u0005s\u0000\u0000xz\u0005"+
		"-\u0000\u0000yx\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001"+
		"\u0000\u0000\u0000{}\u0007\u0004\u0000\u0000|{\u0001\u0000\u0000\u0000"+
		"}~\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000"+
		"\u0000\u0000\u007f0\u0001\u0000\u0000\u0000\u0080\u0081\u0005#\u0000\u0000"+
		"\u00812\u0001\u0000\u0000\u0000\u0082\u0083\u0005b\u0000\u0000\u00834"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\u0005n\u0000\u0000\u00856\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0002FG\u0000\u00878\u0001\u0000\u0000\u0000"+
		"\u0088\u0089\u0007\u0004\u0000\u0000\u0089:\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0005/\u0000\u0000\u008b<\u0001\u0000\u0000\u0000\u008c\u008d\u0005"+
		"v\u0000\u0000\u008d\u0095\u0005a\u0000\u0000\u008e\u008f\u0005v\u0000"+
		"\u0000\u008f\u0095\u0005b\u0000\u0000\u0090\u0091\u0005m\u0000\u0000\u0091"+
		"\u0095\u0005a\u0000\u0000\u0092\u0093\u0005m\u0000\u0000\u0093\u0095\u0005"+
		"b\u0000\u0000\u0094\u008c\u0001\u0000\u0000\u0000\u0094\u008e\u0001\u0000"+
		"\u0000\u0000\u0094\u0090\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000"+
		"\u0000\u0000\u0095>\u0001\u0000\u0000\u0000\u0006\u0000puy~\u0094\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}