package inf5153.miniLang.ast;


/**
 * Expression binaire : addition 
 * 
 * @author elhachemi Alikacem
 * 
 */
public class ExpressionBinaireAdd extends ExpressionBinaire {

	public ExpressionBinaireAdd(Expression leftExpresion, Expression rightExpresion) {
		super(leftExpresion, rightExpresion);
	}

	public Operator getOperateur() {
		return Operator.PLUS;
	}

}
