package baseball;

public class Ball {

    private final int place;
    private final int number;

    public Ball(int place, int number) {
        this.place = place;
        this.number = new BallNumber(number).getNumber();
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (ball.matchBall(number)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    private boolean matchBall(int number) {
        return this.number == number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ball ball = (Ball) o;

        if (place != ball.place) return false;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        int result = place;
        result = 31 * result + number;
        return result;
    }
}
