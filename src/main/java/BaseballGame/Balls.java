package BaseballGame;

import java.util.*;
import java.util.stream.IntStream;

public class Balls {

    List<Ball> balls = new ArrayList<>();

    public Balls(int num) {
        isValid(num);
        setBalls(num);
    }

    private void setBalls(int num) {
        while(num>0){
            balls.add(new Ball(num%10));
            num=num/10;
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
}
