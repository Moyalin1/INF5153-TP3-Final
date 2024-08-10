package inf5153.miniLang.parser;

import inf5153.miniLang.ast.*;
import java.io.FileWriter;
import java.io.IOException;

public class Generator {

    // Create the visitor
    GeneratorVisitor visitor = new GeneratorVisitor();

    // Generate package and class declaration
    StringBuilder javaCodeHeader = new StringBuilder();

    // Create the remaining code in the form of a java file
    StringBuilder javaCode = new StringBuilder();

    // Create the attributes part in java file
    StringBuilder javaCodeDefinitionVar = new StringBuilder();



    // This function is used to generate code in java file
    public void generateJavaCode(CompilationUnit cUnit, String outputFileName) {

        javaCodeHeader.append("package inf5153.miniLang.javaGeneration;\n");

        javaCodeHeader.append("public class ").append(outputFileName).append(" {\n");
        javaCodeHeader.append("    public static void main(String[] args) {\n");

        // Visit the AST to generate the main method code
        visitor.visitBlock(cUnit.getBlock());

        // Append the generated code from the visitor
        javaCode.append(visitor.getGeneratedCode());

        // Close the main method and class
        javaCode.append("    }\n");
        javaCode.append("}\n");

        javaCodeDefinitionVar.append(visitor.getGeneratedCodeVarDef());

        // Write the generated code to a file
        String currentDir = System.getProperty("user.dir");
        String outputFilePath = currentDir + "/inf5153.miniLang/src/inf5153/miniLang/javaGeneration/" + outputFileName + ".java";

        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.write(javaCodeHeader.toString());
            writer.write(javaCodeDefinitionVar.toString() + "\n");
            writer.write(javaCode.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
