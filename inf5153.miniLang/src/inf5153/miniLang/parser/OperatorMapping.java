package inf5153.miniLang.parser;

        import inf5153.miniLang.ast.Operator;

        import java.util.HashMap;
        import java.util.Map;

public class OperatorMapping {

    private static final Map<Operator, String> operatorMap = new HashMap<>();

    static {
        operatorMap.put(Operator.PLUS, "+");
        operatorMap.put(Operator.MINUS, "-");
        operatorMap.put(Operator.MULT, "*");
        operatorMap.put(Operator.DIV, "/");
        operatorMap.put(Operator.EQUAL, "==");
        operatorMap.put(Operator.DIFF, "!=");
    }

    public static String getJavaOperator(Operator operator) {
        return operatorMap.get(operator);
    }
}