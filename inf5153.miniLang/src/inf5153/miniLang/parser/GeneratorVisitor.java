package inf5153.miniLang.parser;

import inf5153.miniLang.ast.*;
import java.util.HashSet;
import java.util.Set;

public class GeneratorVisitor implements Visitor {

    // Create the remaining code in the form of a java file
    private final StringBuilder javaCode = new StringBuilder();

    // Create the attributes part in java file
    private final StringBuilder javaCodeDefinitionVar = new StringBuilder();

    //(right part of the assignment): the variables to be read
    private final Set<String> variables = new HashSet<>();
    private int indentationLevel = 1;  // Start with level one of indentation

    private String getIndentation() {
        return "    ".repeat(indentationLevel);
    }

    @Override
    public void visitBlock(Block block) {
        for (Statement statement : block.getStatements()) {
            javaCode.append("    ");
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
        }else if (statement instanceof StatementRead) {
            visitStatementRead((StatementRead) statement);
        }
    }

    @Override
    public void visitStatementAssign(StatementAssign statement) {
        String varName = statement.getVariableName();
        if (!variables.contains(varName)) {
            javaCodeDefinitionVar.append("        ").append("int ").append(varName).append(";\n" );
            variables.add(varName);
        }
        javaCode.append(getIndentation()).append(varName).append(" = ");
        visitExpression(statement.getExpression());
        javaCode.append(";\n");
    }

    @Override
    public void visitStatementPrint(StatementPrint statement) {
        javaCode.append(getIndentation()).append("System.out.println(");
        visitExpression(statement.getExpression());
        javaCode.append(");\n");
    }

    public void visitStatementRead(StatementRead statement) {
        // Generate the code for reading input from the user
        javaCode.append(getIndentation()).append("System.out.print(").append(statement.getMessage()).append(");\n");
        javaCode.append(getIndentation()).append("    "+statement.getVarName().getVarName()).append(" = new java.util.Scanner(System.in).nextInt();\n");

        // Ensure the variable is declared
        String varName = statement.getVarName().getVarName();
        if (!variables.contains(varName)) {
            javaCodeDefinitionVar.append("        int ").append(varName).append(";\n");
            variables.add(varName);
        }
    }


    @Override
    public void visitStatementIF(StatementIF statement) {
        javaCode.append(getIndentation()).append("if (" );
        visitExpression(statement.getCondition());
        javaCode.append(") {\n");
        indentationLevel++;
        visitBlock(statement.getBlockThen());
        indentationLevel--;
        javaCode.append(getIndentation()).append("    }");
        if (statement.getBlockElse() != null) {
            javaCode.append(" else {\n");
            indentationLevel++;
            visitBlock(statement.getBlockElse());
            indentationLevel--;
            javaCode.append(getIndentation()).append("    }\n" );
        } else {
            javaCode.append("\n");
        }
    }

    @Override
    public void visitStatementWhile(StatementWhile statement) {
        javaCode.append(getIndentation()).append("while (" );
        visitExpression(statement.getCondition());
        javaCode.append(") {\n");
        indentationLevel++;
        visitBlock(statement.getBlockWhile());
        indentationLevel--;
        javaCode.append(getIndentation()).append("    }\n");
    }

    @Override
    public int visitExpression(Expression expr) {
        if (expr instanceof ExpressionNumber) {
            javaCode.append(((ExpressionNumber) expr).getValue());
        } else if (expr instanceof ExpressionVariable) {
            javaCode.append(((ExpressionVariable) expr).getVarName());
        } else if (expr instanceof ExpressionBinaire) {
            visitBinaryExpression((ExpressionBinaire) expr);
        } else if (expr instanceof ExpressionParenthesee) {
            javaCode.append("(");
            visitExpression(((ExpressionParenthesee) expr).getExpression());
            javaCode.append(")");
        } else if (expr instanceof ExpressionUnaire) {
            visitUnaryExpression((ExpressionUnaire) expr);
        } else if (expr instanceof  ExpressionString) {
            javaCode.append(((ExpressionString) expr ).getValue());
        }
        return 1;
    }

    @Override
    public int visitBinaryExpression(ExpressionBinaire expr) {
        javaCode.append("(");
        visitExpression(expr.getLeftExpresion());
        javaCode.append(" ").append(OperatorMapping.getJavaOperator(expr.getOperateur())).append(" ");
        visitExpression(expr.getRightExpresion());
        javaCode.append(")");
        return 1;
    }

    @Override
    public int visitUnaryExpression(ExpressionUnaire expr) {
        javaCode.append(OperatorMapping.getJavaOperator(expr.getOperateur()));
        visitExpression(expr.getExpression());
        return 1;
    }

    public String getGeneratedCode() {
        return javaCode.toString();
    }

    public String getGeneratedCodeVarDef() {
        return javaCodeDefinitionVar.toString();
    }
}
