package inf5153.miniLang.main;

import java.io.File;
import java.io.IOException;

import inf5153.miniLang.parser.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import inf5153.miniLang.ast.CompilationUnit;

/**
 * Programme principal 
 * 
 */

//Yalin Mo (MOXY89610000)
//Xuanyu Zong(ZONX21599606(UQAM version))
//Yilin Zang （ZANY01519700）
//Vous pourriez lire README.md pour le guide d'exécution.

public class Principale {

	
	public static CompilationUnit parsing(String fileName ) {
		CompilationUnit cUnit = null   ; 
		
		try {
			ANTLRFileStream input;

			input = new ANTLRFileStream(fileName);

			MiniLangLexer lex = new MiniLangLexer(input);          // transforms characters into tokens
			CommonTokenStream tokens = new CommonTokenStream(lex); // a token stream

			MiniLangParser parser = new MiniLangParser(tokens);    // transforms tokens into parse trees

			ParseTree t = parser.compileUnit(); 
			ASTBuilder astBuilder = new ASTBuilder(); 
			cUnit = (CompilationUnit)astBuilder.visit(t);

		} catch (IOException e) {
			e.printStackTrace();
		} // a character stream
		
		return cUnit; 
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		//Define the name of the test file
		String testFileName0 = "Exemple0";
		String testFileName1 = "Exemple1";
		String testFileName2 = "Exemple2";

		// Get the path of the test file
		String currentDir = System.getProperty("user.dir");
		String source = currentDir + "/inf5153.miniLang/source/"+testFileName0+".mnl";

		// Get the AST tree
		CompilationUnit cUnit = parsing(source);


		// ----------------------Code for task 1----------------------------

		// Create an Evaluator instance
		EvaluatorVisitor evaluator = new EvaluatorVisitor();
		// Use Evaluator to process the parse tree
		evaluator.visitCompilationUnit(cUnit);


		// ----------------------Code for task 2----------------------------

		// Create a new file to stock the generated java code.
		File file = new File(source);

		// Check if the test file exist or not
		if (!file.exists()) {
			System.out.println("File not found: " + source);
			return;
		}

		// Generate the file
		if (cUnit != null) {
			Generator generator = new Generator();
			generator.generateJavaCode(cUnit, "Gen"+testFileName0);
			System.out.println("Java code generated successfully.");
		} else {
			System.out.println("Failed to parse the source file.");
		}

		// ----------------------Code for task 3----------------------------

		//print a list of objects matching the present assignment instructions
		CollectionVarVisitor collectionVarVisitor = new CollectionVarVisitor();
		collectionVarVisitor.visitBlock(cUnit.getBlock());
		for (AssignObject obj : collectionVarVisitor.getAssignObjects()) {
			System.out.println(obj);
		}
	}
}
