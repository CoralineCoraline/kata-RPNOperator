package rpncalculator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RPNCalculatorTest {

    @Test
    public void shouldReturn1when1IsGiven() throws RPNOperationSyntaxException {
        RPNCalculator rpnCalculator = new RPNCalculator();
        int result = rpnCalculator.compute("1");
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void shouldReturn2when2IsGiven() throws RPNOperationSyntaxException {
        RPNCalculator rpnCalculator = new RPNCalculator();
        int result = rpnCalculator.compute("2");
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test
    public void shouldComputeAddition() throws RPNOperationSyntaxException {
        RPNCalculator rpnCalculator = new RPNCalculator();
        int result = rpnCalculator.compute("1 1 +");
        Assertions.assertThat(result).isEqualTo(2);
    }

    @Test(expected = RPNOperationSyntaxException.class)
    public void shouldNotComputeOperationWithIncorrectSyntax() throws RPNOperationSyntaxException {
        RPNCalculator rpnCalculator = new RPNCalculator();
        int result = rpnCalculator.compute("1 + 1");
    }

    @Test
    public void shouldComputeSubstraction() throws RPNOperationSyntaxException {
        RPNCalculator rpnCalculator = new RPNCalculator();
        int result = rpnCalculator.compute("1 1 -");
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    public void shouldComputeMultipliction() throws RPNOperationSyntaxException {
        RPNCalculator rpnCalculator = new RPNCalculator();
        int result = rpnCalculator.compute("6 10 *");
        Assertions.assertThat(result).isEqualTo(60);
    }

    @Test
    public void shouldComputeDivision() throws RPNOperationSyntaxException {
        RPNCalculator rpnCalculator = new RPNCalculator();
        int result = rpnCalculator.compute("60 10 /");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldNotComputeDivisionBy0() throws RPNOperationSyntaxException {
        RPNCalculator rpnCalculator = new RPNCalculator();
        int result = rpnCalculator.compute("60 0 /");
    }

    @Test
    public void shouldComputeOperationWhenMoreThanOneOperator() throws RPNOperationSyntaxException {
        RPNCalculator rpnCalculator = new RPNCalculator();
        int result = rpnCalculator.compute("4 2 + 3 -");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    public void shouldComputeComplexOperationWithSuccesiveOperator() throws RPNOperationSyntaxException {
        RPNCalculator rpnCalculator = new RPNCalculator();
        int result = rpnCalculator.compute("3 5 8 * 7 + *");
        Assertions.assertThat(result).isEqualTo(141);
    }
}
