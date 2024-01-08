// Generated from C:/Users/Daniel/AppDevelopment/scoreworks/OpticalMusicRecognition/src/main/java/net/scoreworks/omr/parsing/MusicScript.g4 by ANTLR 4.13.1
package net.scoreworks.omr.parsing;
import net.scoreworks.music.model.NoteType;
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, REPEAT=8, BARL=9, 
		NEWV=10, SKPV=11, GRACE=12, REST=13, DOT=14, TIE_START=15, TIE_END=16, 
		FLAG=17, BEAM=18, TUPL=19, STEM=20, NOTE_OPEN=21, NOTE_SOLID=22, SHARP=23, 
		FLAT=24, NATURAL=25, CLEF=26, DIGIT=27, SLASH=28, OTTV=29;
	public static final int
		RULE_score = 0, RULE_event = 1, RULE_segment = 2, RULE_group = 3, RULE_rest = 4, 
		RULE_chord = 5, RULE_note_open = 6, RULE_note_solid = 7, RULE_accidental = 8, 
		RULE_time = 9, RULE_key = 10, RULE_barline = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"score", "event", "segment", "group", "rest", "chord", "note_open", "note_solid", 
			"accidental", "time", "key", "barline"
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
		public BarlineContext barline() {
			return getRuleContext(BarlineContext.class,0);
		}
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(24);
					event();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(27); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(29);
			barline();
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
		Fraction tick;
		public BarlineContext barline() {
			return getRuleContext(BarlineContext.class,0);
		}
		public List<SegmentContext> segment() {
			return getRuleContexts(SegmentContext.class);
		}
		public SegmentContext segment(int i) {
			return getRuleContext(SegmentContext.class,i);
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
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==REPEAT || _la==BARL) {
					{
					setState(31);
					barline();
					}
				}

				setState(34);
				match(T__0);
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 800668912L) != 0)) {
					{
					{
					setState(35);
					segment();
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(41);
					match(T__1);
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 800668912L) != 0)) {
						{
						{
						setState(42);
						segment();
						}
						}
						setState(47);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==REPEAT || _la==BARL) {
					{
					setState(50);
					barline();
					}
				}

				setState(53);
				match(T__2);
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 800668912L) != 0)) {
					{
					{
					setState(54);
					segment();
					}
					}
					setState(59);
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
	public static class SegmentContext extends ParserRuleContext {
		int staffId;
		public TerminalNode CLEF() { return getToken(MusicScriptParser.CLEF, 0); }
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public TimeContext time() {
			return getRuleContext(TimeContext.class,0);
		}
		public List<TerminalNode> OTTV() { return getTokens(MusicScriptParser.OTTV); }
		public TerminalNode OTTV(int i) {
			return getToken(MusicScriptParser.OTTV, i);
		}
		public List<GroupContext> group() {
			return getRuleContexts(GroupContext.class);
		}
		public GroupContext group(int i) {
			return getRuleContext(GroupContext.class,i);
		}
		public SegmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterSegment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitSegment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitSegment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SegmentContext segment() throws RecognitionException {
		SegmentContext _localctx = new SegmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_segment);
		int _la;
		try {
			int _alt;
			setState(76);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(CLEF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				key();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				time();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OTTV) {
					{
					setState(65);
					match(OTTV);
					}
				}

				setState(69); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(68);
						group();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(71); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(74);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(73);
					match(OTTV);
					}
					break;
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
		int voiceId, dots;
		NoteType noteType;
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
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWV:
					{
					setState(78);
					match(NEWV);
					}
					break;
				case SKPV:
					{
					setState(80); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(79);
						match(SKPV);
						}
						}
						setState(82); 
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
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TUPL) {
					{
					setState(86);
					match(TUPL);
					}
				}

				setState(89);
				rest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWV:
					{
					setState(90);
					match(NEWV);
					}
					break;
				case SKPV:
					{
					setState(92); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(91);
						match(SKPV);
						}
						}
						setState(94); 
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
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TUPL) {
					{
					setState(98);
					match(TUPL);
					}
				}

				setState(101);
				chord();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWV:
					{
					setState(102);
					match(NEWV);
					}
					break;
				case SKPV:
					{
					setState(104); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(103);
						match(SKPV);
						}
						}
						setState(106); 
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
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==GRACE) {
					{
					{
					setState(110);
					match(GRACE);
					setState(111);
					chord();
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TUPL) {
					{
					setState(117);
					match(TUPL);
					}
				}

				setState(120);
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
			setState(123);
			match(REST);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BEAM) {
				{
				setState(124);
				match(BEAM);
				}
			}

			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(127);
				match(DOT);
				}
				}
				setState(132);
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
			setState(184);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(133);
						note_open();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(136); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(138);
					match(DOT);
					}
					}
					setState(143);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(STEM);
				setState(146); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(145);
						note_open();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(148); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(150);
					match(DOT);
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				match(STEM);
				setState(158); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(157);
						note_solid();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(160); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(162);
					match(DOT);
					}
					}
					setState(167);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				match(STEM);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEAM) {
					{
					setState(169);
					match(BEAM);
					}
				}

				setState(172);
				match(FLAG);
				setState(174); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(173);
						note_solid();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(176); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(178);
					match(DOT);
					}
					}
					setState(183);
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
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720304L) != 0)) {
				{
				setState(186);
				accidental();
				}
			}

			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_END) {
				{
				setState(189);
				match(TIE_END);
				}
			}

			setState(192);
			match(NOTE_OPEN);
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_START) {
				{
				setState(193);
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
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720304L) != 0)) {
				{
				setState(196);
				accidental();
				}
			}

			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_END) {
				{
				setState(199);
				match(TIE_END);
				}
			}

			setState(202);
			match(NOTE_SOLID);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_START) {
				{
				setState(203);
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
			setState(206);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720304L) != 0)) ) {
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
		enterRule(_localctx, 18, RULE_time);
		int _la;
		try {
			int _alt;
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(209); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(208);
					match(DIGIT);
					}
					}
					setState(211); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				setState(213);
				match(SLASH);
				setState(215); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(214);
						match(DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(217); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
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
		enterRule(_localctx, 20, RULE_key);
		try {
			int _alt;
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHARP:
				enterOuterAlt(_localctx, 1);
				{
				setState(224); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(223);
						match(SHARP);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(226); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case FLAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(229); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(228);
						match(FLAT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(231); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(234); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(233);
						match(NATURAL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(236); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
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
	public static class BarlineContext extends ParserRuleContext {
		public TerminalNode BARL() { return getToken(MusicScriptParser.BARL, 0); }
		public List<TerminalNode> REPEAT() { return getTokens(MusicScriptParser.REPEAT); }
		public TerminalNode REPEAT(int i) {
			return getToken(MusicScriptParser.REPEAT, i);
		}
		public BarlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_barline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterBarline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitBarline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitBarline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarlineContext barline() throws RecognitionException {
		BarlineContext _localctx = new BarlineContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_barline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REPEAT) {
				{
				setState(240);
				match(REPEAT);
				}
			}

			setState(243);
			match(BARL);
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REPEAT) {
				{
				setState(244);
				match(REPEAT);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u00f8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0001\u0000\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0003\u0001!\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001%\b\u0001\n\u0001\f\u0001(\t\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001,\b\u0001\n\u0001\f\u0001/\t\u0001\u0003\u00011\b\u0001"+
		"\u0001\u0001\u0003\u00014\b\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"8\b\u0001\n\u0001\f\u0001;\t\u0001\u0003\u0001=\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002C\b\u0002\u0001\u0002\u0004"+
		"\u0002F\b\u0002\u000b\u0002\f\u0002G\u0001\u0002\u0003\u0002K\b\u0002"+
		"\u0003\u0002M\b\u0002\u0001\u0003\u0001\u0003\u0004\u0003Q\b\u0003\u000b"+
		"\u0003\f\u0003R\u0003\u0003U\b\u0003\u0001\u0003\u0003\u0003X\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003]\b\u0003\u000b\u0003"+
		"\f\u0003^\u0003\u0003a\b\u0003\u0001\u0003\u0003\u0003d\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0004\u0003i\b\u0003\u000b\u0003\f\u0003"+
		"j\u0003\u0003m\b\u0003\u0001\u0003\u0001\u0003\u0005\u0003q\b\u0003\n"+
		"\u0003\f\u0003t\t\u0003\u0001\u0003\u0003\u0003w\b\u0003\u0001\u0003\u0003"+
		"\u0003z\b\u0003\u0001\u0004\u0001\u0004\u0003\u0004~\b\u0004\u0001\u0004"+
		"\u0005\u0004\u0081\b\u0004\n\u0004\f\u0004\u0084\t\u0004\u0001\u0005\u0004"+
		"\u0005\u0087\b\u0005\u000b\u0005\f\u0005\u0088\u0001\u0005\u0005\u0005"+
		"\u008c\b\u0005\n\u0005\f\u0005\u008f\t\u0005\u0001\u0005\u0001\u0005\u0004"+
		"\u0005\u0093\b\u0005\u000b\u0005\f\u0005\u0094\u0001\u0005\u0005\u0005"+
		"\u0098\b\u0005\n\u0005\f\u0005\u009b\t\u0005\u0001\u0005\u0001\u0005\u0004"+
		"\u0005\u009f\b\u0005\u000b\u0005\f\u0005\u00a0\u0001\u0005\u0005\u0005"+
		"\u00a4\b\u0005\n\u0005\f\u0005\u00a7\t\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u00ab\b\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u00af\b\u0005"+
		"\u000b\u0005\f\u0005\u00b0\u0001\u0005\u0005\u0005\u00b4\b\u0005\n\u0005"+
		"\f\u0005\u00b7\t\u0005\u0003\u0005\u00b9\b\u0005\u0001\u0006\u0003\u0006"+
		"\u00bc\b\u0006\u0001\u0006\u0003\u0006\u00bf\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u00c3\b\u0006\u0001\u0007\u0003\u0007\u00c6\b\u0007"+
		"\u0001\u0007\u0003\u0007\u00c9\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u00cd\b\u0007\u0001\b\u0001\b\u0001\t\u0004\t\u00d2\b\t\u000b\t\f\t\u00d3"+
		"\u0001\t\u0001\t\u0004\t\u00d8\b\t\u000b\t\f\t\u00d9\u0001\t\u0001\t\u0003"+
		"\t\u00de\b\t\u0001\n\u0004\n\u00e1\b\n\u000b\n\f\n\u00e2\u0001\n\u0004"+
		"\n\u00e6\b\n\u000b\n\f\n\u00e7\u0001\n\u0004\n\u00eb\b\n\u000b\n\f\n\u00ec"+
		"\u0003\n\u00ef\b\n\u0001\u000b\u0003\u000b\u00f2\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00f6\b\u000b\u0001\u000b\u0000\u0000\f\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0001\u0002\u0000"+
		"\u0004\u0005\u0017\u0019\u0127\u0000\u0019\u0001\u0000\u0000\u0000\u0002"+
		"<\u0001\u0000\u0000\u0000\u0004L\u0001\u0000\u0000\u0000\u0006y\u0001"+
		"\u0000\u0000\u0000\b{\u0001\u0000\u0000\u0000\n\u00b8\u0001\u0000\u0000"+
		"\u0000\f\u00bb\u0001\u0000\u0000\u0000\u000e\u00c5\u0001\u0000\u0000\u0000"+
		"\u0010\u00ce\u0001\u0000\u0000\u0000\u0012\u00dd\u0001\u0000\u0000\u0000"+
		"\u0014\u00ee\u0001\u0000\u0000\u0000\u0016\u00f1\u0001\u0000\u0000\u0000"+
		"\u0018\u001a\u0003\u0002\u0001\u0000\u0019\u0018\u0001\u0000\u0000\u0000"+
		"\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000"+
		"\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0003\u0016\u000b\u0000\u001e\u0001\u0001\u0000\u0000\u0000"+
		"\u001f!\u0003\u0016\u000b\u0000 \u001f\u0001\u0000\u0000\u0000 !\u0001"+
		"\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"&\u0005\u0001\u0000\u0000"+
		"#%\u0003\u0004\u0002\u0000$#\u0001\u0000\u0000\u0000%(\u0001\u0000\u0000"+
		"\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'0\u0001\u0000"+
		"\u0000\u0000(&\u0001\u0000\u0000\u0000)-\u0005\u0002\u0000\u0000*,\u0003"+
		"\u0004\u0002\u0000+*\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000"+
		"-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000"+
		"\u0000/-\u0001\u0000\u0000\u00000)\u0001\u0000\u0000\u000001\u0001\u0000"+
		"\u0000\u00001=\u0001\u0000\u0000\u000024\u0003\u0016\u000b\u000032\u0001"+
		"\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"59\u0005\u0003\u0000\u000068\u0003\u0004\u0002\u000076\u0001\u0000\u0000"+
		"\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001\u0000"+
		"\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000< \u0001"+
		"\u0000\u0000\u0000<3\u0001\u0000\u0000\u0000=\u0003\u0001\u0000\u0000"+
		"\u0000>M\u0005\u001a\u0000\u0000?M\u0003\u0014\n\u0000@M\u0003\u0012\t"+
		"\u0000AC\u0005\u001d\u0000\u0000BA\u0001\u0000\u0000\u0000BC\u0001\u0000"+
		"\u0000\u0000CE\u0001\u0000\u0000\u0000DF\u0003\u0006\u0003\u0000ED\u0001"+
		"\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000"+
		"GH\u0001\u0000\u0000\u0000HJ\u0001\u0000\u0000\u0000IK\u0005\u001d\u0000"+
		"\u0000JI\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KM\u0001\u0000"+
		"\u0000\u0000L>\u0001\u0000\u0000\u0000L?\u0001\u0000\u0000\u0000L@\u0001"+
		"\u0000\u0000\u0000LB\u0001\u0000\u0000\u0000M\u0005\u0001\u0000\u0000"+
		"\u0000NU\u0005\n\u0000\u0000OQ\u0005\u000b\u0000\u0000PO\u0001\u0000\u0000"+
		"\u0000QR\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000"+
		"\u0000\u0000SU\u0001\u0000\u0000\u0000TN\u0001\u0000\u0000\u0000TP\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000"+
		"VX\u0005\u0013\u0000\u0000WV\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000Yz\u0003\b\u0004\u0000Za\u0005\n\u0000"+
		"\u0000[]\u0005\u000b\u0000\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_a\u0001"+
		"\u0000\u0000\u0000`Z\u0001\u0000\u0000\u0000`\\\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000ac\u0001\u0000\u0000\u0000bd\u0005\u0013\u0000"+
		"\u0000cb\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0001\u0000"+
		"\u0000\u0000ez\u0003\n\u0005\u0000fm\u0005\n\u0000\u0000gi\u0005\u000b"+
		"\u0000\u0000hg\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jh\u0001"+
		"\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001\u0000\u0000\u0000"+
		"lf\u0001\u0000\u0000\u0000lh\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000"+
		"\u0000mr\u0001\u0000\u0000\u0000no\u0005\f\u0000\u0000oq\u0003\n\u0005"+
		"\u0000pn\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000sv\u0001\u0000\u0000\u0000tr\u0001"+
		"\u0000\u0000\u0000uw\u0005\u0013\u0000\u0000vu\u0001\u0000\u0000\u0000"+
		"vw\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u0003\n\u0005\u0000"+
		"yT\u0001\u0000\u0000\u0000y`\u0001\u0000\u0000\u0000yl\u0001\u0000\u0000"+
		"\u0000z\u0007\u0001\u0000\u0000\u0000{}\u0005\r\u0000\u0000|~\u0005\u0012"+
		"\u0000\u0000}|\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0082"+
		"\u0001\u0000\u0000\u0000\u007f\u0081\u0005\u000e\u0000\u0000\u0080\u007f"+
		"\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\t\u0001"+
		"\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0087\u0003"+
		"\f\u0006\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000"+
		"\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000"+
		"\u0000\u0000\u0089\u008d\u0001\u0000\u0000\u0000\u008a\u008c\u0005\u000e"+
		"\u0000\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000"+
		"\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\u00b9\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u0090\u0092\u0005\u0014\u0000\u0000\u0091\u0093\u0003\f\u0006"+
		"\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000"+
		"\u0000\u0094\u0092\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000"+
		"\u0000\u0095\u0099\u0001\u0000\u0000\u0000\u0096\u0098\u0005\u000e\u0000"+
		"\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000"+
		"\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000"+
		"\u0000\u009a\u00b9\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000"+
		"\u0000\u009c\u009e\u0005\u0014\u0000\u0000\u009d\u009f\u0003\u000e\u0007"+
		"\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a5\u0001\u0000\u0000\u0000\u00a2\u00a4\u0005\u000e\u0000"+
		"\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a6\u00b9\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a8\u00aa\u0005\u0014\u0000\u0000\u00a9\u00ab\u0005\u0012\u0000"+
		"\u0000\u00aa\u00a9\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00ae\u0005\u0011\u0000"+
		"\u0000\u00ad\u00af\u0003\u000e\u0007\u0000\u00ae\u00ad\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000"+
		"\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b5\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b4\u0005\u000e\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000"+
		"\u0000\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000"+
		"\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8\u0086\u0001\u0000\u0000"+
		"\u0000\u00b8\u0090\u0001\u0000\u0000\u0000\u00b8\u009c\u0001\u0000\u0000"+
		"\u0000\u00b8\u00a8\u0001\u0000\u0000\u0000\u00b9\u000b\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bc\u0003\u0010\b\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00be\u0001\u0000\u0000\u0000"+
		"\u00bd\u00bf\u0005\u0010\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000"+
		"\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000"+
		"\u00c0\u00c2\u0005\u0015\u0000\u0000\u00c1\u00c3\u0005\u000f\u0000\u0000"+
		"\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c3\r\u0001\u0000\u0000\u0000\u00c4\u00c6\u0003\u0010\b\u0000\u00c5"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c8\u0001\u0000\u0000\u0000\u00c7\u00c9\u0005\u0010\u0000\u0000\u00c8"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cc\u0005\u0016\u0000\u0000\u00cb"+
		"\u00cd\u0005\u000f\u0000\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cd\u000f\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\u0007\u0000\u0000\u0000\u00cf\u0011\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d2\u0005\u001b\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d7\u0005\u001c\u0000\u0000\u00d6\u00d8\u0005\u001b\u0000\u0000\u00d7"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da"+
		"\u00de\u0001\u0000\u0000\u0000\u00db\u00de\u0005\u0006\u0000\u0000\u00dc"+
		"\u00de\u0005\u0007\u0000\u0000\u00dd\u00d1\u0001\u0000\u0000\u0000\u00dd"+
		"\u00db\u0001\u0000\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de"+
		"\u0013\u0001\u0000\u0000\u0000\u00df\u00e1\u0005\u0017\u0000\u0000\u00e0"+
		"\u00df\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3"+
		"\u00ef\u0001\u0000\u0000\u0000\u00e4\u00e6\u0005\u0018\u0000\u0000\u00e5"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8"+
		"\u00ef\u0001\u0000\u0000\u0000\u00e9\u00eb\u0005\u0019\u0000\u0000\u00ea"+
		"\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ef\u0001\u0000\u0000\u0000\u00ee\u00e0\u0001\u0000\u0000\u0000\u00ee"+
		"\u00e5\u0001\u0000\u0000\u0000\u00ee\u00ea\u0001\u0000\u0000\u0000\u00ef"+
		"\u0015\u0001\u0000\u0000\u0000\u00f0\u00f2\u0005\b\u0000\u0000\u00f1\u00f0"+
		"\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000\u0000\u00f2\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f3\u00f5\u0005\t\u0000\u0000\u00f4\u00f6\u0005"+
		"\b\u0000\u0000\u00f5\u00f4\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f6\u0017\u0001\u0000\u0000\u00002\u001b &-039<BGJLRTW"+
		"^`cjlrvy}\u0082\u0088\u008d\u0094\u0099\u00a0\u00a5\u00aa\u00b0\u00b5"+
		"\u00b8\u00bb\u00be\u00c2\u00c5\u00c8\u00cc\u00d3\u00d9\u00dd\u00e2\u00e7"+
		"\u00ec\u00ee\u00f1\u00f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}