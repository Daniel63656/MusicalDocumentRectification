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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, STAFF=6, BARL=7, NEWV=8, VEND=9, 
		GRACE=10, REST=11, WHOLE=12, HALF=13, DOT=14, TIE_START=15, TIE_END=16, 
		FLAG=17, BEAM=18, STEM=19, LINE=20, SHARP=21, FLAT=22, NATURAL=23, CLEF=24, 
		DIGIT=25, SLASH=26, OTTV=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "STAFF", "BARL", "NEWV", "VEND", 
			"GRACE", "REST", "WHOLE", "HALF", "DOT", "TIE_START", "TIE_END", "FLAG", 
			"BEAM", "STEM", "LINE", "SHARP", "FLAT", "NATURAL", "CLEF", "DIGIT", 
			"SLASH", "OTTV"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'bos'", "'eos'", "'&'", "'x'", "'-'", null, "'|'", "'<'", "'>'", 
			"'g'", null, "'w'", "'h'", "'.'", "'('", "')'", null, null, null, null, 
			"'#'", "'b'", "'n'", null, null, "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "STAFF", "BARL", "NEWV", "VEND", 
			"GRACE", "REST", "WHOLE", "HALF", "DOT", "TIE_START", "TIE_END", "FLAG", 
			"BEAM", "STEM", "LINE", "SHARP", "FLAT", "NATURAL", "CLEF", "DIGIT", 
			"SLASH", "OTTV"
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
		"\u0004\u0000\u001b\u008e\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0003\u0012f\b\u0012\u0001\u0013\u0001\u0013\u0003\u0013j\b\u0013"+
		"\u0001\u0013\u0004\u0013m\b\u0013\u000b\u0013\f\u0013n\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0081\b\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u008d\b\u001a\u0000\u0000\u001b"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u00193\u001a5\u001b\u0001\u0000\u0005\u0002\u0000LLTT\u0001\u0000"+
		"07\u0001\u000015\u0003\u0000==[[]]\u0001\u000009\u0092\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005"+
		"\u0001\u0000\u0000\u0000\u00017\u0001\u0000\u0000\u0000\u0003;\u0001\u0000"+
		"\u0000\u0000\u0005?\u0001\u0000\u0000\u0000\u0007A\u0001\u0000\u0000\u0000"+
		"\tC\u0001\u0000\u0000\u0000\u000bE\u0001\u0000\u0000\u0000\rG\u0001\u0000"+
		"\u0000\u0000\u000fI\u0001\u0000\u0000\u0000\u0011K\u0001\u0000\u0000\u0000"+
		"\u0013M\u0001\u0000\u0000\u0000\u0015O\u0001\u0000\u0000\u0000\u0017R"+
		"\u0001\u0000\u0000\u0000\u0019T\u0001\u0000\u0000\u0000\u001bV\u0001\u0000"+
		"\u0000\u0000\u001dX\u0001\u0000\u0000\u0000\u001fZ\u0001\u0000\u0000\u0000"+
		"!\\\u0001\u0000\u0000\u0000#_\u0001\u0000\u0000\u0000%e\u0001\u0000\u0000"+
		"\u0000\'g\u0001\u0000\u0000\u0000)p\u0001\u0000\u0000\u0000+r\u0001\u0000"+
		"\u0000\u0000-t\u0001\u0000\u0000\u0000/\u0080\u0001\u0000\u0000\u0000"+
		"1\u0082\u0001\u0000\u0000\u00003\u0084\u0001\u0000\u0000\u00005\u008c"+
		"\u0001\u0000\u0000\u000078\u0005b\u0000\u000089\u0005o\u0000\u00009:\u0005"+
		"s\u0000\u0000:\u0002\u0001\u0000\u0000\u0000;<\u0005e\u0000\u0000<=\u0005"+
		"o\u0000\u0000=>\u0005s\u0000\u0000>\u0004\u0001\u0000\u0000\u0000?@\u0005"+
		"&\u0000\u0000@\u0006\u0001\u0000\u0000\u0000AB\u0005x\u0000\u0000B\b\u0001"+
		"\u0000\u0000\u0000CD\u0005-\u0000\u0000D\n\u0001\u0000\u0000\u0000EF\u0007"+
		"\u0000\u0000\u0000F\f\u0001\u0000\u0000\u0000GH\u0005|\u0000\u0000H\u000e"+
		"\u0001\u0000\u0000\u0000IJ\u0005<\u0000\u0000J\u0010\u0001\u0000\u0000"+
		"\u0000KL\u0005>\u0000\u0000L\u0012\u0001\u0000\u0000\u0000MN\u0005g\u0000"+
		"\u0000N\u0014\u0001\u0000\u0000\u0000OP\u0005r\u0000\u0000PQ\u0007\u0001"+
		"\u0000\u0000Q\u0016\u0001\u0000\u0000\u0000RS\u0005w\u0000\u0000S\u0018"+
		"\u0001\u0000\u0000\u0000TU\u0005h\u0000\u0000U\u001a\u0001\u0000\u0000"+
		"\u0000VW\u0005.\u0000\u0000W\u001c\u0001\u0000\u0000\u0000XY\u0005(\u0000"+
		"\u0000Y\u001e\u0001\u0000\u0000\u0000Z[\u0005)\u0000\u0000[ \u0001\u0000"+
		"\u0000\u0000\\]\u0005f\u0000\u0000]^\u0007\u0002\u0000\u0000^\"\u0001"+
		"\u0000\u0000\u0000_`\u0007\u0003\u0000\u0000`$\u0001\u0000\u0000\u0000"+
		"ab\u0005u\u0000\u0000bf\u0005p\u0000\u0000cd\u0005d\u0000\u0000df\u0005"+
		"n\u0000\u0000ea\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000f&\u0001"+
		"\u0000\u0000\u0000gi\u0005l\u0000\u0000hj\u0005-\u0000\u0000ih\u0001\u0000"+
		"\u0000\u0000ij\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000\u0000km\u0007"+
		"\u0004\u0000\u0000lk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000"+
		"nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o(\u0001\u0000\u0000"+
		"\u0000pq\u0005#\u0000\u0000q*\u0001\u0000\u0000\u0000rs\u0005b\u0000\u0000"+
		"s,\u0001\u0000\u0000\u0000tu\u0005n\u0000\u0000u.\u0001\u0000\u0000\u0000"+
		"vw\u0005g\u0000\u0000wx\u0005c\u0000\u0000xy\u0005l\u0000\u0000yz\u0005"+
		"e\u0000\u0000z\u0081\u0005f\u0000\u0000{|\u0005f\u0000\u0000|}\u0005c"+
		"\u0000\u0000}~\u0005l\u0000\u0000~\u007f\u0005e\u0000\u0000\u007f\u0081"+
		"\u0005f\u0000\u0000\u0080v\u0001\u0000\u0000\u0000\u0080{\u0001\u0000"+
		"\u0000\u0000\u00810\u0001\u0000\u0000\u0000\u0082\u0083\u0007\u0004\u0000"+
		"\u0000\u00832\u0001\u0000\u0000\u0000\u0084\u0085\u0005/\u0000\u0000\u0085"+
		"4\u0001\u0000\u0000\u0000\u0086\u0087\u00058\u0000\u0000\u0087\u0088\u0005"+
		"v\u0000\u0000\u0088\u008d\u0005a\u0000\u0000\u0089\u008a\u00058\u0000"+
		"\u0000\u008a\u008b\u0005v\u0000\u0000\u008b\u008d\u0005b\u0000\u0000\u008c"+
		"\u0086\u0001\u0000\u0000\u0000\u008c\u0089\u0001\u0000\u0000\u0000\u008d"+
		"6\u0001\u0000\u0000\u0000\u0006\u0000ein\u0080\u008c\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}