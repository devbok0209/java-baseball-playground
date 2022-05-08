package baseball.view;

import baseball.game.BaseBall;


public class InputView {
    public void startGame() {
        BaseBall baseBall = new BaseBall();
        baseBall.playGame();
        baseBall.replay();
    }
}
