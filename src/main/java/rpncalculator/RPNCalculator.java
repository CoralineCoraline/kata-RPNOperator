package rpncalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public class RPNCalculator {
    public static int calculate(String input) {
        if (input.contains(" ")) {
            String[] operandes = input.split(" ");
            int operande1 = Integer.parseInt(operandes[0]);
            int operande2 = Integer.parseInt(operandes[1]);

            Operation operation = Operation.of(operandes[2]);
            return operation.calculate(operande1, operande2);
        }
        return Integer.parseInt(input);
    }

    private enum Operation {
        ADD("+", (a, b) -> a + b),
        SUB("-", (a, b) -> a - b),
        DIV("/", (a, b) -> a / b),
        MUL("*", (a, b) -> a * b);

        private BiFunction<Integer, Integer, Integer> operation;

        Operation(String operator, BiFunction<Integer, Integer, Integer> operation) {
            this.operation = operation;
            this.operator = operator;
        }

        private String operator;

        public static Operation of(String operator) {
            return Arrays.stream(values())
                    .filter(operation -> operation.operator.equals(operator))
                    .findFirst()
                    .get();
        }

        public int calculate(int operande1, int operande2) {
            return this.operation.apply(operande1, operande2);
        }
    }
}
