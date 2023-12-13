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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, NEWV=12, VEND=13, GRACE=14, REST=15, DOT=16, TIE_START=17, 
		TIE_END=18, FLAG=19, BEAM=20, TUPL=21, STEM=22, LINE=23, SHARP=24, FLAT=25, 
		NATURAL=26, CLEF=27, DIGIT=28, SLASH=29, OTTV=30;
	public static final int
		RULE_bar = 0, RULE_event = 1, RULE_staff = 2, RULE_group = 3, RULE_rest = 4, 
		RULE_chord = 5, RULE_note_open = 6, RULE_note_solid = 7, RULE_accidental = 8, 
		RULE_meta = 9, RULE_time = 10, RULE_key = 11, RULE_ottavastart = 12, RULE_ottavaend = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"bar", "event", "staff", "group", "rest", "chord", "note_open", "note_solid", 
			"accidental", "meta", "time", "key", "ottavastart", "ottavaend"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'bos'", "'eos'", "'T'", "'&'", "'L'", "'o'", "'s'", "'x'", "'-'", 
			"'c'", "'/c'", "'<'", "'>'", "'g'", null, "'.'", "'('", "')'", null, 
			null, null, null, null, "'#'", "'b'", "'n'", null, null, "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"NEWV", "VEND", "GRACE", "REST", "DOT", "TIE_START", "TIE_END", "FLAG", 
			"BEAM", "TUPL", "STEM", "LINE", "SHARP", "FLAT", "NATURAL", "CLEF", "DIGIT", 
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
	public static class BarContext extends ParserRuleContext {
		public List<EventContext> event() {
			return getRuleContexts(EventContext.class);
		}
		public EventContext event(int i) {
			return getRuleContext(EventContext.class,i);
		}
		public BarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).enterBar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MusicScriptListener ) ((MusicScriptListener)listener).exitBar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MusicScriptVisitor ) return ((MusicScriptVisitor<? extends T>)visitor).visitBar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BarContext bar() throws RecognitionException {
		BarContext _localctx = new BarContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_bar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
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
			} while ( _la==T__2 || _la==T__4 );
			setState(34);
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
		public List<StaffContext> staff() {
			return getRuleContexts(StaffContext.class);
		}
		public StaffContext staff(int i) {
			return getRuleContext(StaffContext.class,i);
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
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				match(T__2);
				setState(37);
				staff();
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(38);
					match(T__3);
					setState(39);
					staff();
					}
				}

				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(T__4);
				setState(43);
				staff();
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
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(46);
						meta();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(49); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(52);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(51);
					ottavastart();
					}
					break;
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 124048192L) != 0)) {
					{
					{
					setState(54);
					group();
					}
					}
					setState(59);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OTTV) {
					{
					setState(60);
					ottavaend();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OTTV) {
					{
					setState(63);
					ottavastart();
					}
				}

				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(66);
					group();
					}
					}
					setState(69); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 124048192L) != 0) );
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OTTV) {
					{
					setState(71);
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
		public List<TerminalNode> TUPL() { return getTokens(MusicScriptParser.TUPL); }
		public TerminalNode TUPL(int i) {
			return getToken(MusicScriptParser.TUPL, i);
		}
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
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWV) {
					{
					setState(76);
					match(NEWV);
					}
				}

				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TUPL) {
					{
					{
					setState(79);
					match(TUPL);
					}
					}
					setState(84);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(85);
				rest();
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VEND) {
					{
					setState(86);
					match(VEND);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NEWV) {
					{
					setState(89);
					match(NEWV);
					}
				}

				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TUPL) {
					{
					{
					setState(92);
					match(TUPL);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98);
				chord();
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VEND) {
					{
					setState(99);
					match(VEND);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(102);
				match(GRACE);
				setState(103);
				chord();
				setState(104);
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
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
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
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
					_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
				if (_la==FLAG) {
					{
					setState(154);
					match(FLAG);
					}
				}

				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==BEAM) {
					{
					setState(157);
					match(BEAM);
					}
				}

				setState(161); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(160);
						note_solid();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(163); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(165);
					match(DOT);
					}
					}
					setState(170);
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
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 117441280L) != 0)) {
				{
				setState(173);
				accidental();
				}
			}

			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_END) {
				{
				setState(176);
				match(TIE_END);
				}
			}

			setState(179);
			match(T__5);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_START) {
				{
				setState(180);
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
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 117441280L) != 0)) {
				{
				setState(183);
				accidental();
				}
			}

			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_END) {
				{
				setState(186);
				match(TIE_END);
				}
			}

			setState(189);
			match(T__6);
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TIE_START) {
				{
				setState(190);
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
			setState(193);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 117441280L) != 0)) ) {
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
			setState(198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLEF:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				match(CLEF);
				}
				break;
			case SHARP:
			case FLAT:
			case NATURAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				key();
				}
				break;
			case T__9:
			case T__10:
			case DIGIT:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
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
					_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
				match(T__10);
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
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
					_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
					_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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
			setState(232);
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
			setState(234);
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
		"\u0004\u0001\u001e\u00ed\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0004\u0000\u001f"+
		"\b\u0000\u000b\u0000\f\u0000 \u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001)\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001-\b\u0001\u0001\u0002\u0004\u00020\b\u0002\u000b\u0002"+
		"\f\u00021\u0001\u0002\u0003\u00025\b\u0002\u0001\u0002\u0005\u00028\b"+
		"\u0002\n\u0002\f\u0002;\t\u0002\u0001\u0002\u0003\u0002>\b\u0002\u0001"+
		"\u0002\u0003\u0002A\b\u0002\u0001\u0002\u0004\u0002D\b\u0002\u000b\u0002"+
		"\f\u0002E\u0001\u0002\u0003\u0002I\b\u0002\u0003\u0002K\b\u0002\u0001"+
		"\u0003\u0003\u0003N\b\u0003\u0001\u0003\u0005\u0003Q\b\u0003\n\u0003\f"+
		"\u0003T\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003X\b\u0003\u0001\u0003"+
		"\u0003\u0003[\b\u0003\u0001\u0003\u0005\u0003^\b\u0003\n\u0003\f\u0003"+
		"a\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003e\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003k\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0003\u0004o\b\u0004\u0001\u0004\u0005\u0004r\b\u0004\n\u0004\f"+
		"\u0004u\t\u0004\u0001\u0005\u0004\u0005x\b\u0005\u000b\u0005\f\u0005y"+
		"\u0001\u0005\u0005\u0005}\b\u0005\n\u0005\f\u0005\u0080\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0004\u0005\u0084\b\u0005\u000b\u0005\f\u0005\u0085"+
		"\u0001\u0005\u0005\u0005\u0089\b\u0005\n\u0005\f\u0005\u008c\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0004\u0005\u0090\b\u0005\u000b\u0005\f\u0005\u0091"+
		"\u0001\u0005\u0005\u0005\u0095\b\u0005\n\u0005\f\u0005\u0098\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u009c\b\u0005\u0001\u0005\u0003\u0005\u009f"+
		"\b\u0005\u0001\u0005\u0004\u0005\u00a2\b\u0005\u000b\u0005\f\u0005\u00a3"+
		"\u0001\u0005\u0005\u0005\u00a7\b\u0005\n\u0005\f\u0005\u00aa\t\u0005\u0003"+
		"\u0005\u00ac\b\u0005\u0001\u0006\u0003\u0006\u00af\b\u0006\u0001\u0006"+
		"\u0003\u0006\u00b2\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00b6\b"+
		"\u0006\u0001\u0007\u0003\u0007\u00b9\b\u0007\u0001\u0007\u0003\u0007\u00bc"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00c0\b\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0003\t\u00c7\b\t\u0001\n\u0004\n\u00ca\b\n"+
		"\u000b\n\f\n\u00cb\u0001\n\u0001\n\u0004\n\u00d0\b\n\u000b\n\f\n\u00d1"+
		"\u0001\n\u0001\n\u0003\n\u00d6\b\n\u0001\u000b\u0004\u000b\u00d9\b\u000b"+
		"\u000b\u000b\f\u000b\u00da\u0001\u000b\u0004\u000b\u00de\b\u000b\u000b"+
		"\u000b\f\u000b\u00df\u0001\u000b\u0004\u000b\u00e3\b\u000b\u000b\u000b"+
		"\f\u000b\u00e4\u0003\u000b\u00e7\b\u000b\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u0000\u0001\u0002\u0000\b\t\u0018\u001a"+
		"\u0111\u0000\u001c\u0001\u0000\u0000\u0000\u0002,\u0001\u0000\u0000\u0000"+
		"\u0004J\u0001\u0000\u0000\u0000\u0006j\u0001\u0000\u0000\u0000\bl\u0001"+
		"\u0000\u0000\u0000\n\u00ab\u0001\u0000\u0000\u0000\f\u00ae\u0001\u0000"+
		"\u0000\u0000\u000e\u00b8\u0001\u0000\u0000\u0000\u0010\u00c1\u0001\u0000"+
		"\u0000\u0000\u0012\u00c6\u0001\u0000\u0000\u0000\u0014\u00d5\u0001\u0000"+
		"\u0000\u0000\u0016\u00e6\u0001\u0000\u0000\u0000\u0018\u00e8\u0001\u0000"+
		"\u0000\u0000\u001a\u00ea\u0001\u0000\u0000\u0000\u001c\u001e\u0005\u0001"+
		"\u0000\u0000\u001d\u001f\u0003\u0002\u0001\u0000\u001e\u001d\u0001\u0000"+
		"\u0000\u0000\u001f \u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000"+
		" !\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0005\u0002\u0000"+
		"\u0000#\u0001\u0001\u0000\u0000\u0000$%\u0005\u0003\u0000\u0000%(\u0003"+
		"\u0004\u0002\u0000&\'\u0005\u0004\u0000\u0000\')\u0003\u0004\u0002\u0000"+
		"(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)-\u0001\u0000\u0000"+
		"\u0000*+\u0005\u0005\u0000\u0000+-\u0003\u0004\u0002\u0000,$\u0001\u0000"+
		"\u0000\u0000,*\u0001\u0000\u0000\u0000-\u0003\u0001\u0000\u0000\u0000"+
		".0\u0003\u0012\t\u0000/.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u0000"+
		"1/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000024\u0001\u0000\u0000"+
		"\u000035\u0003\u0018\f\u000043\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000059\u0001\u0000\u0000\u000068\u0003\u0006\u0003\u000076\u0001\u0000"+
		"\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:=\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		"<>\u0003\u001a\r\u0000=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000"+
		">K\u0001\u0000\u0000\u0000?A\u0003\u0018\f\u0000@?\u0001\u0000\u0000\u0000"+
		"@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000\u0000BD\u0003\u0006\u0003"+
		"\u0000CB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000"+
		"\u0000\u0000EF\u0001\u0000\u0000\u0000FH\u0001\u0000\u0000\u0000GI\u0003"+
		"\u001a\r\u0000HG\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IK\u0001"+
		"\u0000\u0000\u0000J/\u0001\u0000\u0000\u0000J@\u0001\u0000\u0000\u0000"+
		"K\u0005\u0001\u0000\u0000\u0000LN\u0005\f\u0000\u0000ML\u0001\u0000\u0000"+
		"\u0000MN\u0001\u0000\u0000\u0000NR\u0001\u0000\u0000\u0000OQ\u0005\u0015"+
		"\u0000\u0000PO\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001"+
		"\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000\u0000"+
		"TR\u0001\u0000\u0000\u0000UW\u0003\b\u0004\u0000VX\u0005\r\u0000\u0000"+
		"WV\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000Xk\u0001\u0000\u0000"+
		"\u0000Y[\u0005\f\u0000\u0000ZY\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000"+
		"\u0000[_\u0001\u0000\u0000\u0000\\^\u0005\u0015\u0000\u0000]\\\u0001\u0000"+
		"\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001"+
		"\u0000\u0000\u0000`b\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000"+
		"bd\u0003\n\u0005\u0000ce\u0005\r\u0000\u0000dc\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000ek\u0001\u0000\u0000\u0000fg\u0005\u000e\u0000"+
		"\u0000gh\u0003\n\u0005\u0000hi\u0003\u0006\u0003\u0000ik\u0001\u0000\u0000"+
		"\u0000jM\u0001\u0000\u0000\u0000jZ\u0001\u0000\u0000\u0000jf\u0001\u0000"+
		"\u0000\u0000k\u0007\u0001\u0000\u0000\u0000ln\u0005\u000f\u0000\u0000"+
		"mo\u0005\u0014\u0000\u0000nm\u0001\u0000\u0000\u0000no\u0001\u0000\u0000"+
		"\u0000os\u0001\u0000\u0000\u0000pr\u0005\u0010\u0000\u0000qp\u0001\u0000"+
		"\u0000\u0000ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001"+
		"\u0000\u0000\u0000t\t\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000"+
		"vx\u0003\f\u0006\u0000wv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000"+
		"yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z~\u0001\u0000\u0000"+
		"\u0000{}\u0005\u0010\u0000\u0000|{\u0001\u0000\u0000\u0000}\u0080\u0001"+
		"\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000"+
		"\u0000\u007f\u00ac\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000\u0000"+
		"\u0081\u0083\u0005\u0016\u0000\u0000\u0082\u0084\u0003\f\u0006\u0000\u0083"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086"+
		"\u008a\u0001\u0000\u0000\u0000\u0087\u0089\u0005\u0010\u0000\u0000\u0088"+
		"\u0087\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a"+
		"\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b"+
		"\u00ac\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d"+
		"\u008f\u0005\u0016\u0000\u0000\u008e\u0090\u0003\u000e\u0007\u0000\u008f"+
		"\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092"+
		"\u0096\u0001\u0000\u0000\u0000\u0093\u0095\u0005\u0010\u0000\u0000\u0094"+
		"\u0093\u0001\u0000\u0000\u0000\u0095\u0098\u0001\u0000\u0000\u0000\u0096"+
		"\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097"+
		"\u00ac\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0099"+
		"\u009b\u0005\u0016\u0000\u0000\u009a\u009c\u0005\u0013\u0000\u0000\u009b"+
		"\u009a\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c"+
		"\u009e\u0001\u0000\u0000\u0000\u009d\u009f\u0005\u0014\u0000\u0000\u009e"+
		"\u009d\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a0\u00a2\u0003\u000e\u0007\u0000\u00a1"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a5\u00a7\u0005\u0010\u0000\u0000\u00a6"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ac\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab"+
		"w\u0001\u0000\u0000\u0000\u00ab\u0081\u0001\u0000\u0000\u0000\u00ab\u008d"+
		"\u0001\u0000\u0000\u0000\u00ab\u0099\u0001\u0000\u0000\u0000\u00ac\u000b"+
		"\u0001\u0000\u0000\u0000\u00ad\u00af\u0003\u0010\b\u0000\u00ae\u00ad\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b2\u0005\u0012\u0000\u0000\u00b1\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b5\u0005\u0006\u0000\u0000\u00b4\u00b6\u0005"+
		"\u0011\u0000\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b6\r\u0001\u0000\u0000\u0000\u00b7\u00b9\u0003\u0010"+
		"\b\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000"+
		"\u0000\u00b9\u00bb\u0001\u0000\u0000\u0000\u00ba\u00bc\u0005\u0012\u0000"+
		"\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00bf\u0005\u0007\u0000"+
		"\u0000\u00be\u00c0\u0005\u0011\u0000\u0000\u00bf\u00be\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u000f\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c2\u0007\u0000\u0000\u0000\u00c2\u0011\u0001\u0000\u0000"+
		"\u0000\u00c3\u00c7\u0005\u001b\u0000\u0000\u00c4\u00c7\u0003\u0016\u000b"+
		"\u0000\u00c5\u00c7\u0003\u0014\n\u0000\u00c6\u00c3\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c7\u0013\u0001\u0000\u0000\u0000\u00c8\u00ca\u0005\u001c\u0000\u0000"+
		"\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000"+
		"\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000"+
		"\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cf\u0005\u001d\u0000\u0000"+
		"\u00ce\u00d0\u0005\u001c\u0000\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000"+
		"\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d3\u00d6\u0005\n\u0000\u0000\u00d4\u00d6\u0005\u000b\u0000\u0000\u00d5"+
		"\u00c9\u0001\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d6\u0015\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d9\u0005\u0018\u0000\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da"+
		"\u00db\u0001\u0000\u0000\u0000\u00db\u00e7\u0001\u0000\u0000\u0000\u00dc"+
		"\u00de\u0005\u0019\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de"+
		"\u00df\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e7\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e3\u0005\u001a\u0000\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e5\u00e7\u0001\u0000\u0000\u0000\u00e6"+
		"\u00d8\u0001\u0000\u0000\u0000\u00e6\u00dd\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e7\u0017\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e9\u0005\u001e\u0000\u0000\u00e9\u0019\u0001\u0000\u0000\u0000\u00ea"+
		"\u00eb\u0005\u001e\u0000\u0000\u00eb\u001b\u0001\u0000\u0000\u0000- ("+
		",149=@EHJMRWZ_djnsy~\u0085\u008a\u0091\u0096\u009b\u009e\u00a3\u00a8\u00ab"+
		"\u00ae\u00b1\u00b5\u00b8\u00bb\u00bf\u00c6\u00cb\u00d1\u00d5\u00da\u00df"+
		"\u00e4\u00e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}