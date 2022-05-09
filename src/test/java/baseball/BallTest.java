package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BallTest {

    private Ball computerBall;

    @BeforeEach
    void setUp() {
         computerBall = new Ball(1, 4);
    }

    @Test
    @DisplayName("1~9 사이 값은 exception을 던지지 않는다.")
    void shouldNotThrowException() {
        assertThatCode(() -> new Ball(1, 9)).doesNotThrowAnyException();
        assertThatCode(() -> new Ball(1, 1)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("1~9 이외의 값은 exception을 던진다.")
    void shouldThrowException() {
        assertThatThrownBy(() -> new Ball(1, 10))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("볼의 숫자는 0~9 까지 입력해야 합니다");
        assertThatThrownBy(() -> new Ball(1, 0))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("볼의 숫자는 0~9 까지 입력해야 합니다");
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
