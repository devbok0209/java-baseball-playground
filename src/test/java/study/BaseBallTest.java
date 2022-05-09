package study;

import baseball.game.BaseBall;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BaseBallTest {

    @ParameterizedTest(name = "3STRIKE {index}: ANSWER : {0} : COM : {1}")
    @DisplayName("숫자를 맞췄을때 힌트가 없어야하는 테스트")
    @CsvSource(value = {"123:123", "234:234", "455:455", "657:657"}, delimiter = ':')
    void shouldNotExistHint(String answer, String result) {
        BaseBall baseBall = new BaseBall();

        assertTrue(baseBall.isCorrect(answer, result));
    }

    @ParameterizedTest
    @DisplayName("숫자열에 포함된 숫자가 있으면 true 반환")
    @CsvSource(value = {"123:1", "123:2", "123:3", "456:4", "456:5", "456:6", "765:5", "765:6", "765:7"}, delimiter = ':')
    void shouldTrueIsBall(String answer, String resultValue) {
        BaseBall baseBall = new BaseBall();

        assertTrue(baseBall.isBall(answer, resultValue));
    }

    @ParameterizedTest
    @DisplayName("값이 일치하면 스트라이크 이므로 true 반환")
    @CsvSource(value = {"1:1", "3:3", "2:2", "4:4", "7:7", "5:5", "6:6", "8:8", "9:9"}, delimiter = ':')
    void shouldTrueIsStrike(String resultValue, String answerValue) {
        BaseBall baseBall = new BaseBall();

        assertTrue(baseBall.isBall(answerValue, resultValue));
    }

    @Test
    @DisplayName("반드시 세자리 수에 해당하는 테스트")
    void shouldThreeLengthTest() {
        for (int i = 0; i < 100; i++) {
            assertEquals(3, new BaseBall().createAnswer().length());
        }
    }

}
