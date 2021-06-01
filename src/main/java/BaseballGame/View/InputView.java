package BaseballGame.View;

import java.util.Scanner;

public class InputView {

    Scanner sc;

    public InputView() {
         sc = new Scanner(System.in);
    }

    public int getInput() {
        System.out.println("숫자를 입력해주세요: ");
        return sc.nextInt();
    }

    public boolean doesUserWantToContinueGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        if(sc.nextInt() == 1){
            return true;
        }
        return false;
    }

}
