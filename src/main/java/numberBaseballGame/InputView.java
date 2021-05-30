package numberBaseballGame;

import java.util.Scanner;

public class InputView {

    Scanner sc = new Scanner(System.in);

    String getInputNumber(){
        System.out.println("숫자를 입력해주세요: ");
        return sc.nextLine();
    }

    String getGameMode(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return sc.nextLine();
    }
}
