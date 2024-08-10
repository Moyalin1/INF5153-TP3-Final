// Generated from MiniLang.g4 by ANTLR 4.4

	package inf5153.miniLang.parser ;
	
	import inf5153.miniLang.ast.* ; 

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MiniLangParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(@NotNull MiniLangParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniryExpr}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniryExpr(@NotNull MiniLangParser.UniryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprParenth}
	 * labeled alternative in {@link MiniLangParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParenth(@NotNull MiniLangParser.ExprParenthContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statemntAssign}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatemntAssign(@NotNull MiniLangParser.StatemntAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statemntWhile}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatemntWhile(@NotNull MiniLangParser.StatemntWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statemntIF}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatemntIF(@NotNull MiniLangParser.StatemntIFContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statemntPrint}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatemntPrint(@NotNull MiniLangParser.StatemntPrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExprMult}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExprMult(@NotNull MiniLangParser.BinaryExprMultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExprAdd}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExprAdd(@NotNull MiniLangParser.BinaryExprAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primaryExpr}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(@NotNull MiniLangParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExprComp}
	 * labeled alternative in {@link MiniLangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExprComp(@NotNull MiniLangParser.BinaryExprCompContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link MiniLangParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(@NotNull MiniLangParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompUnitBlock}
	 * labeled alternative in {@link MiniLangParser#compileUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnitBlock(@NotNull MiniLangParser.CompUnitBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statemntRead}
	 * labeled alternative in {@link MiniLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatemntRead(@NotNull MiniLangParser.StatemntReadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Statements}
	 * labeled alternative in {@link MiniLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(@NotNull MiniLangParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberLiteral}
	 * labeled alternative in {@link MiniLangParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberLiteral(@NotNull MiniLangParser.NumberLiteralContext ctx);
}