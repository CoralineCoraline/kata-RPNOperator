package rpncalculator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.BiFunction;

public class RPNCalculator {

    // 3 5 8 *
    //  3 5 8 + -> 3 11
    // 7 +
    //  3 11 7 + -> 3 18
    // *
    // 3 18 * - > 141
    public int compute(String input) throws RPNOperationSyntaxException {
        String[] operationTokens = input.split(" ");

        Deque<String> stack = new ArrayDeque<>();

        for(String token : operationTokens) {
            if (isOperande(token)) {
                stack.addLast(token);
            } else {
                if (stack.size() < 2) {
                    throw new RPNOperationSyntaxException("Bad operande");
                }
                Integer operande2 = getOperande(stack.pollLast());
                Integer operande1 = getOperande(stack.pollLast());
                Operator operator = Operator.of(token);
                stack.addLast(operator.compute(operande1, operande2).toString());
            }
        }
        return getOperande(stack.pollLast());
    }

    private boolean isOperande(String token) {
        try {
            Integer.valueOf(token);
        } catch(NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private Integer getOperande(String token) throws RPNOperationSyntaxException {
        try {
            return Integer.valueOf(token);
        } catch(NumberFormatException nfe) {
            throw new RPNOperationSyntaxException("Bad operande");
        }
    }

    private enum Operator {
        PLUS("+", (a, b) -> a + b),
        MULTIPLY("*", (a, b) -> a * b),
        DIVIDE("/", (a, b) -> a / b),
        MINUS("-", (a, b) -> a - b);

        private final String value;
        private final BiFunction<Integer, Integer, Integer> operation;

        Operator(String value, BiFunction<Integer, Integer, Integer> operation) {
            this.value = value;
            this.operation = operation;
        }

        public static Operator of(String operationToken) throws RPNOperationSyntaxException {
            return Arrays.stream(values())
                    .filter(operator -> operationToken.equals(operator.value))
                    .findFirst()
                    .orElseThrow(() -> new RPNOperationSyntaxException("Wrong operator"));
        }

        public Integer compute(Integer operande1, Integer operande2) {
            return operation.apply(operande1, operande2);
        }
    }
}
