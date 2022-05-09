package baseball;

public class BallNumber {
    public static final int MIN = 1;
    public static final int MAX = 9;
    private int ballNumber;

    public BallNumber(int number)  {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("볼의 숫자는 0~9 까지 입력해야 합니다");
        }
        this.ballNumber = number;
    }

    public int getNumber() {
        return ballNumber;
    }
}
