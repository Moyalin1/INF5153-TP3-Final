package inf5153.miniLang.ast;


/**
 * 
 * Expression unaire 
 *  
 * @author elhachemi Alikacem
 */
public class ExpressionUnaire extends Expression {
	
	private Operator operateur ; // MUST Be PLUS or MINUS
	private Expression expression ;
	
	/**
	 * 
	 * @param operateur
	 * @param expression
	 */
	public ExpressionUnaire(Operator operateur, Expression expression) {
		super();
		this.operateur = operateur;
		this.expression = expression;
	}

	public Operator getOperateur() {
		return operateur;
	}

	public Expression getExpression() {
		return expression;
	}
}
