package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BallsTest {

    @Test
    @DisplayName("게임 스트라이크 테스트")
    void playStrikeTest() {
        Balls balls = new Balls(Arrays.asList(1,2,3));
        PlayResult playResult = balls.play(Arrays.asList(1,2,3));
        assertEquals(3, playResult.getStrike());
        assertEquals(0, playResult.getBall());
    }

    @Test
    @DisplayName("게임 볼 테스트")
    void playBallTest() {
        Balls balls = new Balls(Arrays.asList(1,2,3));
        PlayResult playResult = balls.play(Arrays.asList(3,1,2));
        assertEquals(0, playResult.getStrike());
        assertEquals(3, playResult.getBall());
    }



    @Test
    @DisplayName("낫싱 테스트")
    void shouldNothingTest() {
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallStatus ballStatus = answers.play(new Ball(1, 4));
        assertEquals(BallStatus.NOTHING, ballStatus);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void shouldStrikeTest() {
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallStatus ballStatus = answers.play(new Ball(1, 1));
        assertEquals(BallStatus.STRIKE, ballStatus);
    }

    @Test
    @DisplayName("볼 테스트")
    void shouldBallTest() {
        Balls answers = new Balls(Arrays.asList(1,2,3));
        BallStatus ballStatus = answers.play(new Ball(1, 3));
        assertEquals(BallStatus.BALL, ballStatus);
    }
}
