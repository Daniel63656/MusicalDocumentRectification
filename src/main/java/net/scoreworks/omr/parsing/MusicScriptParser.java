// Generated from C:/Users/Daniel/AppDevelopment/scoreworks/OpticalMusicRecognition/src/main/java/net/scoreworks/omr/parsing/MusicScript.g4 by ANTLR 4.13.1
package net.scoreworks.omr.parsing;
import net.scoreworks.music.model.NoteType;
import net.scoreworks.music.utils.Fraction;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

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
		RULE_barline = 9, RULE_time = 10, RULE_key = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"score", "event", "segment", "group", "rest", "chord", "note_open", "note_solid", 
			"accidental", "barline", "time", "key"
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
		Fraction onset;
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
			setState(57);
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
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(35);
					segment();
					}
					}
					setState(38); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 800668912L) != 0) );
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(40);
					match(T__1);
					setState(42); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(41);
						segment();
						}
						}
						setState(44); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 800668912L) != 0) );
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==REPEAT || _la==BARL) {
					{
					setState(48);
					barline();
					}
				}

				setState(51);
				match(T__2);
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(52);
					segment();
					}
					}
					setState(55); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 800668912L) != 0) );
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
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				match(CLEF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				key();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				time();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OTTV) {
					{
					setState(62);
					match(OTTV);
					}
				}

				setState(66); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(65);
						group();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(68); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(71);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(70);
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
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWV:
					{
					setState(75);
					match(NEWV);
					}
					break;
				case SKPV:
					{
					setState(77); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(76);
						match(SKPV);
						}
						}
						setState(79); 
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
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TUPL) {
					{
					setState(83);
					match(TUPL);
					}
				}

				setState(86);
				rest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NEWV:
					{
					setState(87);
					match(NEWV);
					}
					break;
				case SKPV:
					{
					setState(89); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(88);
						match(SKPV);
						}
						}
						setState(91); 
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
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==GRACE) {
					{
					{
					setState(95);
					match(GRACE);
					setState(96);
					chord();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TUPL) {
					{
					setState(102);
					match(TUPL);
					}
				}

				setState(105);
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
			setState(108);
			match(REST);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BEAM) {
				{
				setState(109);
				match(BEAM);
				}
			}

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
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(118);
						note_open();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(121); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(123);
					match(DOT);
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(STEM);
				setState(131); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(130);
						note_open();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(133); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(135);
					match(DOT);
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				match(STEM);
				setState(143); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(142);
						note_solid();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(145); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(147);
					match(DOT);
					}
					}
					setState(152);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
				match(STEM);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEAM) {
					{
					setState(154);
					match(BEAM);
					}
				}

				setState(157);
				match(FLAG);
				setState(159); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(158);
						note_solid();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(161); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(163);
					match(DOT);
					}
					}
					setState(168);
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
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720304L) != 0)) {
				{
				setState(171);
				accidental();
				}
			}

			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_END) {
				{
				setState(174);
				match(TIE_END);
				}
			}

			setState(177);
			match(NOTE_OPEN);
			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_START) {
				{
				setState(178);
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
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 58720304L) != 0)) {
				{
				setState(181);
				accidental();
				}
			}

			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_END) {
				{
				setState(184);
				match(TIE_END);
				}
			}

			setState(187);
			match(NOTE_SOLID);
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_START) {
				{
				setState(188);
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
			setState(191);
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
		enterRule(_localctx, 18, RULE_barline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REPEAT) {
				{
				setState(193);
				match(REPEAT);
				}
			}

			setState(196);
			match(BARL);
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REPEAT) {
				{
				setState(197);
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
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(201); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(200);
					match(DIGIT);
					}
					}
					setState(203); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				setState(205);
				match(SLASH);
				setState(207); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(206);
						match(DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(209); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(T__5);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
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
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHARP:
				enterOuterAlt(_localctx, 1);
				{
				setState(216); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(215);
						match(SHARP);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(218); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case FLAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(221); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(220);
						match(FLAT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(223); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(226); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(225);
						match(NATURAL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(228); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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

	public static final String _serializedATN =
		"\u0004\u0001\u001d\u00e9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0001\u0000\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0003\u0001!\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0004\u0001%\b\u0001\u000b\u0001\f\u0001&\u0001\u0001\u0001\u0001"+
		"\u0004\u0001+\b\u0001\u000b\u0001\f\u0001,\u0003\u0001/\b\u0001\u0001"+
		"\u0001\u0003\u00012\b\u0001\u0001\u0001\u0001\u0001\u0004\u00016\b\u0001"+
		"\u000b\u0001\f\u00017\u0003\u0001:\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002@\b\u0002\u0001\u0002\u0004\u0002C\b\u0002"+
		"\u000b\u0002\f\u0002D\u0001\u0002\u0003\u0002H\b\u0002\u0003\u0002J\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0004\u0003N\b\u0003\u000b\u0003\f\u0003"+
		"O\u0003\u0003R\b\u0003\u0001\u0003\u0003\u0003U\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0004\u0003Z\b\u0003\u000b\u0003\f\u0003[\u0003\u0003"+
		"^\b\u0003\u0001\u0003\u0001\u0003\u0005\u0003b\b\u0003\n\u0003\f\u0003"+
		"e\t\u0003\u0001\u0003\u0003\u0003h\b\u0003\u0001\u0003\u0003\u0003k\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0003\u0004o\b\u0004\u0001\u0004\u0005"+
		"\u0004r\b\u0004\n\u0004\f\u0004u\t\u0004\u0001\u0005\u0004\u0005x\b\u0005"+
		"\u000b\u0005\f\u0005y\u0001\u0005\u0005\u0005}\b\u0005\n\u0005\f\u0005"+
		"\u0080\t\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u0084\b\u0005\u000b"+
		"\u0005\f\u0005\u0085\u0001\u0005\u0005\u0005\u0089\b\u0005\n\u0005\f\u0005"+
		"\u008c\t\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u0090\b\u0005\u000b"+
		"\u0005\f\u0005\u0091\u0001\u0005\u0005\u0005\u0095\b\u0005\n\u0005\f\u0005"+
		"\u0098\t\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u009c\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0004\u0005\u00a0\b\u0005\u000b\u0005\f\u0005\u00a1"+
		"\u0001\u0005\u0005\u0005\u00a5\b\u0005\n\u0005\f\u0005\u00a8\t\u0005\u0003"+
		"\u0005\u00aa\b\u0005\u0001\u0006\u0003\u0006\u00ad\b\u0006\u0001\u0006"+
		"\u0003\u0006\u00b0\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00b4\b"+
		"\u0006\u0001\u0007\u0003\u0007\u00b7\b\u0007\u0001\u0007\u0003\u0007\u00ba"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00be\b\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0003\t\u00c3\b\t\u0001\t\u0001\t\u0003\t\u00c7\b\t\u0001\n"+
		"\u0004\n\u00ca\b\n\u000b\n\f\n\u00cb\u0001\n\u0001\n\u0004\n\u00d0\b\n"+
		"\u000b\n\f\n\u00d1\u0001\n\u0001\n\u0003\n\u00d6\b\n\u0001\u000b\u0004"+
		"\u000b\u00d9\b\u000b\u000b\u000b\f\u000b\u00da\u0001\u000b\u0004\u000b"+
		"\u00de\b\u000b\u000b\u000b\f\u000b\u00df\u0001\u000b\u0004\u000b\u00e3"+
		"\b\u000b\u000b\u000b\f\u000b\u00e4\u0003\u000b\u00e7\b\u000b\u0001\u000b"+
		"\u0000\u0000\f\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0000\u0001\u0002\u0000\u0004\u0005\u0017\u0019\u0113\u0000\u0019\u0001"+
		"\u0000\u0000\u0000\u00029\u0001\u0000\u0000\u0000\u0004I\u0001\u0000\u0000"+
		"\u0000\u0006j\u0001\u0000\u0000\u0000\bl\u0001\u0000\u0000\u0000\n\u00a9"+
		"\u0001\u0000\u0000\u0000\f\u00ac\u0001\u0000\u0000\u0000\u000e\u00b6\u0001"+
		"\u0000\u0000\u0000\u0010\u00bf\u0001\u0000\u0000\u0000\u0012\u00c2\u0001"+
		"\u0000\u0000\u0000\u0014\u00d5\u0001\u0000\u0000\u0000\u0016\u00e6\u0001"+
		"\u0000\u0000\u0000\u0018\u001a\u0003\u0002\u0001\u0000\u0019\u0018\u0001"+
		"\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u0019\u0001"+
		"\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0003\u0012\t\u0000\u001e\u0001\u0001\u0000"+
		"\u0000\u0000\u001f!\u0003\u0012\t\u0000 \u001f\u0001\u0000\u0000\u0000"+
		" !\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0005\u0001\u0000"+
		"\u0000#%\u0003\u0004\u0002\u0000$#\u0001\u0000\u0000\u0000%&\u0001\u0000"+
		"\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'.\u0001"+
		"\u0000\u0000\u0000(*\u0005\u0002\u0000\u0000)+\u0003\u0004\u0002\u0000"+
		"*)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000"+
		"\u0000,-\u0001\u0000\u0000\u0000-/\u0001\u0000\u0000\u0000.(\u0001\u0000"+
		"\u0000\u0000./\u0001\u0000\u0000\u0000/:\u0001\u0000\u0000\u000002\u0003"+
		"\u0012\t\u000010\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000023\u0001"+
		"\u0000\u0000\u000035\u0005\u0003\u0000\u000046\u0003\u0004\u0002\u0000"+
		"54\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u000075\u0001\u0000\u0000"+
		"\u000078\u0001\u0000\u0000\u00008:\u0001\u0000\u0000\u00009 \u0001\u0000"+
		"\u0000\u000091\u0001\u0000\u0000\u0000:\u0003\u0001\u0000\u0000\u0000"+
		";J\u0005\u001a\u0000\u0000<J\u0003\u0016\u000b\u0000=J\u0003\u0014\n\u0000"+
		">@\u0005\u001d\u0000\u0000?>\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@B\u0001\u0000\u0000\u0000AC\u0003\u0006\u0003\u0000BA\u0001\u0000"+
		"\u0000\u0000CD\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000EG\u0001\u0000\u0000\u0000FH\u0005\u001d\u0000\u0000"+
		"GF\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001\u0000\u0000"+
		"\u0000I;\u0001\u0000\u0000\u0000I<\u0001\u0000\u0000\u0000I=\u0001\u0000"+
		"\u0000\u0000I?\u0001\u0000\u0000\u0000J\u0005\u0001\u0000\u0000\u0000"+
		"KR\u0005\n\u0000\u0000LN\u0005\u000b\u0000\u0000ML\u0001\u0000\u0000\u0000"+
		"NO\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000"+
		"\u0000PR\u0001\u0000\u0000\u0000QK\u0001\u0000\u0000\u0000QM\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SU\u0005"+
		"\u0013\u0000\u0000TS\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000Vk\u0003\b\u0004\u0000W^\u0005\n\u0000\u0000"+
		"XZ\u0005\u000b\u0000\u0000YX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000"+
		"\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000"+
		"\u0000\u0000]W\u0001\u0000\u0000\u0000]Y\u0001\u0000\u0000\u0000]^\u0001"+
		"\u0000\u0000\u0000^c\u0001\u0000\u0000\u0000_`\u0005\f\u0000\u0000`b\u0003"+
		"\n\u0005\u0000a_\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001"+
		"\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000"+
		"ec\u0001\u0000\u0000\u0000fh\u0005\u0013\u0000\u0000gf\u0001\u0000\u0000"+
		"\u0000gh\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ik\u0003\n\u0005"+
		"\u0000jQ\u0001\u0000\u0000\u0000j]\u0001\u0000\u0000\u0000k\u0007\u0001"+
		"\u0000\u0000\u0000ln\u0005\r\u0000\u0000mo\u0005\u0012\u0000\u0000nm\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000os\u0001\u0000\u0000\u0000"+
		"pr\u0005\u000e\u0000\u0000qp\u0001\u0000\u0000\u0000ru\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t\t\u0001\u0000"+
		"\u0000\u0000us\u0001\u0000\u0000\u0000vx\u0003\f\u0006\u0000wv\u0001\u0000"+
		"\u0000\u0000xy\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000\u0000yz\u0001"+
		"\u0000\u0000\u0000z~\u0001\u0000\u0000\u0000{}\u0005\u000e\u0000\u0000"+
		"|{\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001\u0000"+
		"\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u00aa\u0001\u0000\u0000"+
		"\u0000\u0080~\u0001\u0000\u0000\u0000\u0081\u0083\u0005\u0014\u0000\u0000"+
		"\u0082\u0084\u0003\f\u0006\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0001\u0000\u0000\u0000\u0086\u008a\u0001\u0000\u0000\u0000\u0087"+
		"\u0089\u0005\u000e\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089"+
		"\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0001\u0000\u0000\u0000\u008b\u00aa\u0001\u0000\u0000\u0000\u008c"+
		"\u008a\u0001\u0000\u0000\u0000\u008d\u008f\u0005\u0014\u0000\u0000\u008e"+
		"\u0090\u0003\u000e\u0007\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u0090"+
		"\u0091\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0001\u0000\u0000\u0000\u0092\u0096\u0001\u0000\u0000\u0000\u0093"+
		"\u0095\u0005\u000e\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095"+
		"\u0098\u0001\u0000\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096"+
		"\u0097\u0001\u0000\u0000\u0000\u0097\u00aa\u0001\u0000\u0000\u0000\u0098"+
		"\u0096\u0001\u0000\u0000\u0000\u0099\u009b\u0005\u0014\u0000\u0000\u009a"+
		"\u009c\u0005\u0012\u0000\u0000\u009b\u009a\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d"+
		"\u009f\u0005\u0011\u0000\u0000\u009e\u00a0\u0003\u000e\u0007\u0000\u009f"+
		"\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1"+
		"\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a3\u00a5\u0005\u000e\u0000\u0000\u00a4"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7"+
		"\u00aa\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9"+
		"w\u0001\u0000\u0000\u0000\u00a9\u0081\u0001\u0000\u0000\u0000\u00a9\u008d"+
		"\u0001\u0000\u0000\u0000\u00a9\u0099\u0001\u0000\u0000\u0000\u00aa\u000b"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ad\u0003\u0010\b\u0000\u00ac\u00ab\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00af\u0001"+
		"\u0000\u0000\u0000\u00ae\u00b0\u0005\u0010\u0000\u0000\u00af\u00ae\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b3\u0005\u0015\u0000\u0000\u00b2\u00b4\u0005"+
		"\u000f\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001"+
		"\u0000\u0000\u0000\u00b4\r\u0001\u0000\u0000\u0000\u00b5\u00b7\u0003\u0010"+
		"\b\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8\u00ba\u0005\u0010\u0000"+
		"\u0000\u00b9\u00b8\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000"+
		"\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bd\u0005\u0016\u0000"+
		"\u0000\u00bc\u00be\u0005\u000f\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u000f\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0007\u0000\u0000\u0000\u00c0\u0011\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c3\u0005\b\u0000\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000"+
		"\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c6\u0005\t\u0000\u0000\u00c5\u00c7\u0005\b\u0000\u0000\u00c6"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7"+
		"\u0013\u0001\u0000\u0000\u0000\u00c8\u00ca\u0005\u001b\u0000\u0000\u00c9"+
		"\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cf\u0005\u001c\u0000\u0000\u00ce"+
		"\u00d0\u0005\u001b\u0000\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d6\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d6\u0005\u0006\u0000\u0000\u00d4\u00d6\u0005\u0007\u0000\u0000\u00d5"+
		"\u00c9\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d6\u0015\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d9\u0005\u0017\u0000\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da"+
		"\u00db\u0001\u0000\u0000\u0000\u00db\u00e7\u0001\u0000\u0000\u0000\u00dc"+
		"\u00de\u0005\u0018\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de"+
		"\u00df\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e7\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e3\u0005\u0019\u0000\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e7\u0001\u0000\u0000\u0000\u00e6"+
		"\u00d8\u0001\u0000\u0000\u0000\u00e6\u00dd\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e7\u0017\u0001\u0000\u0000\u0000/\u001b"+
		" &,.179?DGIOQT[]cgjnsy~\u0085\u008a\u0091\u0096\u009b\u00a1\u00a6\u00a9"+
		"\u00ac\u00af\u00b3\u00b6\u00b9\u00bd\u00c2\u00c6\u00cb\u00d1\u00d5\u00da"+
		"\u00df\u00e4\u00e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}