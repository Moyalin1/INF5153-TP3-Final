package inf5153.miniLang.parser;

import inf5153.miniLang.ast.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EvaluatorVisitor implements Visitor{

    // stock all the variables, the key is variable's name and the value is the value of the variable
    private final Map<String, Integer> varMap = new HashMap<>();

    // If the user enters something other than a number on the terminal,
    // this method will be called and an error message will be output on the terminal.
    public Object visitErrorNode(String arg0) {
        System.err.println("Error encountered: " + arg0 + "Please enter a number! ");
        return null;
    }

    //Get input message from terminal
    public Object visitTerminal(TerminalNode arg0) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            visitErrorNode(input)  ;
            return null;
        }
    }

    public void visitCompilationUnit(CompilationUnit cUnit) {
        visitBlock(cUnit.getBlock());

    }

    public void visitBlock(Block block) {;
        for (Statement statement : block.getStatements()) {
            visitStatement(statement);
        }
    }

    public void visitStatementRead(StatementRead statement) {
        // Handle the read statement by reading input and assigning it to the variable
        System.out.print(statement.getMessage());
        int value = (int) visitTerminal(null);
        varMap.put(statement.getVarName().getVarName(), value);
    }

    public void visitStatement(Statement statement) {

        if (statement instanceof StatementAssign) {
            visitStatementAssign((StatementAssign) statement);

        } else if (statement instanceof StatementPrint) {
            visitStatementPrint((StatementPrint) statement);

        } else if (statement instanceof StatementIF) {
            visitStatementIF((StatementIF) statement);

        } else if (statement instanceof StatementWhile) {
            visitStatementWhile((StatementWhile) statement);

        } else if (statement instanceof StatementRead) {
            visitStatementRead((StatementRead) statement);
        }
    }

    public void visitStatementAssign(StatementAssign statement) {
        String varName = statement.getVariableName();
        int value = visitExpression(statement.getExpression());
        varMap.put(varName, value);
    }

    public void visitStatementPrint(StatementPrint statement) {
        int value = visitExpression(statement.getExpression());
        System.out.println(value);
    }

    public void visitStatementIF(StatementIF statement) {
        int conditionValue = visitExpression(statement.getCondition());
        if (conditionValue != 0) {
            visitBlock(statement.getBlockThen());
        } else if (statement.getBlockElse() != null) {
            visitBlock(statement.getBlockElse());

        }
    }

    public void visitStatementWhile(StatementWhile statement) {
        while (visitExpression(statement.getCondition()) != 0) {
            visitBlock(statement.getBlockWhile());
        }
    }

    public int visitExpression(Expression expr) {

        if (expr instanceof ExpressionNumber) {
            return ((ExpressionNumber) expr).getValue();

        } else if (expr instanceof ExpressionVariable) {
            String varName = ((ExpressionVariable) expr).getVarName();
            if (!varMap.containsKey(varName)) {
                throw new RuntimeException("Variable not defined: " + varName);
            }
            return varMap.get(varName);

        } else if (expr instanceof ExpressionBinaire) {
            return visitBinaryExpression((ExpressionBinaire) expr);

        } else if (expr instanceof ExpressionParenthesee) {
            return visitExpression(((ExpressionParenthesee) expr).getExpression());

        } else if (expr instanceof ExpressionUnaire) {
            return visitUnaryExpression((ExpressionUnaire) expr);
        }
        return 0;
    }

    public int visitBinaryExpression(ExpressionBinaire expr) {
        int leftValue = visitExpression(expr.getLeftExpresion());
        int rightValue = visitExpression(expr.getRightExpresion());

        if (expr instanceof ExpressionBinaireAdd) {
            return leftValue + rightValue;

        } else if (expr instanceof ExpressionBinaireMinus) {
            return leftValue - rightValue;

        } else if (expr instanceof ExpressionBinaireMult) {
            return leftValue * rightValue;

        } else if (expr instanceof ExpressionBinaireDiv) {
            if (rightValue == 0) {
                throw new ArithmeticException("Can not divisied by zero");
            }
            return leftValue / rightValue;
        }
        else if (expr instanceof ExpressionComparaison) {

            return visitComparisonExpression((ExpressionComparaison) expr);
        }
        return 0;
    }

    public int visitUnaryExpression(ExpressionUnaire expr) {
        int value = visitExpression(expr.getExpression());
        if (expr.getOperateur() == Operator.MINUS) {
            return -value;
        }
        return value;
    }

    public int visitComparisonExpression(ExpressionComparaison expr) {
        int leftValue = visitExpression(expr.getLeftExpresion());
        int rightValue = visitExpression(expr.getRightExpresion());

        switch (expr.getOperateur()) {
            case EQUAL:
                if (leftValue == rightValue) {
                    return 1;
                } else {
                    return 0;
                }

            case DIFF:
                if (leftValue != rightValue) {
                    return 1;
                } else {
                    return 0;
                }

            default:
                throw new RuntimeException("Undefined operator: " + expr.getOperateur());
        }
    }
}
