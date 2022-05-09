package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    private Ball computerBall;

    @BeforeEach
    void setUp() {
         computerBall = new Ball(1, 4);
    }


    @Test
    @DisplayName("0~9 사이의 값만 숫자 생성")
    void shouldGetBetweenZeroToNine() {
        Ball ballNine = new Ball(1,9);
        assertTrue(ballNine.validNumber());
        Ball ballOne = new Ball(1,1);
        assertTrue(ballOne.validNumber());

        Ball ballZero = new Ball(1,0);
        assertFalse(ballZero.validNumber());
        Ball ballTen = new Ball(1,10);
        assertFalse(ballTen.validNumber());
    }

    @Test
    @DisplayName("낫싱 테스트")
    void shouldNothingTest() {
        BallStatus ballStatus = computerBall.play(new Ball(1,2));
        assertEquals(BallStatus.NOTHING, ballStatus);

    }

    @Test
    @DisplayName("볼 테스트")
    void shouldBallTest() {
        BallStatus ballStatus = computerBall.play(new Ball(2,4));
        assertEquals(BallStatus.BALL, ballStatus);

    }

    @Test
    @DisplayName("스트라이크 테스트")
    void shouldStrikeTest() {
        BallStatus ballStatus = computerBall.play(new Ball(1,4));
        assertEquals(BallStatus.STRIKE, ballStatus);

    }

}
