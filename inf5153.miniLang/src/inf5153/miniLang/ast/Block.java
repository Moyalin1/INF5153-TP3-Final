package inf5153.miniLang.ast;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Modélise un bloc d'instructions  
 * 
 * 
 * @author elhachemi Alikacem
 */
public class Block implements ElementAST {

	private ArrayList<Statement> listStatements = new ArrayList<>() ; 
	
	public Block(ArrayList<Statement> listStatements) {
		this.listStatements = listStatements;
	}

	/**
	 * 
	 * @param statement
	 */
	public void addStatement(Statement statement) {
		listStatements.add(statement) ; 
	}
	
	/**
	 * Retourne un itérateur de la liste des Statements du block  
	 * @return
	 */
	public Iterator<Statement> iterator() {
		return listStatements.iterator() ; 
	}

	public ArrayList<Statement> getStatements() {
		return listStatements;
	}

	@Override
	public String toString() {
		return "Block{" +
				"listStatements=" + listStatements +
				'}';

	}
}
