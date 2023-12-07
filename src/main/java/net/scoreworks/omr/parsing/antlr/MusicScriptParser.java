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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, STAFF=6, BARL=7, NEWV=8, VEND=9, 
		GRACE=10, REST=11, WHOLE=12, HALF=13, DOT=14, TIE_START=15, TIE_END=16, 
		FLAG=17, BEAM=18, STEM=19, LINE=20, SHARP=21, FLAT=22, NATURAL=23, CLEF=24, 
		DIGIT=25, SLASH=26, OTTV=27;
	public static final int
		RULE_score = 0, RULE_event = 1, RULE_staff = 2, RULE_group = 3, RULE_rest = 4, 
		RULE_chord = 5, RULE_note = 6, RULE_accidental = 7, RULE_time = 8, RULE_key = 9, 
		RULE_ottavastart = 10, RULE_ottavaend = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"score", "event", "staff", "group", "rest", "chord", "note", "accidental", 
			"time", "key", "ottavastart", "ottavaend"
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
			setState(24);
			match(T__0);
			setState(26); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(25);
				event();
				}
				}
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STAFF || _la==BARL );
			setState(30);
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
		public List<StaffContext> staff() {
			return getRuleContexts(StaffContext.class);
		}
		public StaffContext staff(int i) {
			return getRuleContext(StaffContext.class,i);
		}
		public TerminalNode BARL() { return getToken(MusicScriptParser.BARL, 0); }
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
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BARL) {
				{
				setState(32);
				match(BARL);
				}
			}

			setState(35);
			match(STAFF);
			setState(36);
			staff();
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(37);
				match(T__2);
				setState(38);
				staff();
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
	public static class StaffContext extends ParserRuleContext {
		public TerminalNode CLEF() { return getToken(MusicScriptParser.CLEF, 0); }
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
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
		public StaffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterStaff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitStaff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitStaff(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StaffContext staff() throws RecognitionException {
		StaffContext _localctx = new StaffContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_staff);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CLEF) {
				{
				setState(41);
				match(CLEF);
				}
			}

			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680064L) != 0)) {
				{
				setState(44);
				key();
				}
			}

			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DIGIT) {
				{
				setState(47);
				time();
				}
			}

			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTTV) {
				{
				setState(50);
				ottavastart();
				}
			}

			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(53);
				group();
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 539904L) != 0) );
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OTTV) {
				{
				setState(58);
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
		enterRule(_localctx, 6, RULE_group);
		int _la;
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWV) {
					{
					setState(61);
					match(NEWV);
					}
				}

				setState(64);
				rest();
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VEND) {
					{
					setState(65);
					match(VEND);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWV) {
					{
					setState(68);
					match(NEWV);
					}
				}

				setState(71);
				chord();
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VEND) {
					{
					setState(72);
					match(VEND);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				match(GRACE);
				setState(76);
				chord();
				setState(77);
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
		enterRule(_localctx, 8, RULE_rest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(REST);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BEAM) {
				{
				setState(82);
				match(BEAM);
				}
			}

			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(85);
				match(DOT);
				}
				}
				setState(90);
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
		public TerminalNode FLAG() { return getToken(MusicScriptParser.FLAG, 0); }
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
		enterRule(_localctx, 10, RULE_chord);
		int _la;
		try {
			setState(146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(WHOLE);
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(92);
					note();
					}
					}
					setState(95); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794224L) != 0) );
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(97);
					match(DOT);
					}
					}
					setState(102);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(HALF);
				setState(104);
				match(STEM);
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(105);
					note();
					}
					}
					setState(108); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794224L) != 0) );
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(110);
					match(DOT);
					}
					}
					setState(115);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				match(STEM);
				setState(118); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(117);
					note();
					}
					}
					setState(120); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794224L) != 0) );
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(122);
					match(DOT);
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				match(STEM);
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEAM) {
					{
					setState(129);
					match(BEAM);
					}
				}

				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FLAG) {
					{
					setState(132);
					match(FLAG);
					}
				}

				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(135);
					note();
					}
					}
					setState(138); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 15794224L) != 0) );
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(140);
					match(DOT);
					}
					}
					setState(145);
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
		public AccidentalContext accidental() {
			return getRuleContext(AccidentalContext.class,0);
		}
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
		enterRule(_localctx, 12, RULE_note);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680112L) != 0)) {
				{
				setState(148);
				accidental();
				}
			}

			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_END) {
				{
				setState(151);
				match(TIE_END);
				}
			}

			setState(154);
			match(LINE);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_START) {
				{
				setState(155);
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
	public static class AccidentalContext extends ParserRuleContext {
		public TerminalNode SHARP() { return getToken(MusicScriptParser.SHARP, 0); }
		public TerminalNode FLAT() { return getToken(MusicScriptParser.FLAT, 0); }
		public TerminalNode NATURAL() { return getToken(MusicScriptParser.NATURAL, 0); }
		public AccidentalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accidental; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterAccidental(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitAccidental(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitAccidental(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccidentalContext accidental() throws RecognitionException {
		AccidentalContext _localctx = new AccidentalContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_accidental);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 14680112L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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
		enterRule(_localctx, 16, RULE_time);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(160);
				match(DIGIT);
				}
				}
				setState(163); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			setState(165);
			match(SLASH);
			setState(167); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(166);
				match(DIGIT);
				}
				}
				setState(169); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
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
		public List<TerminalNode> SHARP() { return getTokens(MusicScriptParser.SHARP); }
		public TerminalNode SHARP(int i) {
			return getToken(MusicScriptParser.SHARP, i);
		}
		public List<TerminalNode> FLAT() { return getTokens(MusicScriptParser.FLAT); }
		public TerminalNode FLAT(int i) {
			return getToken(MusicScriptParser.FLAT, i);
		}
		public List<TerminalNode> NATURAL() { return getTokens(MusicScriptParser.NATURAL); }
		public TerminalNode NATURAL(int i) {
			return getToken(MusicScriptParser.NATURAL, i);
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
		enterRule(_localctx, 18, RULE_key);
		int _la;
		try {
			setState(186);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHARP:
				enterOuterAlt(_localctx, 1);
				{
				setState(172); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(171);
					match(SHARP);
					}
					}
					setState(174); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SHARP );
				}
				break;
			case FLAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(176);
					match(FLAT);
					}
					}
					setState(179); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==FLAT );
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(182); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(181);
					match(NATURAL);
					}
					}
					setState(184); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NATURAL );
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
		enterRule(_localctx, 20, RULE_ottavastart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
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
		enterRule(_localctx, 22, RULE_ottavaend);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
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
		"\u0004\u0001\u001b\u00c1\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0001\u0000\u0001\u0000\u0004\u0000\u001b\b\u0000\u000b\u0000\f\u0000"+
		"\u001c\u0001\u0000\u0001\u0000\u0001\u0001\u0003\u0001\"\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001(\b\u0001\u0001"+
		"\u0002\u0003\u0002+\b\u0002\u0001\u0002\u0003\u0002.\b\u0002\u0001\u0002"+
		"\u0003\u00021\b\u0002\u0001\u0002\u0003\u00024\b\u0002\u0001\u0002\u0004"+
		"\u00027\b\u0002\u000b\u0002\f\u00028\u0001\u0002\u0003\u0002<\b\u0002"+
		"\u0001\u0003\u0003\u0003?\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"C\b\u0003\u0001\u0003\u0003\u0003F\b\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003J\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003P\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004T\b\u0004\u0001\u0004"+
		"\u0005\u0004W\b\u0004\n\u0004\f\u0004Z\t\u0004\u0001\u0005\u0001\u0005"+
		"\u0004\u0005^\b\u0005\u000b\u0005\f\u0005_\u0001\u0005\u0005\u0005c\b"+
		"\u0005\n\u0005\f\u0005f\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004"+
		"\u0005k\b\u0005\u000b\u0005\f\u0005l\u0001\u0005\u0005\u0005p\b\u0005"+
		"\n\u0005\f\u0005s\t\u0005\u0001\u0005\u0001\u0005\u0004\u0005w\b\u0005"+
		"\u000b\u0005\f\u0005x\u0001\u0005\u0005\u0005|\b\u0005\n\u0005\f\u0005"+
		"\u007f\t\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0083\b\u0005\u0001"+
		"\u0005\u0003\u0005\u0086\b\u0005\u0001\u0005\u0004\u0005\u0089\b\u0005"+
		"\u000b\u0005\f\u0005\u008a\u0001\u0005\u0005\u0005\u008e\b\u0005\n\u0005"+
		"\f\u0005\u0091\t\u0005\u0003\u0005\u0093\b\u0005\u0001\u0006\u0003\u0006"+
		"\u0096\b\u0006\u0001\u0006\u0003\u0006\u0099\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u009d\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0004"+
		"\b\u00a2\b\b\u000b\b\f\b\u00a3\u0001\b\u0001\b\u0004\b\u00a8\b\b\u000b"+
		"\b\f\b\u00a9\u0001\t\u0004\t\u00ad\b\t\u000b\t\f\t\u00ae\u0001\t\u0004"+
		"\t\u00b2\b\t\u000b\t\f\t\u00b3\u0001\t\u0004\t\u00b7\b\t\u000b\t\f\t\u00b8"+
		"\u0003\t\u00bb\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0000\u0000\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0000\u0001\u0002\u0000\u0004\u0005\u0015\u0017\u00dc\u0000\u0018\u0001"+
		"\u0000\u0000\u0000\u0002!\u0001\u0000\u0000\u0000\u0004*\u0001\u0000\u0000"+
		"\u0000\u0006O\u0001\u0000\u0000\u0000\bQ\u0001\u0000\u0000\u0000\n\u0092"+
		"\u0001\u0000\u0000\u0000\f\u0095\u0001\u0000\u0000\u0000\u000e\u009e\u0001"+
		"\u0000\u0000\u0000\u0010\u00a1\u0001\u0000\u0000\u0000\u0012\u00ba\u0001"+
		"\u0000\u0000\u0000\u0014\u00bc\u0001\u0000\u0000\u0000\u0016\u00be\u0001"+
		"\u0000\u0000\u0000\u0018\u001a\u0005\u0001\u0000\u0000\u0019\u001b\u0003"+
		"\u0002\u0001\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001"+
		"\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001f\u0005"+
		"\u0002\u0000\u0000\u001f\u0001\u0001\u0000\u0000\u0000 \"\u0005\u0007"+
		"\u0000\u0000! \u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0001"+
		"\u0000\u0000\u0000#$\u0005\u0006\u0000\u0000$\'\u0003\u0004\u0002\u0000"+
		"%&\u0005\u0003\u0000\u0000&(\u0003\u0004\u0002\u0000\'%\u0001\u0000\u0000"+
		"\u0000\'(\u0001\u0000\u0000\u0000(\u0003\u0001\u0000\u0000\u0000)+\u0005"+
		"\u0018\u0000\u0000*)\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000"+
		"+-\u0001\u0000\u0000\u0000,.\u0003\u0012\t\u0000-,\u0001\u0000\u0000\u0000"+
		"-.\u0001\u0000\u0000\u0000.0\u0001\u0000\u0000\u0000/1\u0003\u0010\b\u0000"+
		"0/\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000013\u0001\u0000\u0000"+
		"\u000024\u0003\u0014\n\u000032\u0001\u0000\u0000\u000034\u0001\u0000\u0000"+
		"\u000046\u0001\u0000\u0000\u000057\u0003\u0006\u0003\u000065\u0001\u0000"+
		"\u0000\u000078\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001"+
		"\u0000\u0000\u00009;\u0001\u0000\u0000\u0000:<\u0003\u0016\u000b\u0000"+
		";:\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<\u0005\u0001\u0000"+
		"\u0000\u0000=?\u0005\b\u0000\u0000>=\u0001\u0000\u0000\u0000>?\u0001\u0000"+
		"\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0003\b\u0004\u0000AC\u0005\t"+
		"\u0000\u0000BA\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CP\u0001"+
		"\u0000\u0000\u0000DF\u0005\b\u0000\u0000ED\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GI\u0003\n\u0005\u0000HJ\u0005"+
		"\t\u0000\u0000IH\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JP\u0001"+
		"\u0000\u0000\u0000KL\u0005\n\u0000\u0000LM\u0003\n\u0005\u0000MN\u0003"+
		"\u0006\u0003\u0000NP\u0001\u0000\u0000\u0000O>\u0001\u0000\u0000\u0000"+
		"OE\u0001\u0000\u0000\u0000OK\u0001\u0000\u0000\u0000P\u0007\u0001\u0000"+
		"\u0000\u0000QS\u0005\u000b\u0000\u0000RT\u0005\u0012\u0000\u0000SR\u0001"+
		"\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TX\u0001\u0000\u0000\u0000"+
		"UW\u0005\u000e\u0000\u0000VU\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000"+
		"\u0000XV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Y\t\u0001\u0000"+
		"\u0000\u0000ZX\u0001\u0000\u0000\u0000[]\u0005\f\u0000\u0000\\^\u0003"+
		"\f\u0006\u0000]\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_]"+
		"\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`d\u0001\u0000\u0000"+
		"\u0000ac\u0005\u000e\u0000\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000"+
		"\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000e\u0093"+
		"\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gh\u0005\r\u0000\u0000"+
		"hj\u0005\u0013\u0000\u0000ik\u0003\f\u0006\u0000ji\u0001\u0000\u0000\u0000"+
		"kl\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000"+
		"\u0000mq\u0001\u0000\u0000\u0000np\u0005\u000e\u0000\u0000on\u0001\u0000"+
		"\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001"+
		"\u0000\u0000\u0000r\u0093\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000"+
		"\u0000tv\u0005\u0013\u0000\u0000uw\u0003\f\u0006\u0000vu\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000"+
		"\u0000\u0000y}\u0001\u0000\u0000\u0000z|\u0005\u000e\u0000\u0000{z\u0001"+
		"\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000"+
		"\u0000}~\u0001\u0000\u0000\u0000~\u0093\u0001\u0000\u0000\u0000\u007f"+
		"}\u0001\u0000\u0000\u0000\u0080\u0082\u0005\u0013\u0000\u0000\u0081\u0083"+
		"\u0005\u0012\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0001\u0000\u0000\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084\u0086"+
		"\u0005\u0011\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0085\u0086"+
		"\u0001\u0000\u0000\u0000\u0086\u0088\u0001\u0000\u0000\u0000\u0087\u0089"+
		"\u0003\f\u0006\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001"+
		"\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u008f\u0001\u0000\u0000\u0000\u008c\u008e\u0005"+
		"\u000e\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e\u0091\u0001"+
		"\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f\u0090\u0001"+
		"\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001"+
		"\u0000\u0000\u0000\u0092[\u0001\u0000\u0000\u0000\u0092g\u0001\u0000\u0000"+
		"\u0000\u0092t\u0001\u0000\u0000\u0000\u0092\u0080\u0001\u0000\u0000\u0000"+
		"\u0093\u000b\u0001\u0000\u0000\u0000\u0094\u0096\u0003\u000e\u0007\u0000"+
		"\u0095\u0094\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0099\u0005\u0010\u0000\u0000"+
		"\u0098\u0097\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000"+
		"\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u009c\u0005\u0014\u0000\u0000"+
		"\u009b\u009d\u0005\u000f\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000"+
		"\u009c\u009d\u0001\u0000\u0000\u0000\u009d\r\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u0007\u0000\u0000\u0000\u009f\u000f\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a2\u0005\u0019\u0000\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a7\u0005\u001a\u0000\u0000\u00a6\u00a8\u0005\u0019\u0000\u0000\u00a7"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9"+
		"\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa"+
		"\u0011\u0001\u0000\u0000\u0000\u00ab\u00ad\u0005\u0015\u0000\u0000\u00ac"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae"+
		"\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af"+
		"\u00bb\u0001\u0000\u0000\u0000\u00b0\u00b2\u0005\u0016\u0000\u0000\u00b1"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4"+
		"\u00bb\u0001\u0000\u0000\u0000\u00b5\u00b7\u0005\u0017\u0000\u0000\u00b6"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9"+
		"\u00bb\u0001\u0000\u0000\u0000\u00ba\u00ac\u0001\u0000\u0000\u0000\u00ba"+
		"\u00b1\u0001\u0000\u0000\u0000\u00ba\u00b6\u0001\u0000\u0000\u0000\u00bb"+
		"\u0013\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\u001b\u0000\u0000\u00bd"+
		"\u0015\u0001\u0000\u0000\u0000\u00be\u00bf\u0005\u001b\u0000\u0000\u00bf"+
		"\u0017\u0001\u0000\u0000\u0000$\u001c!\'*-038;>BEIOSX_dlqx}\u0082\u0085"+
		"\u008a\u008f\u0092\u0095\u0098\u009c\u00a3\u00a9\u00ae\u00b3\u00b8\u00ba";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}