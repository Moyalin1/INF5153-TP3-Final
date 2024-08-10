// Generated from MiniLang.g4 by ANTLR 4.4

	package inf5153.miniLang.parser ;
	
	import inf5153.miniLang.ast.* ; 

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniLangParser}.
 */
public interface MiniLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MiniLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(@NotNull MiniLangParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MiniLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(@NotNull MiniLangParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code uniryExpr}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUniryExpr(@NotNull MiniLangParser.UniryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code uniryExpr}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUniryExpr(@NotNull MiniLangParser.UniryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprParenth}
	 * labeled alternative in {@link MiniLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterExprParenth(@NotNull MiniLangParser.ExprParenthContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprParenth}
	 * labeled alternative in {@link MiniLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitExprParenth(@NotNull MiniLangParser.ExprParenthContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statemntAssign}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatemntAssign(@NotNull MiniLangParser.StatemntAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statemntAssign}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatemntAssign(@NotNull MiniLangParser.StatemntAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statemntWhile}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatemntWhile(@NotNull MiniLangParser.StatemntWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statemntWhile}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatemntWhile(@NotNull MiniLangParser.StatemntWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statemntIF}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatemntIF(@NotNull MiniLangParser.StatemntIFContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statemntIF}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatemntIF(@NotNull MiniLangParser.StatemntIFContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statemntPrint}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatemntPrint(@NotNull MiniLangParser.StatemntPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statemntPrint}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatemntPrint(@NotNull MiniLangParser.StatemntPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExprMult}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExprMult(@NotNull MiniLangParser.BinaryExprMultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExprMult}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExprMult(@NotNull MiniLangParser.BinaryExprMultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExprAdd}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExprAdd(@NotNull MiniLangParser.BinaryExprAddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExprAdd}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExprAdd(@NotNull MiniLangParser.BinaryExprAddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(@NotNull MiniLangParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(@NotNull MiniLangParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExprComp}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExprComp(@NotNull MiniLangParser.BinaryExprCompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExprComp}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExprComp(@NotNull MiniLangParser.BinaryExprCompContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link MiniLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(@NotNull MiniLangParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link MiniLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(@NotNull MiniLangParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompUnitBlock}
	 * labeled alternative in {@link MiniLangParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnitBlock(@NotNull MiniLangParser.CompUnitBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompUnitBlock}
	 * labeled alternative in {@link MiniLangParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnitBlock(@NotNull MiniLangParser.CompUnitBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statemntRead}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatemntRead(@NotNull MiniLangParser.StatemntReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statemntRead}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatemntRead(@NotNull MiniLangParser.StatemntReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Statements}
	 * labeled alternative in {@link MiniLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterStatements(@NotNull MiniLangParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Statements}
	 * labeled alternative in {@link MiniLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitStatements(@NotNull MiniLangParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link MiniLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterNumberLiteral(@NotNull MiniLangParser.NumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link MiniLangParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitNumberLiteral(@NotNull MiniLangParser.NumberLiteralContext ctx);
}