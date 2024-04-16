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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, BARL=11, REPEAT=12, NEWV=13, SKPV=14, GRACE=15, REST=16, DOT=17, 
		TIE_START=18, TIE_END=19, FLAG=20, BEAM=21, STEM=22, NOTE_OPEN=23, NOTE_SOLID=24, 
		SHARP=25, FLAT=26, NATURAL=27, CLEF=28, DIGIT=29, SLASH=30, OTTV=31;
	public static final int
		RULE_track = 0, RULE_measure = 1, RULE_event = 2, RULE_stafflet = 3, RULE_voicelet = 4, 
		RULE_element = 5, RULE_tuplet = 6, RULE_rest = 7, RULE_chord = 8, RULE_note_open = 9, 
		RULE_note_solid = 10, RULE_accidental = 11, RULE_barline = 12, RULE_time = 13, 
		RULE_key = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"track", "measure", "event", "stafflet", "voicelet", "element", "tuplet", 
			"rest", "chord", "note_open", "note_solid", "accidental", "barline", 
			"time", "key"
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
	public static class TrackContext extends ParserRuleContext {
		public BarlineContext barline() {
			return getRuleContext(BarlineContext.class,0);
		}
		public List<MeasureContext> measure() {
			return getRuleContexts(MeasureContext.class);
		}
		public MeasureContext measure(int i) {
			return getRuleContext(MeasureContext.class,i);
		}
		public TrackContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_track; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterTrack(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitTrack(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitTrack(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TrackContext track() throws RecognitionException {
		TrackContext _localctx = new TrackContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_track);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(31); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(30);
					measure();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(33); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(35);
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
	public static class MeasureContext extends ParserRuleContext {
		public BarlineContext barline() {
			return getRuleContext(BarlineContext.class,0);
		}
		public List<EventContext> event() {
			return getRuleContexts(EventContext.class);
		}
		public EventContext event(int i) {
			return getRuleContext(EventContext.class,i);
		}
		public MeasureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_measure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterMeasure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitMeasure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitMeasure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MeasureContext measure() throws RecognitionException {
		MeasureContext _localctx = new MeasureContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_measure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			barline();
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				event();
				}
				}
				setState(41); 
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
		Fraction onset;
		public List<StaffletContext> stafflet() {
			return getRuleContexts(StaffletContext.class);
		}
		public StaffletContext stafflet(int i) {
			return getRuleContext(StaffletContext.class,i);
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
		enterRule(_localctx, 4, RULE_event);
		int _la;
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(T__0);
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(44);
					stafflet();
					}
					}
					setState(47); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3191989840L) != 0) );
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__1) {
					{
					setState(49);
					match(T__1);
					setState(51); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(50);
						stafflet();
						}
						}
						setState(53); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3191989840L) != 0) );
					}
				}

				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(T__2);
				setState(59); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(58);
					stafflet();
					}
					}
					setState(61); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3191989840L) != 0) );
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
	public static class StaffletContext extends ParserRuleContext {
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
		public List<VoiceletContext> voicelet() {
			return getRuleContexts(VoiceletContext.class);
		}
		public VoiceletContext voicelet(int i) {
			return getRuleContext(VoiceletContext.class,i);
		}
		public StaffletContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stafflet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterStafflet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitStafflet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitStafflet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StaffletContext stafflet() throws RecognitionException {
		StaffletContext _localctx = new StaffletContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_stafflet);
		int _la;
		try {
			int _alt;
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLEF:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(CLEF);
				}
				break;
			case SHARP:
			case FLAT:
			case NATURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				key();
				}
				break;
			case T__8:
			case T__9:
			case DIGIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				time();
				}
				break;
			case T__3:
			case T__5:
			case NEWV:
			case SKPV:
			case GRACE:
			case REST:
			case STEM:
			case OTTV:
				enterOuterAlt(_localctx, 4);
				{
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OTTV) {
					{
					setState(68);
					match(OTTV);
					}
				}

				setState(72); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(71);
						voicelet();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(74); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(77);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(76);
					match(OTTV);
					}
					break;
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
	public static class VoiceletContext extends ParserRuleContext {
		int voiceId;
		public ElementContext element() {
			return getRuleContext(ElementContext.class,0);
		}
		public TerminalNode NEWV() { return getToken(MusicScriptParser.NEWV, 0); }
		public List<TerminalNode> SKPV() { return getTokens(MusicScriptParser.SKPV); }
		public TerminalNode SKPV(int i) {
			return getToken(MusicScriptParser.SKPV, i);
		}
		public VoiceletContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voicelet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterVoicelet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitVoicelet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitVoicelet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VoiceletContext voicelet() throws RecognitionException {
		VoiceletContext _localctx = new VoiceletContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_voicelet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWV:
				{
				setState(81);
				match(NEWV);
				}
				break;
			case SKPV:
				{
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(82);
					match(SKPV);
					}
					}
					setState(85); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==SKPV );
				}
				break;
			case T__3:
			case T__5:
			case GRACE:
			case REST:
			case STEM:
				break;
			default:
				break;
			}
			setState(89);
			element();
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
	public static class ElementContext extends ParserRuleContext {
		int dots;
		NoteType noteType;

		public RestContext rest() {
			return getRuleContext(RestContext.class,0);
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
		public TupletContext tuplet() {
			return getRuleContext(TupletContext.class,0);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_element);
		int _la;
		try {
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REST:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				rest();
				}
				break;
			case T__5:
			case GRACE:
			case STEM:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==GRACE) {
					{
					{
					setState(92);
					match(GRACE);
					setState(93);
					chord();
					}
					}
					setState(98);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(99);
				chord();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				tuplet();
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
	public static class TupletContext extends ParserRuleContext {
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public TupletContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuplet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterTuplet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitTuplet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitTuplet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupletContext tuplet() throws RecognitionException {
		TupletContext _localctx = new TupletContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tuplet);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__3);
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(104);
				element();
				}
				}
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4292688L) != 0) );
			setState(109);
			match(T__4);
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
		enterRule(_localctx, 14, RULE_rest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(REST);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BEAM) {
				{
				setState(112);
				match(BEAM);
				}
			}

			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(115);
				match(DOT);
				}
				}
				setState(120);
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
		enterRule(_localctx, 16, RULE_chord);
		int _la;
		try {
			int _alt;
			setState(173);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(T__5);
				setState(123); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(122);
						note_open();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(125); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				match(STEM);
				setState(135); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(134);
						note_open();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(137); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(139);
					match(DOT);
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				match(STEM);
				setState(147); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(146);
						note_solid();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(149); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(151);
					match(DOT);
					}
					}
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
				match(STEM);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEAM) {
					{
					setState(158);
					match(BEAM);
					}
				}

				setState(161);
				match(FLAG);
				setState(163); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(162);
						note_solid();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(165); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(167);
					match(DOT);
					}
					}
					setState(172);
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
		enterRule(_localctx, 18, RULE_note_open);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 234881408L) != 0)) {
				{
				setState(175);
				accidental();
				}
			}

			setState(179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_END) {
				{
				setState(178);
				match(TIE_END);
				}
			}

			setState(181);
			match(NOTE_OPEN);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_START) {
				{
				setState(182);
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
		enterRule(_localctx, 20, RULE_note_solid);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 234881408L) != 0)) {
				{
				setState(185);
				accidental();
				}
			}

			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_END) {
				{
				setState(188);
				match(TIE_END);
				}
			}

			setState(191);
			match(NOTE_SOLID);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_START) {
				{
				setState(192);
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
		enterRule(_localctx, 22, RULE_accidental);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 234881408L) != 0)) ) {
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
		enterRule(_localctx, 24, RULE_barline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REPEAT) {
				{
				setState(197);
				match(REPEAT);
				}
			}

			setState(200);
			match(BARL);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==REPEAT) {
				{
				setState(201);
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
		enterRule(_localctx, 26, RULE_time);
		int _la;
		try {
			int _alt;
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(205); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(204);
					match(DIGIT);
					}
					}
					setState(207); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				setState(209);
				match(SLASH);
				setState(211); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(210);
						match(DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(213); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(T__8);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				match(T__9);
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
		enterRule(_localctx, 28, RULE_key);
		try {
			int _alt;
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SHARP:
				enterOuterAlt(_localctx, 1);
				{
				setState(220); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(219);
						match(SHARP);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(222); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case FLAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(225); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(224);
						match(FLAT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(227); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case NATURAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(230); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(229);
						match(NATURAL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(232); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
		"\u0004\u0001\u001f\u00ed\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0004"+
		"\u0000 \b\u0000\u000b\u0000\f\u0000!\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0004\u0001(\b\u0001\u000b\u0001\f\u0001)\u0001\u0002\u0001"+
		"\u0002\u0004\u0002.\b\u0002\u000b\u0002\f\u0002/\u0001\u0002\u0001\u0002"+
		"\u0004\u00024\b\u0002\u000b\u0002\f\u00025\u0003\u00028\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0004\u0002<\b\u0002\u000b\u0002\f\u0002=\u0003\u0002"+
		"@\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"F\b\u0003\u0001\u0003\u0004\u0003I\b\u0003\u000b\u0003\f\u0003J\u0001"+
		"\u0003\u0003\u0003N\b\u0003\u0003\u0003P\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0004\u0004T\b\u0004\u000b\u0004\f\u0004U\u0003\u0004X\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005_\b"+
		"\u0005\n\u0005\f\u0005b\t\u0005\u0001\u0005\u0001\u0005\u0003\u0005f\b"+
		"\u0005\u0001\u0006\u0001\u0006\u0004\u0006j\b\u0006\u000b\u0006\f\u0006"+
		"k\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007r\b\u0007"+
		"\u0001\u0007\u0005\u0007u\b\u0007\n\u0007\f\u0007x\t\u0007\u0001\b\u0001"+
		"\b\u0004\b|\b\b\u000b\b\f\b}\u0001\b\u0005\b\u0081\b\b\n\b\f\b\u0084\t"+
		"\b\u0001\b\u0001\b\u0004\b\u0088\b\b\u000b\b\f\b\u0089\u0001\b\u0005\b"+
		"\u008d\b\b\n\b\f\b\u0090\t\b\u0001\b\u0001\b\u0004\b\u0094\b\b\u000b\b"+
		"\f\b\u0095\u0001\b\u0005\b\u0099\b\b\n\b\f\b\u009c\t\b\u0001\b\u0001\b"+
		"\u0003\b\u00a0\b\b\u0001\b\u0001\b\u0004\b\u00a4\b\b\u000b\b\f\b\u00a5"+
		"\u0001\b\u0005\b\u00a9\b\b\n\b\f\b\u00ac\t\b\u0003\b\u00ae\b\b\u0001\t"+
		"\u0003\t\u00b1\b\t\u0001\t\u0003\t\u00b4\b\t\u0001\t\u0001\t\u0003\t\u00b8"+
		"\b\t\u0001\n\u0003\n\u00bb\b\n\u0001\n\u0003\n\u00be\b\n\u0001\n\u0001"+
		"\n\u0003\n\u00c2\b\n\u0001\u000b\u0001\u000b\u0001\f\u0003\f\u00c7\b\f"+
		"\u0001\f\u0001\f\u0003\f\u00cb\b\f\u0001\r\u0004\r\u00ce\b\r\u000b\r\f"+
		"\r\u00cf\u0001\r\u0001\r\u0004\r\u00d4\b\r\u000b\r\f\r\u00d5\u0001\r\u0001"+
		"\r\u0003\r\u00da\b\r\u0001\u000e\u0004\u000e\u00dd\b\u000e\u000b\u000e"+
		"\f\u000e\u00de\u0001\u000e\u0004\u000e\u00e2\b\u000e\u000b\u000e\f\u000e"+
		"\u00e3\u0001\u000e\u0004\u000e\u00e7\b\u000e\u000b\u000e\f\u000e\u00e8"+
		"\u0003\u000e\u00eb\b\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000\u0001"+
		"\u0002\u0000\u0007\b\u0019\u001b\u0110\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0002%\u0001\u0000\u0000\u0000\u0004?\u0001\u0000\u0000\u0000\u0006O"+
		"\u0001\u0000\u0000\u0000\bW\u0001\u0000\u0000\u0000\ne\u0001\u0000\u0000"+
		"\u0000\fg\u0001\u0000\u0000\u0000\u000eo\u0001\u0000\u0000\u0000\u0010"+
		"\u00ad\u0001\u0000\u0000\u0000\u0012\u00b0\u0001\u0000\u0000\u0000\u0014"+
		"\u00ba\u0001\u0000\u0000\u0000\u0016\u00c3\u0001\u0000\u0000\u0000\u0018"+
		"\u00c6\u0001\u0000\u0000\u0000\u001a\u00d9\u0001\u0000\u0000\u0000\u001c"+
		"\u00ea\u0001\u0000\u0000\u0000\u001e \u0003\u0002\u0001\u0000\u001f\u001e"+
		"\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u001f\u0001\u0000"+
		"\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0003"+
		"\u0018\f\u0000$\u0001\u0001\u0000\u0000\u0000%\'\u0003\u0018\f\u0000&"+
		"(\u0003\u0004\u0002\u0000\'&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000"+
		"\u0000)\'\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*\u0003\u0001"+
		"\u0000\u0000\u0000+-\u0005\u0001\u0000\u0000,.\u0003\u0006\u0003\u0000"+
		"-,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000"+
		"\u0000/0\u0001\u0000\u0000\u000007\u0001\u0000\u0000\u000013\u0005\u0002"+
		"\u0000\u000024\u0003\u0006\u0003\u000032\u0001\u0000\u0000\u000045\u0001"+
		"\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u0000"+
		"68\u0001\u0000\u0000\u000071\u0001\u0000\u0000\u000078\u0001\u0000\u0000"+
		"\u00008@\u0001\u0000\u0000\u00009;\u0005\u0003\u0000\u0000:<\u0003\u0006"+
		"\u0003\u0000;:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=;\u0001"+
		"\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001\u0000\u0000\u0000"+
		"?+\u0001\u0000\u0000\u0000?9\u0001\u0000\u0000\u0000@\u0005\u0001\u0000"+
		"\u0000\u0000AP\u0005\u001c\u0000\u0000BP\u0003\u001c\u000e\u0000CP\u0003"+
		"\u001a\r\u0000DF\u0005\u001f\u0000\u0000ED\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000GI\u0003\b\u0004\u0000HG\u0001"+
		"\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000"+
		"JK\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000LN\u0005\u001f\u0000"+
		"\u0000ML\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NP\u0001\u0000"+
		"\u0000\u0000OA\u0001\u0000\u0000\u0000OB\u0001\u0000\u0000\u0000OC\u0001"+
		"\u0000\u0000\u0000OE\u0001\u0000\u0000\u0000P\u0007\u0001\u0000\u0000"+
		"\u0000QX\u0005\r\u0000\u0000RT\u0005\u000e\u0000\u0000SR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000"+
		"\u0000\u0000VX\u0001\u0000\u0000\u0000WQ\u0001\u0000\u0000\u0000WS\u0001"+
		"\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000"+
		"YZ\u0003\n\u0005\u0000Z\t\u0001\u0000\u0000\u0000[f\u0003\u000e\u0007"+
		"\u0000\\]\u0005\u000f\u0000\u0000]_\u0003\u0010\b\u0000^\\\u0001\u0000"+
		"\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001"+
		"\u0000\u0000\u0000ac\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000"+
		"cf\u0003\u0010\b\u0000df\u0003\f\u0006\u0000e[\u0001\u0000\u0000\u0000"+
		"e`\u0001\u0000\u0000\u0000ed\u0001\u0000\u0000\u0000f\u000b\u0001\u0000"+
		"\u0000\u0000gi\u0005\u0004\u0000\u0000hj\u0003\n\u0005\u0000ih\u0001\u0000"+
		"\u0000\u0000jk\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0005\u0005\u0000\u0000"+
		"n\r\u0001\u0000\u0000\u0000oq\u0005\u0010\u0000\u0000pr\u0005\u0015\u0000"+
		"\u0000qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rv\u0001\u0000"+
		"\u0000\u0000su\u0005\u0011\u0000\u0000ts\u0001\u0000\u0000\u0000ux\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000"+
		"w\u000f\u0001\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000y{\u0005\u0006"+
		"\u0000\u0000z|\u0003\u0012\t\u0000{z\u0001\u0000\u0000\u0000|}\u0001\u0000"+
		"\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0082"+
		"\u0001\u0000\u0000\u0000\u007f\u0081\u0005\u0011\u0000\u0000\u0080\u007f"+
		"\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u00ae"+
		"\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0087"+
		"\u0005\u0016\u0000\u0000\u0086\u0088\u0003\u0012\t\u0000\u0087\u0086\u0001"+
		"\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u0087\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008e\u0001"+
		"\u0000\u0000\u0000\u008b\u008d\u0005\u0011\u0000\u0000\u008c\u008b\u0001"+
		"\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008c\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u00ae\u0001"+
		"\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0093\u0005"+
		"\u0016\u0000\u0000\u0092\u0094\u0003\u0014\n\u0000\u0093\u0092\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u009a\u0001\u0000"+
		"\u0000\u0000\u0097\u0099\u0005\u0011\u0000\u0000\u0098\u0097\u0001\u0000"+
		"\u0000\u0000\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000"+
		"\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u00ae\u0001\u0000"+
		"\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u009f\u0005\u0016"+
		"\u0000\u0000\u009e\u00a0\u0005\u0015\u0000\u0000\u009f\u009e\u0001\u0000"+
		"\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a1\u00a3\u0005\u0014\u0000\u0000\u00a2\u00a4\u0003\u0014"+
		"\n\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000"+
		"\u0000\u00a6\u00aa\u0001\u0000\u0000\u0000\u00a7\u00a9\u0005\u0011\u0000"+
		"\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9\u00ac\u0001\u0000\u0000"+
		"\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000"+
		"\u0000\u00ab\u00ae\u0001\u0000\u0000\u0000\u00ac\u00aa\u0001\u0000\u0000"+
		"\u0000\u00ady\u0001\u0000\u0000\u0000\u00ad\u0085\u0001\u0000\u0000\u0000"+
		"\u00ad\u0091\u0001\u0000\u0000\u0000\u00ad\u009d\u0001\u0000\u0000\u0000"+
		"\u00ae\u0011\u0001\u0000\u0000\u0000\u00af\u00b1\u0003\u0016\u000b\u0000"+
		"\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u00b4\u0005\u0013\u0000\u0000"+
		"\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b7\u0005\u0017\u0000\u0000"+
		"\u00b6\u00b8\u0005\u0012\u0000\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u0013\u0001\u0000\u0000\u0000"+
		"\u00b9\u00bb\u0003\u0016\u000b\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000"+
		"\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bc\u00be\u0005\u0013\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000"+
		"\u00bd\u00be\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c1\u0005\u0018\u0000\u0000\u00c0\u00c2\u0005\u0012\u0000\u0000"+
		"\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000"+
		"\u00c2\u0015\u0001\u0000\u0000\u0000\u00c3\u00c4\u0007\u0000\u0000\u0000"+
		"\u00c4\u0017\u0001\u0000\u0000\u0000\u00c5\u00c7\u0005\f\u0000\u0000\u00c6"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c8\u0001\u0000\u0000\u0000\u00c8\u00ca\u0005\u000b\u0000\u0000\u00c9"+
		"\u00cb\u0005\f\u0000\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cb\u0019\u0001\u0000\u0000\u0000\u00cc\u00ce"+
		"\u0005\u001d\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce\u00cf"+
		"\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d3"+
		"\u0005\u001e\u0000\u0000\u00d2\u00d4\u0005\u001d\u0000\u0000\u00d3\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d3"+
		"\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00da"+
		"\u0001\u0000\u0000\u0000\u00d7\u00da\u0005\t\u0000\u0000\u00d8\u00da\u0005"+
		"\n\u0000\u0000\u00d9\u00cd\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00da\u001b\u0001\u0000"+
		"\u0000\u0000\u00db\u00dd\u0005\u0019\u0000\u0000\u00dc\u00db\u0001\u0000"+
		"\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000"+
		"\u0000\u0000\u00de\u00df\u0001\u0000\u0000\u0000\u00df\u00eb\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e2\u0005\u001a\u0000\u0000\u00e1\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u00eb\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e7\u0005\u001b\u0000\u0000\u00e6\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00eb\u0001\u0000"+
		"\u0000\u0000\u00ea\u00dc\u0001\u0000\u0000\u0000\u00ea\u00e1\u0001\u0000"+
		"\u0000\u0000\u00ea\u00e6\u0001\u0000\u0000\u0000\u00eb\u001d\u0001\u0000"+
		"\u0000\u0000+!)/57=?EJMOUW`ekqv}\u0082\u0089\u008e\u0095\u009a\u009f\u00a5"+
		"\u00aa\u00ad\u00b0\u00b3\u00b7\u00ba\u00bd\u00c1\u00c6\u00ca\u00cf\u00d5"+
		"\u00d9\u00de\u00e3\u00e8\u00ea";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}