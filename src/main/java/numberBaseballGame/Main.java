package numberBaseballGame;

public class Main {

    public static void main (String[] args) {

        NumberBaseballGame bGame = new NumberBaseballGame();
        InputView iv = new InputView();

        String gameMode = "1"; // 1인 경우 게임 진행, 2인 경우 게임 종료

        while (gameMode.equals("1")) {

            String inputVal = iv.getInputNumber();
            bGame.evalAnswerResult(inputVal);

            gameMode = iv.getGameMode();
        }
    }

}
