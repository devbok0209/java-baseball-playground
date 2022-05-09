package study;

import baseball.Hint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class HintTest {

    @ParameterizedTest
    @DisplayName("반드시 볼 힌트를 줘야하는 테스트")
    @CsvSource(value = {"1:1", "1:2", "1:3", "1:4", "2:1", "2:2", "2:3", "2:4"}, delimiter = ':')
    void shouldHaveBallHint(int strikeCount, int bollCount) {
        Hint hint = new Hint();
        hint.createBallHint(strikeCount, bollCount);

        assertTrue(hint.getHintValue().contains("볼"));
    }

    @ParameterizedTest
    @DisplayName("반드시 스트라이크 힌트를 줘야하는 테스트")
    @ValueSource(ints = {1, 2, 3})
    void shouldHaveStrikeHint(int strikeCount) {
        Hint hint = new Hint();
        hint.createStrikeHint(strikeCount);

        assertTrue(hint.getHintValue().contains("스트라이크"));
    }


}
