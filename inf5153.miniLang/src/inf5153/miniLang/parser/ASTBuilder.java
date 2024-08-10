package inf5153.miniLang.parser;

import java.util.ArrayList;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import inf5153.miniLang.ast.Block;
import inf5153.miniLang.ast.CompilationUnit;
import inf5153.miniLang.ast.Expression;
import inf5153.miniLang.ast.ExpressionBinaireAdd;
import inf5153.miniLang.ast.ExpressionBinaireDiv;
import inf5153.miniLang.ast.ExpressionBinaireMinus;
import inf5153.miniLang.ast.ExpressionBinaireMult;
import inf5153.miniLang.ast.ExpressionComparaison;
import inf5153.miniLang.ast.ExpressionNumber;
import inf5153.miniLang.ast.ExpressionParenthesee;
import inf5153.miniLang.ast.ExpressionString;
import inf5153.miniLang.ast.ExpressionUnaire;
import inf5153.miniLang.ast.ExpressionVariable;
import inf5153.miniLang.ast.Operator;
import inf5153.miniLang.ast.Statement;
import inf5153.miniLang.ast.StatementAssign;
import inf5153.miniLang.ast.StatementIF;
import inf5153.miniLang.ast.StatementPrint;
import inf5153.miniLang.ast.StatementRead;
import inf5153.miniLang.ast.StatementWhile;
import inf5153.miniLang.parser.MiniLangParser.BinaryExprAddContext;
import inf5153.miniLang.parser.MiniLangParser.BinaryExprCompContext;
import inf5153.miniLang.parser.MiniLangParser.BinaryExprMultContext;
import inf5153.miniLang.parser.MiniLangParser.CompUnitBlockContext;
import inf5153.miniLang.parser.MiniLangParser.ExprParenthContext;
import inf5153.miniLang.parser.MiniLangParser.IdentifierContext;
import inf5153.miniLang.parser.MiniLangParser.NumberLiteralContext;
import inf5153.miniLang.parser.MiniLangParser.PrimaryExprContext;
import inf5153.miniLang.parser.MiniLangParser.StatementsContext;
import inf5153.miniLang.parser.MiniLangParser.StatemntAssignContext;
import inf5153.miniLang.parser.MiniLangParser.StatemntIFContext;
import inf5153.miniLang.parser.MiniLangParser.StatemntPrintContext;
import inf5153.miniLang.parser.MiniLangParser.StatemntReadContext;
import inf5153.miniLang.parser.MiniLangParser.StatemntWhileContext;
import inf5153.miniLang.parser.MiniLangParser.StringLiteralContext;
import inf5153.miniLang.parser.MiniLangParser.UniryExprContext;

public class ASTBuilder implements MiniLangVisitor<Object> {

	private static final boolean debug = false  ; 
	
	@Override
	public Object visit(ParseTree arg0) {
		if (debug) System.out.println ("Start AST Building") ;
		CompilationUnit res = (CompilationUnit)arg0.accept(this) ; 
		if (debug) System.out.println ("END AST Building") ;
		return res ;
	}

	@Override
	public Object visitChildren(RuleNode arg0) {
		if (debug) System.out.println ("visitChildren") ;
		return null;
	}

	@Override
	public Object visitErrorNode(ErrorNode arg0) {
		System.err.println("Error encountered: " + arg0.getText());
		return null;
	}

	@Override
	public Object visitTerminal(TerminalNode arg0) {
		return null;
	}

	@Override
	public Object visitBinaryExprMult(BinaryExprMultContext ctx) {
	
		String sOper = ctx.bop.getText() ; 
		Expression leftExpr = (Expression)ctx.left.accept(this) ;
		Expression rightExpr = (Expression)ctx.right.accept(this) ;
		
		if (debug) System.out.println ("Expr Mult : " + sOper );
		Expression expr = null ; 
		switch(sOper) {
			case "*" : expr = new ExpressionBinaireMult(leftExpr, rightExpr); break ; 
			case "/" : expr = new ExpressionBinaireDiv(leftExpr, rightExpr) ; break ; 
			default : System.err.println ("Operator not Exprected : " + sOper) ; 		
		}
		return expr ;	
	}

	@Override
	public Object visitBinaryExprAdd(BinaryExprAddContext ctx) {
		
		String sOper = ctx.bop.getText() ; 
		Expression leftExpr = (Expression)ctx.left.accept(this) ;
		Expression rightExpr = (Expression)ctx.right.accept(this) ;
		
		
		if (debug) System.out.println ("Expr Add : " + sOper );
		Expression expr = null ; 
		switch(sOper) {
			case "+" : expr = new ExpressionBinaireAdd(leftExpr, rightExpr); break ; 
			case "-" : expr = new ExpressionBinaireMinus(leftExpr, rightExpr) ; break ; 
			default : System.err.println ("Operator not Exprected : " + sOper) ; 		
		}
		
		return expr ;
	}

	@Override
	public Object visitPrimaryExpr(PrimaryExprContext ctx) {
		if (debug) System.out.println ("Primary Expr") ;
		Expression expr = (Expression)ctx.expr.accept(this) ; 
		return expr;
	}

	
	@Override
	public Object visitUniryExpr(UniryExprContext ctx) {
		if (debug) System.out.println ("UnaryExpr") ;
		Expression expr = (Expression)ctx.expression().accept(this) ; 
		
		String sOper = ctx.prefix.getText() ;
		
		Operator oper = null ; 
		switch(sOper) {
			case "+" : oper = Operator.PLUS ; break ;  
			case "-" : oper = Operator.MINUS ; break ; 
			default : System.err.println ("Operator not Exprected " + sOper ) ; 
		}
		ExpressionUnaire expUnaire = new ExpressionUnaire( oper , expr) ; 
		
		return expUnaire ;
	}

	@Override
	public Object visitBinaryExprComp(BinaryExprCompContext ctx) {

		String sOper = ctx.bop.getText() ;
		if (debug) System.out.println ("Expr Comp : " + sOper ) ;
		
		Expression leftExpr = (Expression)ctx.left.accept(this) ;
		Expression rightExpr = (Expression)ctx.right.accept(this) ;
		
 
		Operator oper = null ; 
		switch(sOper) {
			case "==" : oper = Operator.EQUAL ; break ; 
			case "!=" : oper = Operator.DIFF ; break ;
			default : 
				System.err.println ("Operator not Expected : " + sOper) ; 
		}
		
		ExpressionComparaison expr = new  ExpressionComparaison(leftExpr , rightExpr , oper) ; 
		return expr ;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object visitCompUnitBlock(CompUnitBlockContext ctx) {
		if (debug) System.out.println ("CompUnit Block") ;
		Block bl = (Block)ctx.block().accept(this) ;
		CompilationUnit cUnit = new CompilationUnit(bl) ;
		return cUnit ;
	}

	@Override
	public Object visitStatemntAssign(StatemntAssignContext ctx) {
	
		Expression expr = (Expression)ctx.expr.accept(this) ; 
		if (debug) System.out.println ("StatMnt Assign - Var : " + ctx.IDENTIFIER()  + "\n\t"+expr);
		
		StatementAssign st = new StatementAssign(ctx.IDENTIFIER().getText() , expr ) ; 
		
		return st ;
	}

	@Override
	public Object visitStatemntWhile(StatemntWhileContext ctx) {
		if (debug) System.out.println ("Statement While");

		ExpressionComparaison comp = (ExpressionComparaison)ctx.cdt.accept(this) ; 
		Block block = (Block)ctx.blockWhile.accept(this) ; 
		Statement st = new StatementWhile(comp , block) ; 
		return st;
	}

	@Override
	public Object visitStatemntIF(StatemntIFContext ctx) {
		if (debug) System.out.println ("Statemnt IF");
		
		ExpressionComparaison comp =  (ExpressionComparaison)ctx.cdt.accept(this) ;
		Block blThen = (Block)ctx.blockThen.accept(this) ;
		Block blElse = null ; 
		if (ctx.blockElse != null) {
			blElse = (Block)ctx.blockElse.accept(this) ; 
		}
		
		StatementIF st = new StatementIF(comp , blThen , blElse ) ; 
		

		return st;
	}

	@Override
	public Object visitStatemntPrint(StatemntPrintContext ctx) {		
		if (debug) System.out.println ("Statemnt Print");
		Expression expr = (Expression)ctx.expr.accept(this) ;
		
		StatementPrint st = new StatementPrint(expr) ; 
		
		return st;
	}

	@Override
	public Object visitStatemntRead(StatemntReadContext ctx) {		
		if (debug) System.out.println ("Statemnt Read");
		String msg = ctx.STRINGLITERAL().getText() ;
		String idf = ctx.IDENTIFIER().getText() ;
		ExpressionVariable expVar = new ExpressionVariable(idf) ; 
		
		StatementRead st = new StatementRead(msg , expVar) ; 
		return st ;
	}

	@Override
	public Object visitIdentifier(IdentifierContext ctx) {
		if (debug) System.out.println ("Identif : " + ctx.getText() );
		
		ExpressionVariable exprVar = new ExpressionVariable(ctx.getText()) ; 
		return exprVar;
	}

	@Override
	public Object visitExprParenth(ExprParenthContext ctx) {
		if (debug) System.out.println ("Expr Parenthesis");
		
		Expression expr = (Expression)ctx.expression().accept(this) ; 
		ExpressionParenthesee exprPar = new ExpressionParenthesee(expr) ; 
		
		return expr;
	}

	@Override
	public Object visitStringLiteral(StringLiteralContext ctx) {
		if (debug) System.out.println ("String Literal");		
	    ExpressionString exprStr = new ExpressionString(ctx.getText()) ;
		return exprStr;
	}

	@Override
	public Object visitNumberLiteral(NumberLiteralContext ctx) {
		if (debug) System.out.println ("Number Literal");
		Integer val = Integer.parseInt(ctx.NUMBER().getText()) ; 
		ExpressionNumber ret= new ExpressionNumber(val) ; 
		return ret ;
	}

	@Override
	public Object visitStatements(StatementsContext ctx) {
		if (debug) System.out.println ("Statemnts");
		ArrayList<Statement> list = new ArrayList<>() ; 	
		Object rep ; 
			
		for(ParseTree child : ctx.children){
			
			Statement oneStatemnt = (Statement)child.accept(this);

			if (oneStatemnt instanceof Statement) {
				list.add(oneStatemnt) ; 
			}
		} 
		Block bl = new Block(list) ; 
		return bl ;
	}

}
