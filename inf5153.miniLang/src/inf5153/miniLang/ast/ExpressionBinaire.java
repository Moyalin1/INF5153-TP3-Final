package inf5153.miniLang.ast;


/**
 * Classe abstraite représente les expressions binaire : 
 * composées d'une partie gauche, une partie droite et 
 * un opérateur 
 * Ici, nous n'avons pas besoin de stocker l'operateur : voir les sous-classes
 * 
 * @author elhachemi Alikacem
 */
public abstract class ExpressionBinaire extends Expression { 
	protected Expression leftExpresion ;
	protected Expression rightExpresion ;
	
	public ExpressionBinaire(Expression leftExpresion, Expression rightExpresion) {
		super();
		this.leftExpresion = leftExpresion;
		this.rightExpresion = rightExpresion;
	}

	public Expression getLeftExpresion() {
		return leftExpresion;
	}

	public Expression getRightExpresion() {
		return rightExpresion;
	}

	public abstract Operator getOperateur();

	@Override
	public String toString() {
		return "ExpressionBinaire{" +
				"leftExpresion=" + getLeftExpresion() +
				", rightExpresion=" + rightExpresion +
				'}';
	}
}
