package inf5153.miniLang.parser;
import java.util.Set;
import java.util.HashSet;
public class AssignObject {

    private String gaucheVariable;
    private Set<String> droiteVariables;

    public AssignObject(String definedVariable) {
        this.gaucheVariable = definedVariable;
        this.droiteVariables = new HashSet<>();
    }

    public String getGaucheVariable() {
        return gaucheVariable;
    }

    public Set<String> getDroiteVariables() {
        return droiteVariables;
    }

    public void addUsedVariable(String variable) {
            droiteVariables.add(variable);
        }


    @Override
    public String toString() {
        return "Variable en écriture: " + getGaucheVariable() + ", Variables en lecture: " + getDroiteVariables();
        }
    }


