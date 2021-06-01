package BaseballGame;

public class Ball {

    private static final int MIN_BALL_NUM = 1;
    private static final int MAX_BALL_NUM = 9;
    private final int ballNumber;

    public Ball(int num) {
        isValid(num);
        ballNumber = num;
    }

    private void isValid(int num) {
        if(num < MIN_BALL_NUM || num > MAX_BALL_NUM) {
            throw new IllegalArgumentException();
        }
    }
}
