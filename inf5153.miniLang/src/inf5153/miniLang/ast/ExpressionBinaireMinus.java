package inf5153.miniLang.ast;


/**
 * Expression binaire : soustraction 
 *  
 * @author elhachemi Alikacem
 */

public class ExpressionBinaireMinus extends ExpressionBinaire {

	public ExpressionBinaireMinus(Expression leftExpresion, Expression rightExpresion) {
		super(leftExpresion, rightExpresion);
	}
	public Operator getOperateur() {
		return Operator.MINUS;
	}
	

}
