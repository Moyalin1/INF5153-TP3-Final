package inf5153.miniLang.ast;

/**
 * Represente une condition, 
 * 
 * Elle est sous-classe de expressionBinaire, car composée d'une expression à gauche 
 * et une expression à droite 
 *  
 * 
 * 
 * @author elhachemi Alikacem
 */
public class ExpressionComparaison extends ExpressionBinaire {
	private Operator comparaisonOper ; // must be == or !=  

	public ExpressionComparaison(Expression leftExpresion, Expression rightExpresion , Operator oper) {
		super(leftExpresion, rightExpresion);
		this.comparaisonOper = oper ; 
	}

	public Operator getOperateur() {
		return comparaisonOper;
	}


}
