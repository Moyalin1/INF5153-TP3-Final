package inf5153.miniLang.ast;

/**
 * Expression binaire : Division
 *  
 * @author elhachemi Alikacem
 */
public class ExpressionBinaireDiv extends ExpressionBinaire{

	public ExpressionBinaireDiv(Expression leftExpresion, Expression rightExpresion) {
		super(leftExpresion, rightExpresion);
	}

	public Operator getOperateur() {
		return Operator.DIV;
	}

}
