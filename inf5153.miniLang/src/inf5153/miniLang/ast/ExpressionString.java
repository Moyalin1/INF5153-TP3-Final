package inf5153.miniLang.ast;


/**
 * 
 * Expression : une constante chaine de caractères 
 *  
 * @author elhachemi Alikacem
 */
public class ExpressionString  extends Expression {
	private String value ;

	public ExpressionString(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
