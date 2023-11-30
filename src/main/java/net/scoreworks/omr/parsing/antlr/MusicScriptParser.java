// Generated from C:/Users/Daniel/AppDevelopment/scoreworks/OpticalMusicRecognition/src/main/java/net/scoreworks/omr/parsing/MusicScript.g4 by ANTLR 4.13.1
package net.scoreworks.omr.parsing.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MusicScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, STAFF=3, BARL=4, NEWV=5, VEND=6, GRACE=7, REST=8, WHOLE=9, 
		HALF=10, DOT=11, TIE_START=12, TIE_END=13, FLAG=14, BEAM=15, STEM=16, 
		LINE=17, ACC=18, DIGIT=19, CLEF=20, KEY_SHP=21, KEY_FLT=22, KEY_NAT=23, 
		SLASH=24, OTTV=25;
	public static final int
		RULE_score = 0, RULE_event = 1, RULE_group = 2, RULE_rest = 3, RULE_chord = 4, 
		RULE_note = 5, RULE_meta = 6, RULE_time = 7, RULE_key = 8, RULE_ottavastart = 9, 
		RULE_ottavaend = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"score", "event", "group", "rest", "chord", "note", "meta", "time", "key", 
			"ottavastart", "ottavaend"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'bos'", "'eos'", null, "'|'", "'<'", "'>'", "'g'", null, "'w'", 
			"'h'", "'.'", "'('", "')'", null, null, null, null, null, null, null, 
			"'k#'", "'kb'", "'kn'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "STAFF", "BARL", "NEWV", "VEND", "GRACE", "REST", "WHOLE", 
			"HALF", "DOT", "TIE_START", "TIE_END", "FLAG", "BEAM", "STEM", "LINE", 
			"ACC", "DIGIT", "CLEF", "KEY_SHP", "KEY_FLT", "KEY_NAT", "SLASH", "OTTV"
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

	@Override
	public String getGrammarFileName() { return "MusicScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MusicScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScoreContext extends ParserRuleContext {
		public List<EventContext> event() {
			return getRuleContexts(EventContext.class);
		}
		public EventContext event(int i) {
			return getRuleContext(EventContext.class,i);
		}
		public ScoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_score; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterScore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitScore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitScore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScoreContext score() throws RecognitionException {
		ScoreContext _localctx = new ScoreContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_score);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(T__0);
			setState(24); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(23);
				event();
				}
				}
				setState(26); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STAFF || _la==BARL );
			setState(28);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EventContext extends ParserRuleContext {
		public TerminalNode STAFF() { return getToken(MusicScriptParser.STAFF, 0); }
		public TerminalNode BARL() { return getToken(MusicScriptParser.BARL, 0); }
		public List<MetaContext> meta() {
			return getRuleContexts(MetaContext.class);
		}
		public MetaContext meta(int i) {
			return getRuleContext(MetaContext.class,i);
		}
		public OttavastartContext ottavastart() {
			return getRuleContext(OttavastartContext.class,0);
		}
		public List<GroupContext> group() {
			return getRuleContexts(GroupContext.class);
		}
		public GroupContext group(int i) {
			return getRuleContext(GroupContext.class,i);
		}
		public OttavaendContext ottavaend() {
			return getRuleContext(OttavaendContext.class,0);
		}
		public EventContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterEvent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitEvent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitEvent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EventContext event() throws RecognitionException {
		EventContext _localctx = new EventContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_event);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BARL) {
				{
				setState(30);
				match(BARL);
				}
			}

			setState(33);
			match(STAFF);
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16252928L) != 0)) {
				{
				{
				setState(34);
				meta();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTTV) {
				{
				setState(40);
				ottavastart();
				}
			}

			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43);
				group();
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 67488L) != 0) );
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTTV) {
				{
				setState(48);
				ottavaend();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GroupContext extends ParserRuleContext {
		public RestContext rest() {
			return getRuleContext(RestContext.class,0);
		}
		public TerminalNode NEWV() { return getToken(MusicScriptParser.NEWV, 0); }
		public TerminalNode VEND() { return getToken(MusicScriptParser.VEND, 0); }
		public ChordContext chord() {
			return getRuleContext(ChordContext.class,0);
		}
		public TerminalNode GRACE() { return getToken(MusicScriptParser.GRACE, 0); }
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_group);
		int _la;
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWV) {
					{
					setState(51);
					match(NEWV);
					}
				}

				setState(54);
				rest();
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VEND) {
					{
					setState(55);
					match(VEND);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWV) {
					{
					setState(58);
					match(NEWV);
					}
				}

				setState(61);
				chord();
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VEND) {
					{
					setState(62);
					match(VEND);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				match(GRACE);
				setState(66);
				chord();
				setState(67);
				group();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RestContext extends ParserRuleContext {
		public TerminalNode REST() { return getToken(MusicScriptParser.REST, 0); }
		public TerminalNode BEAM() { return getToken(MusicScriptParser.BEAM, 0); }
		public List<TerminalNode> DOT() { return getTokens(MusicScriptParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(MusicScriptParser.DOT, i);
		}
		public RestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RestContext rest() throws RecognitionException {
		RestContext _localctx = new RestContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_rest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(REST);
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BEAM) {
				{
				setState(72);
				match(BEAM);
				}
			}

			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(75);
				match(DOT);
				}
				}
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChordContext extends ParserRuleContext {
		public TerminalNode WHOLE() { return getToken(MusicScriptParser.WHOLE, 0); }
		public List<NoteContext> note() {
			return getRuleContexts(NoteContext.class);
		}
		public NoteContext note(int i) {
			return getRuleContext(NoteContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(MusicScriptParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(MusicScriptParser.DOT, i);
		}
		public TerminalNode HALF() { return getToken(MusicScriptParser.HALF, 0); }
		public TerminalNode STEM() { return getToken(MusicScriptParser.STEM, 0); }
		public TerminalNode BEAM() { return getToken(MusicScriptParser.BEAM, 0); }
		public List<TerminalNode> FLAG() { return getTokens(MusicScriptParser.FLAG); }
		public TerminalNode FLAG(int i) {
			return getToken(MusicScriptParser.FLAG, i);
		}
		public ChordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chord; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterChord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitChord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitChord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChordContext chord() throws RecognitionException {
		ChordContext _localctx = new ChordContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_chord);
		int _la;
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(WHOLE);
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(82);
					note();
					}
					}
					setState(85); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 401408L) != 0) );
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(87);
					match(DOT);
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				match(HALF);
				setState(94);
				match(STEM);
				setState(96); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(95);
					note();
					}
					}
					setState(98); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 401408L) != 0) );
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(100);
					match(DOT);
					}
					}
					setState(105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				match(STEM);
				setState(108); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(107);
					note();
					}
					}
					setState(110); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 401408L) != 0) );
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(112);
					match(DOT);
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(STEM);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEAM) {
					{
					setState(119);
					match(BEAM);
					}
				}

				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(122);
					match(FLAG);
					}
					}
					setState(125); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FLAG );
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(127);
					note();
					}
					}
					setState(130); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 401408L) != 0) );
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(132);
					match(DOT);
					}
					}
					setState(137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NoteContext extends ParserRuleContext {
		public TerminalNode LINE() { return getToken(MusicScriptParser.LINE, 0); }
		public TerminalNode ACC() { return getToken(MusicScriptParser.ACC, 0); }
		public TerminalNode TIE_END() { return getToken(MusicScriptParser.TIE_END, 0); }
		public TerminalNode TIE_START() { return getToken(MusicScriptParser.TIE_START, 0); }
		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACC) {
				{
				setState(140);
				match(ACC);
				}
			}

			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_END) {
				{
				setState(143);
				match(TIE_END);
				}
			}

			setState(146);
			match(LINE);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_START) {
				{
				setState(147);
				match(TIE_START);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MetaContext extends ParserRuleContext {
		public TerminalNode CLEF() { return getToken(MusicScriptParser.CLEF, 0); }
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public MetaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_meta; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterMeta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitMeta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitMeta(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MetaContext meta() throws RecognitionException {
		MetaContext _localctx = new MetaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_meta);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLEF:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				match(CLEF);
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				time();
				}
				break;
			case KEY_SHP:
			case KEY_FLT:
			case KEY_NAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				key();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TimeContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(MusicScriptParser.SLASH, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(MusicScriptParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(MusicScriptParser.DIGIT, i);
		}
		public TimeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_time; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterTime(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitTime(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitTime(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TimeContext time() throws RecognitionException {
		TimeContext _localctx = new TimeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_time);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(155);
				match(DIGIT);
				}
				}
				setState(158); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			setState(160);
			match(SLASH);
			setState(162); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(161);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(164); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyContext extends ParserRuleContext {
		public List<TerminalNode> KEY_SHP() { return getTokens(MusicScriptParser.KEY_SHP); }
		public TerminalNode KEY_SHP(int i) {
			return getToken(MusicScriptParser.KEY_SHP, i);
		}
		public List<TerminalNode> KEY_FLT() { return getTokens(MusicScriptParser.KEY_FLT); }
		public TerminalNode KEY_FLT(int i) {
			return getToken(MusicScriptParser.KEY_FLT, i);
		}
		public List<TerminalNode> KEY_NAT() { return getTokens(MusicScriptParser.KEY_NAT); }
		public TerminalNode KEY_NAT(int i) {
			return getToken(MusicScriptParser.KEY_NAT, i);
		}
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitKey(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitKey(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_key);
		try {
			int _alt;
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEY_SHP:
				enterOuterAlt(_localctx, 1);
				{
				setState(167); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(166);
						match(KEY_SHP);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(169); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case KEY_FLT:
				enterOuterAlt(_localctx, 2);
				{
				setState(172); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(171);
						match(KEY_FLT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(174); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case KEY_NAT:
				enterOuterAlt(_localctx, 3);
				{
				setState(177); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(176);
						match(KEY_NAT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(179); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OttavastartContext extends ParserRuleContext {
		public TerminalNode OTTV() { return getToken(MusicScriptParser.OTTV, 0); }
		public OttavastartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ottavastart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterOttavastart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitOttavastart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitOttavastart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OttavastartContext ottavastart() throws RecognitionException {
		OttavastartContext _localctx = new OttavastartContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ottavastart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(OTTV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OttavaendContext extends ParserRuleContext {
		public TerminalNode OTTV() { return getToken(MusicScriptParser.OTTV, 0); }
		public OttavaendContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ottavaend; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterOttavaend(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitOttavaend(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitOttavaend(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OttavaendContext ottavaend() throws RecognitionException {
		OttavaendContext _localctx = new OttavaendContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ottavaend);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(OTTV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0019\u00bc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000"+
		"\u0004\u0000\u0019\b\u0000\u000b\u0000\f\u0000\u001a\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0003\u0001 \b\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001$\b\u0001\n\u0001\f\u0001\'\t\u0001\u0001\u0001\u0003\u0001*\b\u0001"+
		"\u0001\u0001\u0004\u0001-\b\u0001\u000b\u0001\f\u0001.\u0001\u0001\u0003"+
		"\u00012\b\u0001\u0001\u0002\u0003\u00025\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u00029\b\u0002\u0001\u0002\u0003\u0002<\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002@\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002F\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003J\b\u0003"+
		"\u0001\u0003\u0005\u0003M\b\u0003\n\u0003\f\u0003P\t\u0003\u0001\u0004"+
		"\u0001\u0004\u0004\u0004T\b\u0004\u000b\u0004\f\u0004U\u0001\u0004\u0005"+
		"\u0004Y\b\u0004\n\u0004\f\u0004\\\t\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0004\u0004a\b\u0004\u000b\u0004\f\u0004b\u0001\u0004\u0005\u0004"+
		"f\b\u0004\n\u0004\f\u0004i\t\u0004\u0001\u0004\u0001\u0004\u0004\u0004"+
		"m\b\u0004\u000b\u0004\f\u0004n\u0001\u0004\u0005\u0004r\b\u0004\n\u0004"+
		"\f\u0004u\t\u0004\u0001\u0004\u0001\u0004\u0003\u0004y\b\u0004\u0001\u0004"+
		"\u0004\u0004|\b\u0004\u000b\u0004\f\u0004}\u0001\u0004\u0004\u0004\u0081"+
		"\b\u0004\u000b\u0004\f\u0004\u0082\u0001\u0004\u0005\u0004\u0086\b\u0004"+
		"\n\u0004\f\u0004\u0089\t\u0004\u0003\u0004\u008b\b\u0004\u0001\u0005\u0003"+
		"\u0005\u008e\b\u0005\u0001\u0005\u0003\u0005\u0091\b\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u0095\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u009a\b\u0006\u0001\u0007\u0004\u0007\u009d\b\u0007\u000b"+
		"\u0007\f\u0007\u009e\u0001\u0007\u0001\u0007\u0004\u0007\u00a3\b\u0007"+
		"\u000b\u0007\f\u0007\u00a4\u0001\b\u0004\b\u00a8\b\b\u000b\b\f\b\u00a9"+
		"\u0001\b\u0004\b\u00ad\b\b\u000b\b\f\b\u00ae\u0001\b\u0004\b\u00b2\b\b"+
		"\u000b\b\f\b\u00b3\u0003\b\u00b6\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0000\u0000\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0000\u0000\u00d7\u0000\u0016\u0001\u0000\u0000\u0000\u0002\u001f\u0001"+
		"\u0000\u0000\u0000\u0004E\u0001\u0000\u0000\u0000\u0006G\u0001\u0000\u0000"+
		"\u0000\b\u008a\u0001\u0000\u0000\u0000\n\u008d\u0001\u0000\u0000\u0000"+
		"\f\u0099\u0001\u0000\u0000\u0000\u000e\u009c\u0001\u0000\u0000\u0000\u0010"+
		"\u00b5\u0001\u0000\u0000\u0000\u0012\u00b7\u0001\u0000\u0000\u0000\u0014"+
		"\u00b9\u0001\u0000\u0000\u0000\u0016\u0018\u0005\u0001\u0000\u0000\u0017"+
		"\u0019\u0003\u0002\u0001\u0000\u0018\u0017\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001a"+
		"\u001b\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c"+
		"\u001d\u0005\u0002\u0000\u0000\u001d\u0001\u0001\u0000\u0000\u0000\u001e"+
		" \u0005\u0004\u0000\u0000\u001f\u001e\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!%\u0005\u0003\u0000\u0000"+
		"\"$\u0003\f\u0006\u0000#\"\u0001\u0000\u0000\u0000$\'\u0001\u0000\u0000"+
		"\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&)\u0001\u0000"+
		"\u0000\u0000\'%\u0001\u0000\u0000\u0000(*\u0003\u0012\t\u0000)(\u0001"+
		"\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*,\u0001\u0000\u0000\u0000"+
		"+-\u0003\u0004\u0002\u0000,+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000"+
		"\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/1\u0001\u0000"+
		"\u0000\u000002\u0003\u0014\n\u000010\u0001\u0000\u0000\u000012\u0001\u0000"+
		"\u0000\u00002\u0003\u0001\u0000\u0000\u000035\u0005\u0005\u0000\u0000"+
		"43\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u000068\u0003\u0006\u0003\u000079\u0005\u0006\u0000\u000087\u0001\u0000"+
		"\u0000\u000089\u0001\u0000\u0000\u00009F\u0001\u0000\u0000\u0000:<\u0005"+
		"\u0005\u0000\u0000;:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=?\u0003\b\u0004\u0000>@\u0005\u0006\u0000\u0000"+
		"?>\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@F\u0001\u0000\u0000"+
		"\u0000AB\u0005\u0007\u0000\u0000BC\u0003\b\u0004\u0000CD\u0003\u0004\u0002"+
		"\u0000DF\u0001\u0000\u0000\u0000E4\u0001\u0000\u0000\u0000E;\u0001\u0000"+
		"\u0000\u0000EA\u0001\u0000\u0000\u0000F\u0005\u0001\u0000\u0000\u0000"+
		"GI\u0005\b\u0000\u0000HJ\u0005\u000f\u0000\u0000IH\u0001\u0000\u0000\u0000"+
		"IJ\u0001\u0000\u0000\u0000JN\u0001\u0000\u0000\u0000KM\u0005\u000b\u0000"+
		"\u0000LK\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000NL\u0001\u0000"+
		"\u0000\u0000NO\u0001\u0000\u0000\u0000O\u0007\u0001\u0000\u0000\u0000"+
		"PN\u0001\u0000\u0000\u0000QS\u0005\t\u0000\u0000RT\u0003\n\u0005\u0000"+
		"SR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000VZ\u0001\u0000\u0000\u0000WY\u0005\u000b"+
		"\u0000\u0000XW\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001"+
		"\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\u008b\u0001\u0000\u0000"+
		"\u0000\\Z\u0001\u0000\u0000\u0000]^\u0005\n\u0000\u0000^`\u0005\u0010"+
		"\u0000\u0000_a\u0003\n\u0005\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cg\u0001"+
		"\u0000\u0000\u0000df\u0005\u000b\u0000\u0000ed\u0001\u0000\u0000\u0000"+
		"fi\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000h\u008b\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jl\u0005"+
		"\u0010\u0000\u0000km\u0003\n\u0005\u0000lk\u0001\u0000\u0000\u0000mn\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"os\u0001\u0000\u0000\u0000pr\u0005\u000b\u0000\u0000qp\u0001\u0000\u0000"+
		"\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000"+
		"\u0000\u0000t\u008b\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000"+
		"vx\u0005\u0010\u0000\u0000wy\u0005\u000f\u0000\u0000xw\u0001\u0000\u0000"+
		"\u0000xy\u0001\u0000\u0000\u0000y{\u0001\u0000\u0000\u0000z|\u0005\u000e"+
		"\u0000\u0000{z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}{\u0001"+
		"\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0001\u0000\u0000"+
		"\u0000\u007f\u0081\u0003\n\u0005\u0000\u0080\u007f\u0001\u0000\u0000\u0000"+
		"\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000"+
		"\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0087\u0001\u0000\u0000\u0000"+
		"\u0084\u0086\u0005\u000b\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000"+
		"\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000"+
		"\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000\u0000"+
		"\u0089\u0087\u0001\u0000\u0000\u0000\u008aQ\u0001\u0000\u0000\u0000\u008a"+
		"]\u0001\u0000\u0000\u0000\u008aj\u0001\u0000\u0000\u0000\u008av\u0001"+
		"\u0000\u0000\u0000\u008b\t\u0001\u0000\u0000\u0000\u008c\u008e\u0005\u0012"+
		"\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u0091\u0005\r\u0000"+
		"\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0094\u0005\u0011\u0000"+
		"\u0000\u0093\u0095\u0005\f\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000"+
		"\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u000b\u0001\u0000\u0000\u0000"+
		"\u0096\u009a\u0005\u0014\u0000\u0000\u0097\u009a\u0003\u000e\u0007\u0000"+
		"\u0098\u009a\u0003\u0010\b\u0000\u0099\u0096\u0001\u0000\u0000\u0000\u0099"+
		"\u0097\u0001\u0000\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a"+
		"\r\u0001\u0000\u0000\u0000\u009b\u009d\u0005\u0013\u0000\u0000\u009c\u009b"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009c"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a2\u0005\u0018\u0000\u0000\u00a1\u00a3"+
		"\u0005\u0013\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a5\u000f\u0001\u0000\u0000\u0000\u00a6\u00a8"+
		"\u0005\u0015\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0001\u0000\u0000\u0000\u00aa\u00b6\u0001\u0000\u0000\u0000\u00ab\u00ad"+
		"\u0005\u0016\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af"+
		"\u0001\u0000\u0000\u0000\u00af\u00b6\u0001\u0000\u0000\u0000\u00b0\u00b2"+
		"\u0005\u0017\u0000\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5\u00a7"+
		"\u0001\u0000\u0000\u0000\u00b5\u00ac\u0001\u0000\u0000\u0000\u00b5\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b6\u0011\u0001\u0000\u0000\u0000\u00b7\u00b8"+
		"\u0005\u0019\u0000\u0000\u00b8\u0013\u0001\u0000\u0000\u0000\u00b9\u00ba"+
		"\u0005\u0019\u0000\u0000\u00ba\u0015\u0001\u0000\u0000\u0000\"\u001a\u001f"+
		"%).148;?EINUZbgnsx}\u0082\u0087\u008a\u008d\u0090\u0094\u0099\u009e\u00a4"+
		"\u00a9\u00ae\u00b3\u00b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}