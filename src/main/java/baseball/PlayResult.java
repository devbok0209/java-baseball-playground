package baseball;

public class PlayResult {

    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            this.strike += 1;
        }

        if (ballStatus.isBall()) {
            this.ball += 1;
        }

    }
}
