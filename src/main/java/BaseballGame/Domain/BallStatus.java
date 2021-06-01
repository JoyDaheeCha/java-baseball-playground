package BaseballGame.Domain;

public enum BallStatus {
    STRIKE, BALL, NOTHING;

    public boolean isNotNothing(){
        return this != NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isNothing() {
        return this == NOTHING;
    }
}
