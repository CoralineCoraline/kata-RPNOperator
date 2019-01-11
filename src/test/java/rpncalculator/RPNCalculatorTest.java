package rpncalculator;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class RPNCalculatorTest {
    @Test
    public void should_return_1_when_input_is_1(){
        // Given
        String input = "1";
        int expectedResult = 1;
        // When
        int result = RPNCalculator.calculate(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
    @Test
    public void should_return_6_when_input_is_6(){
        // Given
        String input = "6";
        int expectedResult = 6;
        // When
        int result = RPNCalculator.calculate(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
    @Test
    public void should_return_61_when_input_is_61(){
        // Given
        String input = "61";
        int expectedResult = 61;
        // When
        int result = RPNCalculator.calculate(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_6_when_input_is_3_3_plus(){
        // Given
        String input = "3 3 +";
        int expectedResult = 6;
        // When
        int result = RPNCalculator.calculate(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_22_when_input_is_20_2_plus(){
        // Given
        String input = "20 2 +";
        int expectedResult = 22;
        // When
        int result = RPNCalculator.calculate(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_9_when_input_is_3_3_mul(){
        // Given
        String input = "3 3 *";
        int expectedResult = 9;
        // When
        int result = RPNCalculator.calculate(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_4_when_input_is_8_4_minus(){
        // Given
        String input = "8 4 -";
        int expectedResult = 4;
        // When
        int result = RPNCalculator.calculate(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    public void should_return_4_when_input_is_8_2_div(){
        // Given
        String input = "8 2 /";
        int expectedResult = 4;
        // When
        int result = RPNCalculator.calculate(input);
        // Then
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }
}
