package baseball;

public class Hint {

    private String hintValue = "";

    public String getHintValue() {
        return hintValue;
    }

    public void createNothingHint() {
        if (hintValue.equals("")) {
            hintValue = "낫싱";
        }
    }

    public void createBallHint(int strikeCount, int bollCount) {
        if (strikeCount != 3 && bollCount > 0) {
            hintValue += bollCount + "볼";
        }
    }

    public void createStrikeHint(int strikeCount) {
        if (strikeCount > 0) {
            hintValue += strikeCount + "스트라이크";
        }
    }
    public void hintValueClear() {
        hintValue = "";
    }
}
