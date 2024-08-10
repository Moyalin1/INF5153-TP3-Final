package inf5153.miniLang.ast;



/**
 * Classe générale représentant les expressions 
 * 
 * @author elhachemi Alikacem
 */
public abstract class Expression implements ElementAST {
	
	/**
	 * Peut-être utilisé pour stocker la valeur de l'expression 
	 * 
	 */
	private Object value = null ; 
	
	public void setValue(Object value) {
		this.value = value ; 
	}
	/**
	 * 
	 * @return
	 */
	public Integer intValue() {
		if (value instanceof Integer) {
			return (Integer)value ; 
		} else {
			throw new RuntimeException("Erreur de type de donnée") ; 
		}
	}
	
	public Boolean booleanValue() {
		if (value instanceof Boolean) {
			return (Boolean)value ;
		} else {
			throw new RuntimeException("Erreur de type de donnée") ; 
		}
	}
	
	public String stringValue() {
		if (value instanceof String) {
			return (String)value ;
		}  else {
			throw new RuntimeException("Erreur de type de donnée") ; 
		}
	}


	@Override
	public String toString() {
		return "Expression{" +
				"value=" + value +
				'}';
	}
}
