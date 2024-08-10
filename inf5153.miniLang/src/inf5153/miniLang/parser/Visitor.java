package inf5153.miniLang.parser;


import inf5153.miniLang.ast.*;

public interface Visitor {
    void visitBlock(Block block);
    void visitStatement(Statement stmt);
    void visitStatementAssign(StatementAssign stmt);
    void visitStatementPrint(StatementPrint stmt);
    void visitStatementIF(StatementIF stmt);
    void visitStatementWhile(StatementWhile stmt);
    int visitExpression(Expression expr);
    int visitBinaryExpression(ExpressionBinaire expr);
    int visitUnaryExpression(ExpressionUnaire expr);
}

