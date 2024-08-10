package inf5153.miniLang.ast;

/**
 * Représente une expression parenthésée 
 * 
 * @author elhachemi 
 */
public class ExpressionParenthesee extends Expression {
	private Expression expression ;

	public ExpressionParenthesee(Expression expression) {
		super();
		this.expression = expression;
	}

	public Expression getExpression() {
		return expression;
	}
}
