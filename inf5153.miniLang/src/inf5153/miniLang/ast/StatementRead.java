package inf5153.miniLang.ast;


/**
 * Modèlise l'instruction Print
 *   
 * @author elhachemi Alikacem 
 */
public class StatementRead  extends Statement {
	private String message ; 
	private ExpressionVariable varName ;
	
	
	public StatementRead(String message, ExpressionVariable varName) {
		super();
		this.message = message;
		this.varName = varName;
	}

	public String getMessage() {
		return message;
	}

	public ExpressionVariable getVarName() {
		return varName;
	}
}
