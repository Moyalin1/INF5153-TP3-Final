package inf5153.miniLang.ast;

/**
 * Classe racine de l'AST - Représente un fichier de code source 
 * 
 * 
 * @author elhachemi Alikacem
 */
public class CompilationUnit implements ElementAST {
	private String filename ; 
	private Block block ;
	
	public CompilationUnit(Block block) {
		this.block = block;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Block getBlock() {
		return block;
	}

	public String toString() {
		return "CompilationUnit{" +
				"filename='" + filename + '\'' +
				", block=" + block +
				'}';
	}
}
