// Generated from C:/Users/Daniel/AppDevelopment/scoreworks/OpticalMusicRecognition/src/main/java/net/scoreworks/omr/parsing/MusicScript.g4 by ANTLR 4.13.1
package net.scoreworks.omr.parsing.antlr;
import net.scoreworks.music.utils.Fraction;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, BARL=8, NEWV=9, 
		SKPV=10, GRACE=11, REST=12, DOT=13, TIE_START=14, TIE_END=15, FLAG=16, 
		BEAM=17, TUPL=18, STEM=19, NOTE_OPEN=20, NOTE_SOLID=21, SHARP=22, FLAT=23, 
		NATURAL=24, CLEF=25, DIGIT=26, SLASH=27, OTTV=28;
	public static final int
		RULE_score = 0, RULE_event = 1, RULE_staff = 2, RULE_group = 3, RULE_rest = 4, 
		RULE_chord = 5, RULE_note_open = 6, RULE_note_solid = 7, RULE_accidental = 8, 
		RULE_meta = 9, RULE_time = 10, RULE_key = 11, RULE_ottavastart = 12, RULE_ottavaend = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"score", "event", "staff", "group", "rest", "chord", "note_open", "note_solid", 
			"accidental", "meta", "time", "key", "ottavastart", "ottavaend"
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
		public TerminalNode BARL() { return getToken(MusicScriptParser.BARL, 0); }
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
			setState(28);
			match(BARL);
			setState(30); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(29);
				event();
				}
				}
				setState(32); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 || _la==T__2 );
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
		public Fraction tick;	//manually added
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
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(34);
				match(T__0);
				setState(35);
				staff();
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(36);
					match(T__1);
					setState(37);
					staff();
					}
				}

				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BARL) {
					{
					setState(40);
					match(BARL);
					}
				}

				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				match(T__2);
				setState(44);
				staff();
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BARL) {
					{
					setState(45);
					match(BARL);
					}
				}

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
	public static class StaffContext extends ParserRuleContext {
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
			int _alt;
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(50);
						meta();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(53); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(56);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(55);
					ottavastart();
					}
					break;
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 31235632L) != 0)) {
					{
					{
					setState(58);
					group();
					}
					}
					setState(63);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OTTV) {
					{
					setState(64);
					ottavaend();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OTTV) {
					{
					setState(67);
					ottavastart();
					}
				}

				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(70);
					group();
					}
					}
					setState(73); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 31235632L) != 0) );
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OTTV) {
					{
					setState(75);
					ottavaend();
					}
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
	public static class GroupContext extends ParserRuleContext {
		public RestContext rest() {
			return getRuleContext(RestContext.class,0);
		}
		public TerminalNode NEWV() { return getToken(MusicScriptParser.NEWV, 0); }
		public TerminalNode TUPL() { return getToken(MusicScriptParser.TUPL, 0); }
		public List<TerminalNode> SKPV() { return getTokens(MusicScriptParser.SKPV); }
		public TerminalNode SKPV(int i) {
			return getToken(MusicScriptParser.SKPV, i);
		}
		public List<ChordContext> chord() {
			return getRuleContexts(ChordContext.class);
		}
		public ChordContext chord(int i) {
			return getRuleContext(ChordContext.class,i);
		}
		public List<TerminalNode> GRACE() { return getTokens(MusicScriptParser.GRACE); }
		public TerminalNode GRACE(int i) {
			return getToken(MusicScriptParser.GRACE, i);
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
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWV:
					{
					setState(80);
					match(NEWV);
					}
					break;
				case SKPV:
					{
					setState(82); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(81);
						match(SKPV);
						}
						}
						setState(84); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SKPV );
					}
					break;
				case REST:
				case TUPL:
					break;
				default:
					break;
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TUPL) {
					{
					setState(88);
					match(TUPL);
					}
				}

				setState(91);
				rest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWV:
					{
					setState(92);
					match(NEWV);
					}
					break;
				case SKPV:
					{
					setState(94); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(93);
						match(SKPV);
						}
						}
						setState(96); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SKPV );
					}
					break;
				case T__3:
				case T__4:
				case TIE_END:
				case TUPL:
				case STEM:
				case NOTE_OPEN:
				case SHARP:
				case FLAT:
				case NATURAL:
					break;
				default:
					break;
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TUPL) {
					{
					setState(100);
					match(TUPL);
					}
				}

				setState(103);
				chord();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWV:
					{
					setState(104);
					match(NEWV);
					}
					break;
				case SKPV:
					{
					setState(106); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(105);
						match(SKPV);
						}
						}
						setState(108); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==SKPV );
					}
					break;
				case T__3:
				case T__4:
				case GRACE:
				case TIE_END:
				case TUPL:
				case STEM:
				case NOTE_OPEN:
				case SHARP:
				case FLAT:
				case NATURAL:
					break;
				default:
					break;
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==GRACE) {
					{
					{
					setState(112);
					match(GRACE);
					setState(113);
					chord();
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TUPL) {
					{
					setState(119);
					match(TUPL);
					}
				}

				setState(122);
				chord();
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
			setState(125);
			match(REST);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BEAM) {
				{
				setState(126);
				match(BEAM);
				}
			}

			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(129);
				match(DOT);
				}
				}
				setState(134);
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
		public List<Note_openContext> note_open() {
			return getRuleContexts(Note_openContext.class);
		}
		public Note_openContext note_open(int i) {
			return getRuleContext(Note_openContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(MusicScriptParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(MusicScriptParser.DOT, i);
		}
		public TerminalNode STEM() { return getToken(MusicScriptParser.STEM, 0); }
		public List<Note_solidContext> note_solid() {
			return getRuleContexts(Note_solidContext.class);
		}
		public Note_solidContext note_solid(int i) {
			return getRuleContext(Note_solidContext.class,i);
		}
		public TerminalNode FLAG() { return getToken(MusicScriptParser.FLAG, 0); }
		public TerminalNode BEAM() { return getToken(MusicScriptParser.BEAM, 0); }
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
			int _alt;
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(135);
						note_open();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(138); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(STEM);
				setState(148); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(147);
						note_open();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(150); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(152);
					match(DOT);
					}
					}
					setState(157);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				match(STEM);
				setState(160); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(159);
						note_solid();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(162); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(164);
					match(DOT);
					}
					}
					setState(169);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				match(STEM);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEAM) {
					{
					setState(171);
					match(BEAM);
					}
				}

				setState(174);
				match(FLAG);
				setState(176); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(175);
						note_solid();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(178); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(180);
					match(DOT);
					}
					}
					setState(185);
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
	public static class Note_openContext extends ParserRuleContext {
		public TerminalNode NOTE_OPEN() { return getToken(MusicScriptParser.NOTE_OPEN, 0); }
		public AccidentalContext accidental() {
			return getRuleContext(AccidentalContext.class,0);
		}
		public TerminalNode TIE_END() { return getToken(MusicScriptParser.TIE_END, 0); }
		public TerminalNode TIE_START() { return getToken(MusicScriptParser.TIE_START, 0); }
		public Note_openContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note_open; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterNote_open(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitNote_open(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitNote_open(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Note_openContext note_open() throws RecognitionException {
		Note_openContext _localctx = new Note_openContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_note_open);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360176L) != 0)) {
				{
				setState(188);
				accidental();
				}
			}

			setState(192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_END) {
				{
				setState(191);
				match(TIE_END);
				}
			}

			setState(194);
			match(NOTE_OPEN);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_START) {
				{
				setState(195);
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
	public static class Note_solidContext extends ParserRuleContext {
		public TerminalNode NOTE_SOLID() { return getToken(MusicScriptParser.NOTE_SOLID, 0); }
		public AccidentalContext accidental() {
			return getRuleContext(AccidentalContext.class,0);
		}
		public TerminalNode TIE_END() { return getToken(MusicScriptParser.TIE_END, 0); }
		public TerminalNode TIE_START() { return getToken(MusicScriptParser.TIE_START, 0); }
		public Note_solidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note_solid; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterNote_solid(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitNote_solid(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitNote_solid(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Note_solidContext note_solid() throws RecognitionException {
		Note_solidContext _localctx = new Note_solidContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_note_solid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360176L) != 0)) {
				{
				setState(198);
				accidental();
				}
			}

			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_END) {
				{
				setState(201);
				match(TIE_END);
				}
			}

			setState(204);
			match(NOTE_SOLID);
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_START) {
				{
				setState(205);
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
		enterRule(_localctx, 16, RULE_accidental);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 29360176L) != 0)) ) {
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
	public static class MetaContext extends ParserRuleContext {
		public TerminalNode CLEF() { return getToken(MusicScriptParser.CLEF, 0); }
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
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
		enterRule(_localctx, 18, RULE_meta);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLEF:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(CLEF);
				}
				break;
			case SHARP:
			case FLAT:
			case NATURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				key();
				}
				break;
			case T__5:
			case T__6:
			case DIGIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				time();
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
		enterRule(_localctx, 20, RULE_time);
		int _la;
		try {
			int _alt;
			setState(228);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(216); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(215);
					match(DIGIT);
					}
					}
					setState(218); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				setState(220);
				match(SLASH);
				setState(222); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(221);
						match(DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(224); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(226);
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(227);
				match(T__6);
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
		enterRule(_localctx, 22, RULE_key);
		try {
			int _alt;
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHARP:
				enterOuterAlt(_localctx, 1);
				{
				setState(231); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(230);
						match(SHARP);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(233); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case FLAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(236); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(235);
						match(FLAT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(238); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(241); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(240);
						match(NATURAL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(243); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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
		enterRule(_localctx, 24, RULE_ottavastart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
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
		enterRule(_localctx, 26, RULE_ottavaend);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
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
		"\u0004\u0001\u001c\u00fc\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0004\u0000\u001f"+
		"\b\u0000\u000b\u0000\f\u0000 \u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\'\b\u0001\u0001\u0001\u0003\u0001*\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001/\b\u0001\u0003\u00011\b\u0001\u0001"+
		"\u0002\u0004\u00024\b\u0002\u000b\u0002\f\u00025\u0001\u0002\u0003\u0002"+
		"9\b\u0002\u0001\u0002\u0005\u0002<\b\u0002\n\u0002\f\u0002?\t\u0002\u0001"+
		"\u0002\u0003\u0002B\b\u0002\u0001\u0002\u0003\u0002E\b\u0002\u0001\u0002"+
		"\u0004\u0002H\b\u0002\u000b\u0002\f\u0002I\u0001\u0002\u0003\u0002M\b"+
		"\u0002\u0003\u0002O\b\u0002\u0001\u0003\u0001\u0003\u0004\u0003S\b\u0003"+
		"\u000b\u0003\f\u0003T\u0003\u0003W\b\u0003\u0001\u0003\u0003\u0003Z\b"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003_\b\u0003\u000b"+
		"\u0003\f\u0003`\u0003\u0003c\b\u0003\u0001\u0003\u0003\u0003f\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003k\b\u0003\u000b\u0003"+
		"\f\u0003l\u0003\u0003o\b\u0003\u0001\u0003\u0001\u0003\u0005\u0003s\b"+
		"\u0003\n\u0003\f\u0003v\t\u0003\u0001\u0003\u0003\u0003y\b\u0003\u0001"+
		"\u0003\u0003\u0003|\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004\u0080"+
		"\b\u0004\u0001\u0004\u0005\u0004\u0083\b\u0004\n\u0004\f\u0004\u0086\t"+
		"\u0004\u0001\u0005\u0004\u0005\u0089\b\u0005\u000b\u0005\f\u0005\u008a"+
		"\u0001\u0005\u0005\u0005\u008e\b\u0005\n\u0005\f\u0005\u0091\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0004\u0005\u0095\b\u0005\u000b\u0005\f\u0005\u0096"+
		"\u0001\u0005\u0005\u0005\u009a\b\u0005\n\u0005\f\u0005\u009d\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0004\u0005\u00a1\b\u0005\u000b\u0005\f\u0005\u00a2"+
		"\u0001\u0005\u0005\u0005\u00a6\b\u0005\n\u0005\f\u0005\u00a9\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u00ad\b\u0005\u0001\u0005\u0001\u0005\u0004"+
		"\u0005\u00b1\b\u0005\u000b\u0005\f\u0005\u00b2\u0001\u0005\u0005\u0005"+
		"\u00b6\b\u0005\n\u0005\f\u0005\u00b9\t\u0005\u0003\u0005\u00bb\b\u0005"+
		"\u0001\u0006\u0003\u0006\u00be\b\u0006\u0001\u0006\u0003\u0006\u00c1\b"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00c5\b\u0006\u0001\u0007\u0003"+
		"\u0007\u00c8\b\u0007\u0001\u0007\u0003\u0007\u00cb\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u00cf\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t"+
		"\u0001\t\u0003\t\u00d6\b\t\u0001\n\u0004\n\u00d9\b\n\u000b\n\f\n\u00da"+
		"\u0001\n\u0001\n\u0004\n\u00df\b\n\u000b\n\f\n\u00e0\u0001\n\u0001\n\u0003"+
		"\n\u00e5\b\n\u0001\u000b\u0004\u000b\u00e8\b\u000b\u000b\u000b\f\u000b"+
		"\u00e9\u0001\u000b\u0004\u000b\u00ed\b\u000b\u000b\u000b\f\u000b\u00ee"+
		"\u0001\u000b\u0004\u000b\u00f2\b\u000b\u000b\u000b\f\u000b\u00f3\u0003"+
		"\u000b\u00f6\b\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0000\u0000"+
		"\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u0000\u0001\u0002\u0000\u0004\u0005\u0016\u0018\u0128\u0000\u001c"+
		"\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u0004N\u0001\u0000"+
		"\u0000\u0000\u0006{\u0001\u0000\u0000\u0000\b}\u0001\u0000\u0000\u0000"+
		"\n\u00ba\u0001\u0000\u0000\u0000\f\u00bd\u0001\u0000\u0000\u0000\u000e"+
		"\u00c7\u0001\u0000\u0000\u0000\u0010\u00d0\u0001\u0000\u0000\u0000\u0012"+
		"\u00d5\u0001\u0000\u0000\u0000\u0014\u00e4\u0001\u0000\u0000\u0000\u0016"+
		"\u00f5\u0001\u0000\u0000\u0000\u0018\u00f7\u0001\u0000\u0000\u0000\u001a"+
		"\u00f9\u0001\u0000\u0000\u0000\u001c\u001e\u0005\b\u0000\u0000\u001d\u001f"+
		"\u0003\u0002\u0001\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f \u0001"+
		"\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000"+
		"\u0000!\u0001\u0001\u0000\u0000\u0000\"#\u0005\u0001\u0000\u0000#&\u0003"+
		"\u0004\u0002\u0000$%\u0005\u0002\u0000\u0000%\'\u0003\u0004\u0002\u0000"+
		"&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000"+
		"\u0000(*\u0005\b\u0000\u0000)(\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000"+
		"\u0000*1\u0001\u0000\u0000\u0000+,\u0005\u0003\u0000\u0000,.\u0003\u0004"+
		"\u0002\u0000-/\u0005\b\u0000\u0000.-\u0001\u0000\u0000\u0000./\u0001\u0000"+
		"\u0000\u0000/1\u0001\u0000\u0000\u00000\"\u0001\u0000\u0000\u00000+\u0001"+
		"\u0000\u0000\u00001\u0003\u0001\u0000\u0000\u000024\u0003\u0012\t\u0000"+
		"32\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u000056\u0001\u0000\u0000\u000068\u0001\u0000\u0000\u000079\u0003\u0018"+
		"\f\u000087\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009=\u0001\u0000"+
		"\u0000\u0000:<\u0003\u0006\u0003\u0000;:\u0001\u0000\u0000\u0000<?\u0001"+
		"\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000"+
		">A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000@B\u0003\u001a\r\u0000"+
		"A@\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BO\u0001\u0000\u0000"+
		"\u0000CE\u0003\u0018\f\u0000DC\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000EG\u0001\u0000\u0000\u0000FH\u0003\u0006\u0003\u0000GF\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001"+
		"\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000KM\u0003\u001a\r\u0000LK\u0001"+
		"\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0001\u0000\u0000\u0000"+
		"N3\u0001\u0000\u0000\u0000ND\u0001\u0000\u0000\u0000O\u0005\u0001\u0000"+
		"\u0000\u0000PW\u0005\t\u0000\u0000QS\u0005\n\u0000\u0000RQ\u0001\u0000"+
		"\u0000\u0000ST\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001"+
		"\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VP\u0001\u0000\u0000\u0000"+
		"VR\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001\u0000\u0000"+
		"\u0000XZ\u0005\u0012\u0000\u0000YX\u0001\u0000\u0000\u0000YZ\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[|\u0003\b\u0004\u0000\\c\u0005"+
		"\t\u0000\u0000]_\u0005\n\u0000\u0000^]\u0001\u0000\u0000\u0000_`\u0001"+
		"\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000"+
		"ac\u0001\u0000\u0000\u0000b\\\u0001\u0000\u0000\u0000b^\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000ce\u0001\u0000\u0000\u0000df\u0005\u0012"+
		"\u0000\u0000ed\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0001"+
		"\u0000\u0000\u0000g|\u0003\n\u0005\u0000ho\u0005\t\u0000\u0000ik\u0005"+
		"\n\u0000\u0000ji\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lj\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mo\u0001\u0000\u0000\u0000"+
		"nh\u0001\u0000\u0000\u0000nj\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000ot\u0001\u0000\u0000\u0000pq\u0005\u000b\u0000\u0000qs\u0003\n\u0005"+
		"\u0000rp\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001\u0000"+
		"\u0000\u0000tu\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000\u0000vt\u0001"+
		"\u0000\u0000\u0000wy\u0005\u0012\u0000\u0000xw\u0001\u0000\u0000\u0000"+
		"xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0003\n\u0005\u0000"+
		"{V\u0001\u0000\u0000\u0000{b\u0001\u0000\u0000\u0000{n\u0001\u0000\u0000"+
		"\u0000|\u0007\u0001\u0000\u0000\u0000}\u007f\u0005\f\u0000\u0000~\u0080"+
		"\u0005\u0011\u0000\u0000\u007f~\u0001\u0000\u0000\u0000\u007f\u0080\u0001"+
		"\u0000\u0000\u0000\u0080\u0084\u0001\u0000\u0000\u0000\u0081\u0083\u0005"+
		"\r\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083\u0086\u0001\u0000"+
		"\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000"+
		"\u0000\u0000\u0085\t\u0001\u0000\u0000\u0000\u0086\u0084\u0001\u0000\u0000"+
		"\u0000\u0087\u0089\u0003\f\u0006\u0000\u0088\u0087\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008f\u0001\u0000\u0000\u0000"+
		"\u008c\u008e\u0005\r\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u00bb\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0092\u0094\u0005\u0013\u0000\u0000\u0093"+
		"\u0095\u0003\f\u0006\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097"+
		"\u0001\u0000\u0000\u0000\u0097\u009b\u0001\u0000\u0000\u0000\u0098\u009a"+
		"\u0005\r\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u009a\u009d\u0001"+
		"\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001"+
		"\u0000\u0000\u0000\u009c\u00bb\u0001\u0000\u0000\u0000\u009d\u009b\u0001"+
		"\u0000\u0000\u0000\u009e\u00a0\u0005\u0013\u0000\u0000\u009f\u00a1\u0003"+
		"\u000e\u0007\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a7\u0001\u0000\u0000\u0000\u00a4\u00a6\u0005"+
		"\r\u0000\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000"+
		"\u0000\u0000\u00a8\u00bb\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ac\u0005\u0013\u0000\u0000\u00ab\u00ad\u0005\u0011"+
		"\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00b0\u0005\u0010"+
		"\u0000\u0000\u00af\u00b1\u0003\u000e\u0007\u0000\u00b0\u00af\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b2\u00b3\u0001\u0000\u0000\u0000\u00b3\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b6\u0005\r\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000\u0000"+
		"\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u0088\u0001\u0000\u0000"+
		"\u0000\u00ba\u0092\u0001\u0000\u0000\u0000\u00ba\u009e\u0001\u0000\u0000"+
		"\u0000\u00ba\u00aa\u0001\u0000\u0000\u0000\u00bb\u000b\u0001\u0000\u0000"+
		"\u0000\u00bc\u00be\u0003\u0010\b\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c1\u0005\u000f\u0000\u0000\u00c0\u00bf\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c4\u0005\u0014\u0000\u0000\u00c3\u00c5\u0005\u000e\u0000\u0000"+
		"\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c5\r\u0001\u0000\u0000\u0000\u00c6\u00c8\u0003\u0010\b\u0000\u00c7"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8"+
		"\u00ca\u0001\u0000\u0000\u0000\u00c9\u00cb\u0005\u000f\u0000\u0000\u00ca"+
		"\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ce\u0005\u0015\u0000\u0000\u00cd"+
		"\u00cf\u0005\u000e\u0000\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\u0001\u0000\u0000\u0000\u00cf\u000f\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0007\u0000\u0000\u0000\u00d1\u0011\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d6\u0005\u0019\u0000\u0000\u00d3\u00d6\u0003\u0016\u000b\u0000\u00d4"+
		"\u00d6\u0003\u0014\n\u0000\u00d5\u00d2\u0001\u0000\u0000\u0000\u00d5\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d6\u0013"+
		"\u0001\u0000\u0000\u0000\u00d7\u00d9\u0005\u001a\u0000\u0000\u00d8\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00d8"+
		"\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u00dc"+
		"\u0001\u0000\u0000\u0000\u00dc\u00de\u0005\u001b\u0000\u0000\u00dd\u00df"+
		"\u0005\u001a\u0000\u0000\u00de\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0"+
		"\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e0\u00e1"+
		"\u0001\u0000\u0000\u0000\u00e1\u00e5\u0001\u0000\u0000\u0000\u00e2\u00e5"+
		"\u0005\u0006\u0000\u0000\u00e3\u00e5\u0005\u0007\u0000\u0000\u00e4\u00d8"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e3"+
		"\u0001\u0000\u0000\u0000\u00e5\u0015\u0001\u0000\u0000\u0000\u00e6\u00e8"+
		"\u0005\u0016\u0000\u0000\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e8\u00e9"+
		"\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ea\u00f6\u0001\u0000\u0000\u0000\u00eb\u00ed"+
		"\u0005\u0017\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0001\u0000\u0000\u0000\u00ef\u00f6\u0001\u0000\u0000\u0000\u00f0\u00f2"+
		"\u0005\u0018\u0000\u0000\u00f1\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5\u00e7"+
		"\u0001\u0000\u0000\u0000\u00f5\u00ec\u0001\u0000\u0000\u0000\u00f5\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f6\u0017\u0001\u0000\u0000\u0000\u00f7\u00f8"+
		"\u0005\u001c\u0000\u0000\u00f8\u0019\u0001\u0000\u0000\u0000\u00f9\u00fa"+
		"\u0005\u001c\u0000\u0000\u00fa\u001b\u0001\u0000\u0000\u00002 &).058="+
		"ADILNTVY`belntx{\u007f\u0084\u008a\u008f\u0096\u009b\u00a2\u00a7\u00ac"+
		"\u00b2\u00b7\u00ba\u00bd\u00c0\u00c4\u00c7\u00ca\u00ce\u00d5\u00da\u00e0"+
		"\u00e4\u00e9\u00ee\u00f3\u00f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}