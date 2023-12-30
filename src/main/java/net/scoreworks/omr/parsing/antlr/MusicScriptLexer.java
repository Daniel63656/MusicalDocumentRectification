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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, BARL=8, NEWV=9, 
		SKPV=10, GRACE=11, REST=12, DOT=13, TIE_START=14, TIE_END=15, FLAG=16, 
		BEAM=17, TUPL=18, STEM=19, NOTE_OPEN=20, NOTE_SOLID=21, SHARP=22, FLAT=23, 
		NATURAL=24, CLEF=25, DIGIT=26, SLASH=27, OTTV=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "BARL", "NEWV", 
			"SKPV", "GRACE", "REST", "DOT", "TIE_START", "TIE_END", "FLAG", "BEAM", 
			"TUPL", "STEM", "NOTE_OPEN", "NOTE_SOLID", "SHARP", "FLAT", "NATURAL", 
			"CLEF", "DIGIT", "SLASH", "OTTV"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'T'", "'&'", "'L'", "'x'", "'-'", "'c'", "'/c'", null, "'<'", 
			"'>'", "'g'", null, "'.'", "'('", "')'", null, null, null, null, null, 
			null, "'#'", "'b'", "'n'", null, null, "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "BARL", "NEWV", "SKPV", 
			"GRACE", "REST", "DOT", "TIE_START", "TIE_END", "FLAG", "BEAM", "TUPL", 
			"STEM", "NOTE_OPEN", "NOTE_SOLID", "SHARP", "FLAT", "NATURAL", "CLEF", 
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
		"\u0004\u0000\u001c\u008f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0003\u0007J\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007N\b\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0003\u0013j\b\u0013"+
		"\u0001\u0013\u0004\u0013m\b\u0013\u000b\u0013\f\u0013n\u0001\u0014\u0001"+
		"\u0014\u0003\u0014s\b\u0014\u0001\u0014\u0004\u0014v\b\u0014\u000b\u0014"+
		"\f\u0014w\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u001a"+
		"\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u008e\b\u001b\u0000\u0000"+
		"\u001c\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u00193\u001a5\u001b7\u001c\u0001\u0000\u0006\u0001\u000007\u0001"+
		"\u000015\u0003\u0000++[[]]\u0003\u0000**{{}}\u0002\u0000dduu\u0001\u0000"+
		"09\u0097\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000"+
		"\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000"+
		"\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003"+
		"\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000"+
		"\u0000\u0000\u00019\u0001\u0000\u0000\u0000\u0003;\u0001\u0000\u0000\u0000"+
		"\u0005=\u0001\u0000\u0000\u0000\u0007?\u0001\u0000\u0000\u0000\tA\u0001"+
		"\u0000\u0000\u0000\u000bC\u0001\u0000\u0000\u0000\rE\u0001\u0000\u0000"+
		"\u0000\u000fI\u0001\u0000\u0000\u0000\u0011O\u0001\u0000\u0000\u0000\u0013"+
		"Q\u0001\u0000\u0000\u0000\u0015S\u0001\u0000\u0000\u0000\u0017U\u0001"+
		"\u0000\u0000\u0000\u0019X\u0001\u0000\u0000\u0000\u001bZ\u0001\u0000\u0000"+
		"\u0000\u001d\\\u0001\u0000\u0000\u0000\u001f^\u0001\u0000\u0000\u0000"+
		"!a\u0001\u0000\u0000\u0000#c\u0001\u0000\u0000\u0000%e\u0001\u0000\u0000"+
		"\u0000\'g\u0001\u0000\u0000\u0000)p\u0001\u0000\u0000\u0000+y\u0001\u0000"+
		"\u0000\u0000-{\u0001\u0000\u0000\u0000/}\u0001\u0000\u0000\u00001\u007f"+
		"\u0001\u0000\u0000\u00003\u0081\u0001\u0000\u0000\u00005\u0083\u0001\u0000"+
		"\u0000\u00007\u008d\u0001\u0000\u0000\u00009:\u0005T\u0000\u0000:\u0002"+
		"\u0001\u0000\u0000\u0000;<\u0005&\u0000\u0000<\u0004\u0001\u0000\u0000"+
		"\u0000=>\u0005L\u0000\u0000>\u0006\u0001\u0000\u0000\u0000?@\u0005x\u0000"+
		"\u0000@\b\u0001\u0000\u0000\u0000AB\u0005-\u0000\u0000B\n\u0001\u0000"+
		"\u0000\u0000CD\u0005c\u0000\u0000D\f\u0001\u0000\u0000\u0000EF\u0005/"+
		"\u0000\u0000FG\u0005c\u0000\u0000G\u000e\u0001\u0000\u0000\u0000HJ\u0005"+
		":\u0000\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000KM\u0005|\u0000\u0000LN\u0005:\u0000\u0000ML\u0001\u0000"+
		"\u0000\u0000MN\u0001\u0000\u0000\u0000N\u0010\u0001\u0000\u0000\u0000"+
		"OP\u0005<\u0000\u0000P\u0012\u0001\u0000\u0000\u0000QR\u0005>\u0000\u0000"+
		"R\u0014\u0001\u0000\u0000\u0000ST\u0005g\u0000\u0000T\u0016\u0001\u0000"+
		"\u0000\u0000UV\u0005r\u0000\u0000VW\u0007\u0000\u0000\u0000W\u0018\u0001"+
		"\u0000\u0000\u0000XY\u0005.\u0000\u0000Y\u001a\u0001\u0000\u0000\u0000"+
		"Z[\u0005(\u0000\u0000[\u001c\u0001\u0000\u0000\u0000\\]\u0005)\u0000\u0000"+
		"]\u001e\u0001\u0000\u0000\u0000^_\u0005f\u0000\u0000_`\u0007\u0001\u0000"+
		"\u0000` \u0001\u0000\u0000\u0000ab\u0007\u0002\u0000\u0000b\"\u0001\u0000"+
		"\u0000\u0000cd\u0007\u0003\u0000\u0000d$\u0001\u0000\u0000\u0000ef\u0007"+
		"\u0004\u0000\u0000f&\u0001\u0000\u0000\u0000gi\u0005o\u0000\u0000hj\u0005"+
		"-\u0000\u0000ih\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jl\u0001"+
		"\u0000\u0000\u0000km\u0007\u0005\u0000\u0000lk\u0001\u0000\u0000\u0000"+
		"mn\u0001\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000o(\u0001\u0000\u0000\u0000pr\u0005s\u0000\u0000qs\u0005-\u0000\u0000"+
		"rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000\u0000"+
		"\u0000tv\u0007\u0005\u0000\u0000ut\u0001\u0000\u0000\u0000vw\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x*\u0001"+
		"\u0000\u0000\u0000yz\u0005#\u0000\u0000z,\u0001\u0000\u0000\u0000{|\u0005"+
		"b\u0000\u0000|.\u0001\u0000\u0000\u0000}~\u0005n\u0000\u0000~0\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0002FG\u0000\u00802\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0007\u0005\u0000\u0000\u00824\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0005/\u0000\u0000\u00846\u0001\u0000\u0000\u0000\u0085\u0086\u0005"+
		"v\u0000\u0000\u0086\u008e\u0005a\u0000\u0000\u0087\u0088\u0005v\u0000"+
		"\u0000\u0088\u008e\u0005b\u0000\u0000\u0089\u008a\u0005m\u0000\u0000\u008a"+
		"\u008e\u0005a\u0000\u0000\u008b\u008c\u0005m\u0000\u0000\u008c\u008e\u0005"+
		"b\u0000\u0000\u008d\u0085\u0001\u0000\u0000\u0000\u008d\u0087\u0001\u0000"+
		"\u0000\u0000\u008d\u0089\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000"+
		"\u0000\u0000\u008e8\u0001\u0000\u0000\u0000\b\u0000IMinrw\u008d\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}