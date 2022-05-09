package baseball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> answers) {
        this.balls = createBalls(answers);
    }

    private List<Ball> createBalls(List<Integer> asList) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            balls.add(new Ball(i + 1, asList.get(i)));
        }
        return balls;
    }


    public PlayResult play(List<Integer> asList) {
        Balls userBalls = new Balls(asList);
        PlayResult playResult = new PlayResult();
        for (Ball ball : balls) {
            playResult.report(userBalls.play(ball));
        }
        return playResult;
    }

    public BallStatus play(Ball ball) {
        return balls.stream()
                .map(answer -> answer.play(ball))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

}
