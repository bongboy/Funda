package interpretor;

import java.util.Stack;

public class InterpretorGOF {

    public static boolean isOperator(String operator) {
        switch (operator) {
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            default:
                return false;
        }
    }

    public static Expression getOperator(String s, Expression left, Expression right) {
        switch (s) {
            case "+":
                return new Add(left, right);
            case "-":
                return new Subtract(left, right);
            case "*":
                return new Product(left, right);
            default:
                return null;
        }
    }

    public static int evaluate(String expression) {
        Stack<Expression> stack = new Stack<>();

        for (String s : expression.split(" ")) {
            if (isOperator(s)) {
                Expression right = stack.pop();
                Expression left = stack.pop();

                stack.push(getOperator(s, left, right));
            } else {
                stack.push(new Number(Integer
                        .parseInt(s)));
            }
        }

        return stack.pop().interpretor();
    }

    public static void main(String[] args) {
        String expression = "7 3 - 2 1 + *";
        System.out.println(evaluate(expression));
    }

    public interface Expression {
        int interpretor();
    }

    public static class Add implements Expression {

        private final Expression leftExpression;
        private final Expression righExpression;

        public Add(Expression leftExpression, Expression rightExpression) {
            this.leftExpression = leftExpression;
            this.righExpression = rightExpression;
        }

        @Override
        public int interpretor() {
            return leftExpression.interpretor() + righExpression.interpretor();
        }
    }

    public static class Subtract implements Expression {

        private final Expression leftExpression;
        private final Expression righExpression;

        public Subtract(Expression leftExpression, Expression rightExpression) {
            this.leftExpression = leftExpression;
            this.righExpression = rightExpression;
        }

        @Override
        public int interpretor() {
            return leftExpression.interpretor() - righExpression.interpretor();
        }
    }

    public static class Product implements Expression {

        private final Expression leftExpression;
        private final Expression righExpression;

        public Product(Expression leftExpression, Expression rightExpression) {
            this.leftExpression = leftExpression;
            this.righExpression = rightExpression;
        }

        @Override
        public int interpretor() {
            return leftExpression.interpretor() * righExpression.interpretor();
        }
    }

    public static class Number implements Expression {

        private final int number;

        public Number(int number) {
            this.number = number;
        }

        @Override
        public int interpretor() {
            return number;
        }
    }
}
