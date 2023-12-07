// Generated from C:/Users/Daniel/AppDevelopment/scoreworks/OpticalMusicRecognition/src/main/java/net/scoreworks/omr/parsing/MusicScript.g4 by ANTLR 4.13.1
package net.scoreworks.omr.parsing.antlr;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, STAFF=8, BARL=9, 
		NEWV=10, VEND=11, GRACE=12, REST=13, WHOLE=14, HALF=15, DOT=16, TIE_START=17, 
		TIE_END=18, FLAG=19, BEAM=20, TUPL=21, STEM=22, LINE=23, SHARP=24, FLAT=25, 
		NATURAL=26, CLEF=27, DIGIT=28, SLASH=29, OTTV=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "STAFF", "BARL", 
			"NEWV", "VEND", "GRACE", "REST", "WHOLE", "HALF", "DOT", "TIE_START", 
			"TIE_END", "FLAG", "BEAM", "TUPL", "STEM", "LINE", "SHARP", "FLAT", "NATURAL", 
			"CLEF", "DIGIT", "SLASH", "OTTV"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'bos'", "'eos'", "'&'", "'x'", "'-'", "'c'", "'/c'", null, "'|'", 
			"'<'", "'>'", "'g'", null, "'w'", "'h'", "'.'", "'('", "')'", null, null, 
			null, null, null, "'#'", "'b'", "'n'", null, null, "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "STAFF", "BARL", "NEWV", 
			"VEND", "GRACE", "REST", "WHOLE", "HALF", "DOT", "TIE_START", "TIE_END", 
			"FLAG", "BEAM", "TUPL", "STEM", "LINE", "SHARP", "FLAT", "NATURAL", "CLEF", 
			"DIGIT", "SLASH", "OTTV"
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
		"\u0004\u0000\u001e\u008f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016"+
		"\u0001\u0016\u0003\u0016s\b\u0016\u0001\u0016\u0004\u0016v\b\u0016\u000b"+
		"\u0016\f\u0016w\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u008e\b\u001d\u0000"+
		"\u0000\u001e\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b"+
		"\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016"+
		"-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e\u0001\u0000\u0007"+
		"\u0002\u0000LLTT\u0001\u000007\u0001\u000015\u0003\u0000++[[]]\u0003\u0000"+
		"**{{}}\u0002\u0000dduu\u0001\u000009\u0093\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001"+
		"\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000"+
		"\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000"+
		"\u0000;\u0001\u0000\u0000\u0000\u0001=\u0001\u0000\u0000\u0000\u0003A"+
		"\u0001\u0000\u0000\u0000\u0005E\u0001\u0000\u0000\u0000\u0007G\u0001\u0000"+
		"\u0000\u0000\tI\u0001\u0000\u0000\u0000\u000bK\u0001\u0000\u0000\u0000"+
		"\rM\u0001\u0000\u0000\u0000\u000fP\u0001\u0000\u0000\u0000\u0011R\u0001"+
		"\u0000\u0000\u0000\u0013T\u0001\u0000\u0000\u0000\u0015V\u0001\u0000\u0000"+
		"\u0000\u0017X\u0001\u0000\u0000\u0000\u0019Z\u0001\u0000\u0000\u0000\u001b"+
		"]\u0001\u0000\u0000\u0000\u001d_\u0001\u0000\u0000\u0000\u001fa\u0001"+
		"\u0000\u0000\u0000!c\u0001\u0000\u0000\u0000#e\u0001\u0000\u0000\u0000"+
		"%g\u0001\u0000\u0000\u0000\'j\u0001\u0000\u0000\u0000)l\u0001\u0000\u0000"+
		"\u0000+n\u0001\u0000\u0000\u0000-p\u0001\u0000\u0000\u0000/y\u0001\u0000"+
		"\u0000\u00001{\u0001\u0000\u0000\u00003}\u0001\u0000\u0000\u00005\u007f"+
		"\u0001\u0000\u0000\u00007\u0081\u0001\u0000\u0000\u00009\u0083\u0001\u0000"+
		"\u0000\u0000;\u008d\u0001\u0000\u0000\u0000=>\u0005b\u0000\u0000>?\u0005"+
		"o\u0000\u0000?@\u0005s\u0000\u0000@\u0002\u0001\u0000\u0000\u0000AB\u0005"+
		"e\u0000\u0000BC\u0005o\u0000\u0000CD\u0005s\u0000\u0000D\u0004\u0001\u0000"+
		"\u0000\u0000EF\u0005&\u0000\u0000F\u0006\u0001\u0000\u0000\u0000GH\u0005"+
		"x\u0000\u0000H\b\u0001\u0000\u0000\u0000IJ\u0005-\u0000\u0000J\n\u0001"+
		"\u0000\u0000\u0000KL\u0005c\u0000\u0000L\f\u0001\u0000\u0000\u0000MN\u0005"+
		"/\u0000\u0000NO\u0005c\u0000\u0000O\u000e\u0001\u0000\u0000\u0000PQ\u0007"+
		"\u0000\u0000\u0000Q\u0010\u0001\u0000\u0000\u0000RS\u0005|\u0000\u0000"+
		"S\u0012\u0001\u0000\u0000\u0000TU\u0005<\u0000\u0000U\u0014\u0001\u0000"+
		"\u0000\u0000VW\u0005>\u0000\u0000W\u0016\u0001\u0000\u0000\u0000XY\u0005"+
		"g\u0000\u0000Y\u0018\u0001\u0000\u0000\u0000Z[\u0005r\u0000\u0000[\\\u0007"+
		"\u0001\u0000\u0000\\\u001a\u0001\u0000\u0000\u0000]^\u0005w\u0000\u0000"+
		"^\u001c\u0001\u0000\u0000\u0000_`\u0005h\u0000\u0000`\u001e\u0001\u0000"+
		"\u0000\u0000ab\u0005.\u0000\u0000b \u0001\u0000\u0000\u0000cd\u0005(\u0000"+
		"\u0000d\"\u0001\u0000\u0000\u0000ef\u0005)\u0000\u0000f$\u0001\u0000\u0000"+
		"\u0000gh\u0005f\u0000\u0000hi\u0007\u0002\u0000\u0000i&\u0001\u0000\u0000"+
		"\u0000jk\u0007\u0003\u0000\u0000k(\u0001\u0000\u0000\u0000lm\u0007\u0004"+
		"\u0000\u0000m*\u0001\u0000\u0000\u0000no\u0007\u0005\u0000\u0000o,\u0001"+
		"\u0000\u0000\u0000pr\u0005l\u0000\u0000qs\u0005-\u0000\u0000rq\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000\u0000\u0000tv\u0007"+
		"\u0006\u0000\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x.\u0001\u0000\u0000"+
		"\u0000yz\u0005#\u0000\u0000z0\u0001\u0000\u0000\u0000{|\u0005b\u0000\u0000"+
		"|2\u0001\u0000\u0000\u0000}~\u0005n\u0000\u0000~4\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0002FG\u0000\u00806\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0007\u0006\u0000\u0000\u00828\u0001\u0000\u0000\u0000\u0083\u0084\u0005"+
		"/\u0000\u0000\u0084:\u0001\u0000\u0000\u0000\u0085\u0086\u0005v\u0000"+
		"\u0000\u0086\u008e\u0005a\u0000\u0000\u0087\u0088\u0005v\u0000\u0000\u0088"+
		"\u008e\u0005b\u0000\u0000\u0089\u008a\u0005m\u0000\u0000\u008a\u008e\u0005"+
		"a\u0000\u0000\u008b\u008c\u0005m\u0000\u0000\u008c\u008e\u0005b\u0000"+
		"\u0000\u008d\u0085\u0001\u0000\u0000\u0000\u008d\u0087\u0001\u0000\u0000"+
		"\u0000\u008d\u0089\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008e<\u0001\u0000\u0000\u0000\u0004\u0000rw\u008d\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}