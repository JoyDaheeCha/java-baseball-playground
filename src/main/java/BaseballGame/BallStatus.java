package BaseballGame;

public enum BallStatus {
    STRIKE, BALL, NOTHING;

    public boolean isNotNothing(){
        return this != NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBALL() {
        return this == BALL;
    }
}
