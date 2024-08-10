package inf5153.miniLang.ast;

/**
 * 
 * Une variable  
 *  
 * @author elhachemi Alikacem
 */
public class ExpressionVariable extends Expression {
	private String varName ;

	public ExpressionVariable(String varName) {
		super();
		this.varName = varName;
	}  
	
	public String getVarName() {
		return varName;
	}

}
