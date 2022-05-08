package baseball.game;

import baseball.Hint;
import baseball.view.InputView;

import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class BaseBall {

    private final Scanner scanner = new Scanner(System.in);
    private final Hint hint = new Hint();

    public void playGame() {
        String answer = createAnswer();
        System.out.println(answer);
        checkAnswer(answer);
    }

    private void checkAnswer(String answer) {
        while (true) {
            System.out.print("숫자를 입력해 주세요 : ");
            String result = scanner.nextLine();
            int strikeCount = 0;
            int bollCount = 0;

            for (int i = 0; i < 3 ; i++) {
                String resultValue = String.valueOf(result.charAt(i));
                String answerValue = String.valueOf(answer.charAt(i));

                if (isStrike(resultValue, answerValue)) {
                    strikeCount++;
                }

                if (!isStrike(resultValue, answerValue) && isBall(answer, resultValue)) {
                    bollCount++;
                }
            }

            hint.createStrikeHint(strikeCount);
            hint.createBallHint(strikeCount, bollCount);
            hint.createNothingHint();
            System.out.println(hint.getHintValue());

            if (isCorrect(answer, result)) {
                return;
            }
        }
    }

    private boolean isCorrect(String answer, String result) {
        if(result.equals(answer)) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            hint.hintValueClear();
            return true;
        }
        return false;
    }

    private boolean isBall(String answer, String resultValue) {
        return answer.contains(resultValue);
    }

    private boolean isStrike(String resultValue, String answerValue) {
        return resultValue.equals(answerValue);
    }

    private String createAnswer() {
        int max = 1000;
        int min = 100;
        final Random random = new SecureRandom();
        return String.valueOf(random.nextInt(max - min) + min);
    }


    public void replay() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int replayAnswer = scanner.nextInt();
        scanner.nextLine();
        if (replayAnswer == 1) {
            new InputView().startGame();
        }
    }
}
