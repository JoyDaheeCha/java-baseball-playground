package BaseballGame.Domain;

public class PlayResult {
    private int strike = 0;
    private int ball = 0;

    public boolean is3Strike() {
        return this.strike == 3;
    }


    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void report(BallStatus status) {
        if(status.isStrike()) {
            strike++;
            return;
        }
        if(status.isBall()) {
            ball++;
            return;
        }
    }
}
