package study;


import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @DisplayName("홀수 번째 값이 기호가 맞는지 테스트")
    @ValueSource(strings = {"2 * 3 / 2 + 1", "2 * 10 + 5 / 5", "5 * 1 + 2 - 2"})
    void shouldSign(String input) {
        Set<String> signs = createSign();
        String[] values = input.split(" ");

        for (int i = 0; i < values.length; i++) {
            if (i % 2 != 0) {
                assertTrue(signs.contains(values[i]));
            }
        }
    }

    private Set<String> createSign() {
        Set<String> signs = new HashSet<>();
        signs.add("+");
        signs.add("-");
        signs.add("/");
        signs.add("*");
        return signs;
    }

    @ParameterizedTest
    @DisplayName("더하기 테스트")
    @CsvSource(value = {"1:2:3", "1:4:5", "44:55:99", "11:22:33"}, delimiter = ':')
    void plusTest(int inputA, int inputB, int result) {
        assertEquals(calculator.plus(inputA, inputB), result);
    }

    @ParameterizedTest
    @DisplayName("빼기 테스트")
    @CsvSource(value = {"1:2:-1", "1:4:-3", "44:55:-11", "11:10:1"}, delimiter = ':')
    void minusTest(int inputA, int inputB, int result) {
        assertEquals(calculator.minus(inputA, inputB), result);
    }

    @ParameterizedTest
    @DisplayName("곱하기 테스트")
    @CsvSource(value = {"1:2:2", "1:4:4", "40:50:2000", "11:10:110"}, delimiter = ':')
    void multiplyTest(int inputA, int inputB, int result) {
        assertEquals(calculator.multiply(inputA, inputB), result);
    }

    @ParameterizedTest
    @DisplayName("나누기 테스트")
    @CsvSource(value = {"1:2:0", "6:2:3", "40:10:4", "10:10:1"}, delimiter = ':')
    void divideTest(int inputA, int inputB, int result) {
        assertEquals(calculator.divide(inputA, inputB), result);
    }

    @ParameterizedTest
    @DisplayName("계산기 테스트")
    @CsvSource(value = {"2 * 3 / 2 + 1 :4", "2 * 10 + 5 / 5 :5", "5 * 1 + 2 - 2 :5"}, delimiter = ':')
    void calculateTest(String input, int result) {
        assertEquals(calculator.calculate(input), result);
    }
}
