// Generated from MiniLang.g4 by ANTLR 4.4

	package inf5153.miniLang.parser ;
	
	import inf5153.miniLang.ast.* ; 

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__12=1, T__11=2, T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, 
		T__3=10, T__2=11, T__1=12, T__0=13, IF=14, THEN=15, ELSE=16, WHILE=17, 
		PRINT=18, READ=19, NUMBER=20, IDENTIFIER=21, WS=22, STRINGLITERAL=23;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'!='", "';'", "'{'", "'=='", "'='", "'}'", "'('", 
		"')'", "'*'", "'+'", "','", "'-'", "'if'", "'then'", "'else'", "'while'", 
		"'print'", "'read'", "NUMBER", "IDENTIFIER", "WS", "STRINGLITERAL"
	};
	public static final int
		RULE_compileUnit = 0, RULE_block = 1, RULE_statement = 2, RULE_expression = 3, 
		RULE_primary = 4;
	public static final String[] ruleNames = {
		"compileUnit", "block", "statement", "expression", "primary"
	};

	@Override
	public String getGrammarFileName() { return "MiniLang.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class CompileUnitContext extends ParserRuleContext {
		public CompileUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileUnit; }
	 
		public CompileUnitContext() { }
		public void copyFrom(CompileUnitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CompUnitBlockContext extends CompileUnitContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CompUnitBlockContext(CompileUnitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterCompUnitBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitCompUnitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitCompUnitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompileUnitContext compileUnit() throws RecognitionException {
		CompileUnitContext _localctx = new CompileUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compileUnit);
		try {
			_localctx = new CompUnitBlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(10); block();
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

	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	 
		public BlockContext() { }
		public void copyFrom(BlockContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatementsContext extends BlockContext {
		public StatementContext oneStat;
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementsContext(BlockContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			_localctx = new StatementsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(12); match(T__9);
			setState(16);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << WHILE) | (1L << PRINT) | (1L << READ) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(13); ((StatementsContext)_localctx).oneStat = statement();
				}
				}
				setState(18);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(19); match(T__6);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatemntAssignContext extends StatementContext {
		public ExpressionContext expr;
		public TerminalNode IDENTIFIER() { return getToken(MiniLangParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatemntAssignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterStatemntAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitStatemntAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitStatemntAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatemntReadContext extends StatementContext {
		public TerminalNode STRINGLITERAL() { return getToken(MiniLangParser.STRINGLITERAL, 0); }
		public TerminalNode READ() { return getToken(MiniLangParser.READ, 0); }
		public TerminalNode IDENTIFIER() { return getToken(MiniLangParser.IDENTIFIER, 0); }
		public StatemntReadContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterStatemntRead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitStatemntRead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitStatemntRead(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatemntWhileContext extends StatementContext {
		public ExpressionContext cdt;
		public BlockContext blockWhile;
		public TerminalNode WHILE() { return getToken(MiniLangParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatemntWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterStatemntWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitStatemntWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitStatemntWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatemntIFContext extends StatementContext {
		public ExpressionContext cdt;
		public BlockContext blockThen;
		public BlockContext blockElse;
		public TerminalNode ELSE() { return getToken(MiniLangParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(MiniLangParser.IF, 0); }
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode THEN() { return getToken(MiniLangParser.THEN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public StatemntIFContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterStatemntIF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitStatemntIF(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitStatemntIF(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatemntPrintContext extends StatementContext {
		public ExpressionContext expr;
		public TerminalNode PRINT() { return getToken(MiniLangParser.PRINT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatemntPrintContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterStatemntPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitStatemntPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitStatemntPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		int _la;
		try {
			setState(55);
			switch (_input.LA(1)) {
			case IF:
				_localctx = new StatemntIFContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(21); match(IF);
				setState(22); match(T__5);
				setState(23); ((StatemntIFContext)_localctx).cdt = expression(0);
				setState(24); match(T__4);
				setState(25); match(THEN);
				setState(26); ((StatemntIFContext)_localctx).blockThen = block();
				setState(29);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(27); match(ELSE);
					setState(28); ((StatemntIFContext)_localctx).blockElse = block();
					}
				}

				}
				break;
			case WHILE:
				_localctx = new StatemntWhileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(31); match(WHILE);
				setState(32); match(T__5);
				setState(33); ((StatemntWhileContext)_localctx).cdt = expression(0);
				setState(34); match(T__4);
				setState(35); ((StatemntWhileContext)_localctx).blockWhile = block();
				}
				break;
			case IDENTIFIER:
				_localctx = new StatemntAssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(37); match(IDENTIFIER);
				setState(38); match(T__7);
				setState(39); ((StatemntAssignContext)_localctx).expr = expression(0);
				setState(40); match(T__10);
				}
				break;
			case PRINT:
				_localctx = new StatemntPrintContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(42); match(PRINT);
				setState(43); match(T__5);
				setState(44); ((StatemntPrintContext)_localctx).expr = expression(0);
				setState(45); match(T__4);
				setState(46); match(T__10);
				}
				break;
			case READ:
				_localctx = new StatemntReadContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(48); match(READ);
				setState(49); match(T__5);
				setState(50); match(STRINGLITERAL);
				setState(51); match(T__1);
				setState(52); match(IDENTIFIER);
				setState(53); match(T__4);
				setState(54); match(T__10);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BinaryExprMultContext extends ExpressionContext {
		public ExpressionContext left;
		public Token bop;
		public ExpressionContext right;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public BinaryExprMultContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterBinaryExprMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitBinaryExprMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitBinaryExprMult(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprAddContext extends ExpressionContext {
		public ExpressionContext left;
		public Token bop;
		public ExpressionContext right;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public BinaryExprAddContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterBinaryExprAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitBinaryExprAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitBinaryExprAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryExprContext extends ExpressionContext {
		public PrimaryContext expr;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterPrimaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitPrimaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitPrimaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UniryExprContext extends ExpressionContext {
		public Token prefix;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UniryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterUniryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitUniryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitUniryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprCompContext extends ExpressionContext {
		public ExpressionContext left;
		public Token bop;
		public ExpressionContext right;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public BinaryExprCompContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterBinaryExprComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitBinaryExprComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitBinaryExprComp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			switch (_input.LA(1)) {
			case T__2:
			case T__0:
				{
				_localctx = new UniryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(58);
				((UniryExprContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__2 || _la==T__0) ) {
					((UniryExprContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(59); expression(4);
				}
				break;
			case T__5:
			case NUMBER:
			case IDENTIFIER:
			case STRINGLITERAL:
				{
				_localctx = new PrimaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(60); ((PrimaryExprContext)_localctx).expr = primary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(72);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprMultContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprMultContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(63);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(64);
						((BinaryExprMultContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__3) ) {
							((BinaryExprMultContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(65); ((BinaryExprMultContext)_localctx).right = expression(4);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprAddContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprAddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(66);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(67);
						((BinaryExprAddContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__2 || _la==T__0) ) {
							((BinaryExprAddContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(68); ((BinaryExprAddContext)_localctx).right = expression(3);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprCompContext(new ExpressionContext(_parentctx, _parentState));
						((BinaryExprCompContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(69);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(70);
						((BinaryExprCompContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__8) ) {
							((BinaryExprCompContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(71); ((BinaryExprCompContext)_localctx).right = expression(2);
						}
						break;
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdentifierContext extends PrimaryContext {
		public TerminalNode IDENTIFIER() { return getToken(MiniLangParser.IDENTIFIER, 0); }
		public IdentifierContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprParenthContext extends PrimaryContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprParenthContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterExprParenth(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitExprParenth(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitExprParenth(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends PrimaryContext {
		public TerminalNode STRINGLITERAL() { return getToken(MiniLangParser.STRINGLITERAL, 0); }
		public StringLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberLiteralContext extends PrimaryContext {
		public TerminalNode NUMBER() { return getToken(MiniLangParser.NUMBER, 0); }
		public NumberLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniLangListener ) ((MiniLangListener)listener).exitNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MiniLangVisitor ) return ((MiniLangVisitor<? extends T>)visitor).visitNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primary);
		try {
			setState(84);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new ExprParenthContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77); match(T__5);
				setState(78); expression(0);
				setState(79); match(T__4);
				}
				break;
			case NUMBER:
				_localctx = new NumberLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(81); match(NUMBER);
				}
				break;
			case STRINGLITERAL:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(82); match(STRINGLITERAL);
				}
				break;
			case IDENTIFIER:
				_localctx = new IdentifierContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(83); match(IDENTIFIER);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3: return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 3);
		case 1: return precpred(_ctx, 2);
		case 2: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\31Y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\7\3\21\n\3\f\3\16\3\24\13\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4 \n\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\5\5\5@\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\7\5K\n\5\f\5\16\5N\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6W\n\6\3"+
		"\6\2\3\b\7\2\4\6\b\n\2\5\4\2\r\r\17\17\4\2\3\3\f\f\4\2\4\4\7\7`\2\f\3"+
		"\2\2\2\4\16\3\2\2\2\69\3\2\2\2\b?\3\2\2\2\nV\3\2\2\2\f\r\5\4\3\2\r\3\3"+
		"\2\2\2\16\22\7\6\2\2\17\21\5\6\4\2\20\17\3\2\2\2\21\24\3\2\2\2\22\20\3"+
		"\2\2\2\22\23\3\2\2\2\23\25\3\2\2\2\24\22\3\2\2\2\25\26\7\t\2\2\26\5\3"+
		"\2\2\2\27\30\7\20\2\2\30\31\7\n\2\2\31\32\5\b\5\2\32\33\7\13\2\2\33\34"+
		"\7\21\2\2\34\37\5\4\3\2\35\36\7\22\2\2\36 \5\4\3\2\37\35\3\2\2\2\37 \3"+
		"\2\2\2 :\3\2\2\2!\"\7\23\2\2\"#\7\n\2\2#$\5\b\5\2$%\7\13\2\2%&\5\4\3\2"+
		"&:\3\2\2\2\'(\7\27\2\2()\7\b\2\2)*\5\b\5\2*+\7\5\2\2+:\3\2\2\2,-\7\24"+
		"\2\2-.\7\n\2\2./\5\b\5\2/\60\7\13\2\2\60\61\7\5\2\2\61:\3\2\2\2\62\63"+
		"\7\25\2\2\63\64\7\n\2\2\64\65\7\31\2\2\65\66\7\16\2\2\66\67\7\27\2\2\67"+
		"8\7\13\2\28:\7\5\2\29\27\3\2\2\29!\3\2\2\29\'\3\2\2\29,\3\2\2\29\62\3"+
		"\2\2\2:\7\3\2\2\2;<\b\5\1\2<=\t\2\2\2=@\5\b\5\6>@\5\n\6\2?;\3\2\2\2?>"+
		"\3\2\2\2@L\3\2\2\2AB\f\5\2\2BC\t\3\2\2CK\5\b\5\6DE\f\4\2\2EF\t\2\2\2F"+
		"K\5\b\5\5GH\f\3\2\2HI\t\4\2\2IK\5\b\5\4JA\3\2\2\2JD\3\2\2\2JG\3\2\2\2"+
		"KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\t\3\2\2\2NL\3\2\2\2OP\7\n\2\2PQ\5\b\5"+
		"\2QR\7\13\2\2RW\3\2\2\2SW\7\26\2\2TW\7\31\2\2UW\7\27\2\2VO\3\2\2\2VS\3"+
		"\2\2\2VT\3\2\2\2VU\3\2\2\2W\13\3\2\2\2\t\22\379?JLV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}