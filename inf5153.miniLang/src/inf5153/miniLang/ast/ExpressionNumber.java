package inf5153.miniLang.ast;

/**
 * Expression correspondant à un nombre (entier) 
 *  
 * @author elhachemi Alikacem
 */

public class ExpressionNumber extends Expression {
	private Integer value ;

	public ExpressionNumber(Integer value) {
		super();
		this.value = value;
	}


	public Integer getValue() {
		return value;
	}
}
