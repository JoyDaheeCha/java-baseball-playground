package BaseballGame.Utils;

import java.util.HashSet;
import java.util.Random;

public class RandomNumberGenerator {
    private int randomNumber;

    public RandomNumberGenerator() {
        HashSet<Integer> digits = new HashSet<>();

        Random random = new Random();
        while(digits.size()!=3){
            digits.add(random.nextInt(10));
        }
        randomNumber = Integer.parseInt(digits.toString().replaceAll("[\\[\\], ]",""));
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
