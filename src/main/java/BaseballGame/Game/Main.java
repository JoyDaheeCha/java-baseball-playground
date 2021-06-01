package BaseballGame.Game;

import BaseballGame.Domain.Balls;
import BaseballGame.Domain.PlayResult;
import BaseballGame.Utils.RandomNumberGenerator;
import BaseballGame.View.InputView;
import BaseballGame.View.OutputView;

import java.util.HashSet;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        InputView iv = new InputView();
        do{
            playGame();
        }while(iv.doesUserWantToContinueGame());
    }

    private static void playGame() {
        InputView iv = new InputView();
        OutputView ov = new OutputView();

        Balls answers = new Balls(new RandomNumberGenerator().getRandomNumber());

        PlayResult playResult = new PlayResult();
        while (!playResult.is3Strike()){
            Balls guess = new Balls(iv.getInput());
            playResult = answers.play(guess);
            ov.showAnswerResult(playResult.getBall(), playResult.getStrike());
        }
        ov.noticeGameOver();
    }

}
