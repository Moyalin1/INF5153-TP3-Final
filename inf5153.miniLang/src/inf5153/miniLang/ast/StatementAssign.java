package inf5153.miniLang.ast;


import inf5153.miniLang.parser.CollectionVarVisitor;

/**
 * Modélise l'affectation 
 * 
 * 
 * @author elhachemi Alikacem
 */

public class StatementAssign extends Statement {
	private String variableName  ; // left hand side 
	private Expression expression ; // right hand side  
	
	
	public StatementAssign(String variableName, Expression expression) {
		super();
		this.variableName = variableName;
		this.expression = expression;
	}

	public String getVariableName() {
		return variableName;
	}

	public Expression getExpression() {
		return expression;
	}



}
