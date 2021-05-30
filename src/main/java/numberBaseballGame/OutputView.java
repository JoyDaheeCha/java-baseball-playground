package numberBaseballGame;

public class OutputView {

    // 입력값이 정답일 때
    void print3StrikeComment() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    // 입력 값과 정답의 일치율
    void printInputEvalComment(int strikeCnt, int ballCnt) {
        if (strikeCnt > 0 && ballCnt > 0) {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
            return;
        }

        if (ballCnt > 0 ) {
            System.out.println(ballCnt + "볼");
            return;
        }

        if (strikeCnt > 0 ) {
            System.out.println(strikeCnt + "스트라이크");
            return;
        }

        System.out.println("낫싱");
    }
}
