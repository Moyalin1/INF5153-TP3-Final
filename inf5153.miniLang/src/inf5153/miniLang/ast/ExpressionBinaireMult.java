package inf5153.miniLang.ast;


/**
 * Expression binaire : multiplication 
 *  
 * @author elhachemi Alikacem
 */
public class ExpressionBinaireMult extends ExpressionBinaire{

	public ExpressionBinaireMult(Expression leftExpresion, Expression rightExpresion) {
		super(leftExpresion, rightExpresion);
	}

	public Operator getOperateur() {
		return Operator.MULT;
	}
	
}
