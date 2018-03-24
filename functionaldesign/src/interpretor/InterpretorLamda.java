package interpretor;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.IntBinaryOperator;

public class InterpretorLamda {

    private static Map<String, IntBinaryOperator> map = new HashMap<>();

    static {
        map.put("+", (a, b) -> a + b);
        map.put("-", (a, b) -> a - b);
        map.put("*", (a, b) -> a * b);
    }

    public static int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (String s : expression.split(" ")) {

            IntBinaryOperator operator = map.get(s);
            if (operator != null) {
                Integer right = stack.pop();
                Integer left = stack.pop();

                stack.push(operator.applyAsInt(left, right));
            } else {
                stack.push(new Integer(s));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "7 3 - 2 1 + *";
        System.out.println(evaluate(expression));
    }
}
