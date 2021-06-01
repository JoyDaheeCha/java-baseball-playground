package BaseballGame.Domain;

import java.util.Objects;

public class Ball {

    private static final int MIN_BALL_NUM = 1;
    private static final int MAX_BALL_NUM = 9;
    private final int ballNumber;
    private final int position;

    public Ball(int position, int num) {
        isValid(num);
        this.ballNumber = num;
        this.position = position;
    }

    private void isValid(int num) {
        if(num < MIN_BALL_NUM || num > MAX_BALL_NUM) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return ballNumber == ball.ballNumber && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber, position);
    }

    public BallStatus play(Ball ball) {
        if(this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if(ball.matchBallNo(ballNumber)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    public boolean matchBallNo(int ballNo) {
        return this.ballNumber == ballNo;
    }

}
