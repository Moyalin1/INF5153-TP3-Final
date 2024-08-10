package inf5153.miniLang.parser;
import inf5153.miniLang.ast.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionVarVisitor implements Visitor {

    private final List<AssignObject> listAssiObj = new ArrayList<>();

    @Override
    public void visitBlock(Block block) {
        for (Statement statement : block.getStatements()) {
            visitStatement(statement);
        }
    }

    @Override
    public void visitStatement(Statement statement) {
        if (statement instanceof StatementAssign) {
            visitStatementAssign((StatementAssign) statement);
        } else if (statement instanceof StatementPrint) {
            visitStatementPrint((StatementPrint) statement);
        } else if (statement instanceof StatementIF) {
            visitStatementIF((StatementIF) statement);
        } else if (statement instanceof StatementWhile) {
            visitStatementWhile((StatementWhile) statement);
        }

    }

    //This method gets the ‘variable en écriture’, creates an instance of AssignObject and adds the created
    // instance (with the ‘variable en écritur’ and the ‘variables en lecture’) to listAssiObj
    @Override
    public void visitStatementAssign(StatementAssign statement) {
        String gaucheVar = statement.getVariableName();
        AssignObject assignObject = new AssignObject(gaucheVar);

        visitExpression(statement.getExpression(), assignObject);

        listAssiObj.add(assignObject);
    }

    @Override
    public void visitStatementPrint(StatementPrint statement) {
        visitExpression(statement.getExpression(), null); 
    }

    @Override
    public void visitStatementIF(StatementIF statement) {
        visitExpression(statement.getCondition(), null);
        visitBlock(statement.getBlockThen());
        if (statement.getBlockElse() != null) {
            visitBlock(statement.getBlockElse());
        }
    }

    @Override
    public void visitStatementWhile(StatementWhile statement) {
        visitExpression(statement.getCondition(), null);
        visitBlock(statement.getBlockWhile());
    }


    @Override

    public int visitExpression(Expression expr) {
        // Default behavior if no AssignObject is needed
        return visitExpression(expr, null);
    }

    public int visitExpression(Expression expr, AssignObject assignObject) {
        if (expr instanceof ExpressionVariable) {
            if (assignObject != null) {
                assignObject.addUsedVariable(((ExpressionVariable) expr).getVarName());
            }
        } else if (expr instanceof ExpressionBinaire) {
            visitBinaryExpression((ExpressionBinaire) expr, assignObject);
        } else if (expr instanceof ExpressionParenthesee) {
            visitExpression(((ExpressionParenthesee) expr).getExpression(), assignObject);
        } else if (expr instanceof ExpressionUnaire) {
            visitUnaryExpression((ExpressionUnaire) expr, assignObject);
        }

        return 0;
    }

    @Override
    public int visitBinaryExpression(ExpressionBinaire expr) {
        // Default behavior if no AssignObject is needed
        return visitBinaryExpression(expr, null);
    }

    public int visitBinaryExpression(ExpressionBinaire expr, AssignObject assignObject) {
        visitExpression(expr.getLeftExpresion(), assignObject);
        visitExpression(expr.getRightExpresion(), assignObject);
        return 0;
    }

    @Override
    public int visitUnaryExpression(ExpressionUnaire expr) {
        // Default behavior if no AssignObject is needed
        return visitUnaryExpression(expr, null);
    }

    public int visitUnaryExpression(ExpressionUnaire expr, AssignObject assignObject) {
        visitExpression(expr.getExpression(), assignObject);
        return 0;
    }

    public List<AssignObject> getAssignObjects() {
        return listAssiObj;
    }
}

