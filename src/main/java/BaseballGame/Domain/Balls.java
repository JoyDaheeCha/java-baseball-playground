package BaseballGame.Domain;

import java.util.*;

public class Balls {

    List<Ball> balls = new ArrayList<>();

    public Balls(int num) {
        isValid(num);
        setBalls(num);
    }

    private void setBalls(int num) {
        //TODO 자리수 나누는 법 리팩토링 필요
        int i = 3;
        while(num>0){
            balls.add(new Ball(i, num%10));
            num=num/10;
            i--;
        }
        Collections.reverse(balls);
    }

    private void isValid(int num) {
        if(!isThreeDigitNum(num)) {
            throw new IllegalArgumentException();
        }
        if(!isEachDigitUnique(num)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isEachDigitUnique(int num) {
        HashSet<Integer> digits = new HashSet<>();
        while(num>0){
            digits.add(num%10);
            num=num/10;
        }
        return digits.size() == 3;
    }

    private boolean isThreeDigitNum(int num) {
        return String.valueOf(num).length() == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }

    public BallStatus play(Ball userBall) {
       return  this.balls.stream()
                    .map(answer->answer.play(userBall))
                    .filter(BallStatus::isNotNothing)
                    .findFirst()
                    .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(Balls userBalls) {
        PlayResult playResult= new PlayResult();
        for (Ball answer: balls) {
            BallStatus status = userBalls.play(answer);
            playResult.report(status);
        }
        return playResult;
    }
}
