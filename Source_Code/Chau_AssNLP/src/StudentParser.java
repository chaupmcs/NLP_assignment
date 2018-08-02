// Generated from Student.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class StudentParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, NAME=2, ROOM=3, STUDENT_ID=4, V=5, DATE=6, BEGINNING_CLASS=7, NUMBER_CLASS=8, 
		NLP=9, PPL=10, SUBJECT=11, WHQUERY=12, WHQUERY_BEGIN_CLASS=13, QUESTION_MARK=14, 
		IN_LOC=15, COMMA=16, GIVE_QUES=17, STUDENT=18, BEGIN_CLASS=19, HAVE=20, 
		CONDITION_NOT_FOUND=21, OTHER_WORDS=22;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "NAME", "ROOM", "STUDENT_ID", "'học '", "DATE", "BEGINNING_CLASS", 
		"NUMBER_CLASS", "'xử lý ngôn ngữ tự nhiên '", "'ngôn ngữ lập trình '", 
		"SUBJECT", "WHQUERY", "WHQUERY_BEGIN_CLASS", "'?'", "'ở '", "', '", "'hãy cho biết'", 
		"'sinh viên'", "'tiết bắt đầu'", "'có '", "CONDITION_NOT_FOUND", "OTHER_WORDS"
	};
	public static final int
		RULE_r = 0, RULE_whQUERY = 1;
	public static final String[] ruleNames = {
		"r", "whQUERY"
	};

	@Override
	public String getGrammarFileName() { return "Student.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public StudentParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RContext extends ParserRuleContext {
		public WhQUERYContext whQUERY() {
			return getRuleContext(WhQUERYContext.class,0);
		}
		public RContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_r; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StudentListener ) ((StudentListener)listener).enterR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StudentListener ) ((StudentListener)listener).exitR(this);
		}
	}

	public final RContext r() throws RecognitionException {
		RContext _localctx = new RContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_r);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4); whQUERY();
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

	public static class WhQUERYContext extends ParserRuleContext {
		public TerminalNode WHQUERY() { return getToken(StudentParser.WHQUERY, 0); }
		public WhQUERYContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whQUERY; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof StudentListener ) ((StudentListener)listener).enterWhQUERY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof StudentListener ) ((StudentListener)listener).exitWhQUERY(this);
		}
	}

	public final WhQUERYContext whQUERY() throws RecognitionException {
		WhQUERYContext _localctx = new WhQUERYContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_whQUERY);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6); match(WHQUERY);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\30\13\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\3\3\3\3\3\2\2\4\2\4\2\2\b\2\6\3\2\2\2\4\b\3\2\2\2\6\7\5"+
		"\4\3\2\7\3\3\2\2\2\b\t\7\16\2\2\t\5\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}