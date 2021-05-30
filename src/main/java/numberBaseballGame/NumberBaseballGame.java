package numberBaseballGame;

import java.util.HashMap;

public class NumberBaseballGame {

    private String answer = "";
    OutputView ov = new OutputView();

    NumberBaseballGame() {
        setAnswer();
    }

    NumberBaseballGame(String answer) {
        this.answer = answer;
    }

    private void setAnswer() {
        double dValue = Math.random();
        answer = Integer.toString((int)(dValue * 1000));
    }

    void evalAnswerResult(String inputVal) {

        // 1. 3 스트라이크일 경우
        if (checkThreeStrike(inputVal, answer)) {
            return;
        }

        // 2. 스트라이크 수, 볼 수 확인
        HashMap<String, Integer> resultMap = setStrikeAndBallCntForWholeNum(inputVal, answer);

        ov.printInputEvalComment(resultMap.get("strikeCnt"), resultMap.get("ballCnt"));
    }

    boolean checkThreeStrike(String inputVal, String answer) {
        if (inputVal.equals(answer)) {
            ov.print3StrikeComment();
            return true;
        }
        return false;
    }

    HashMap<String, Integer> setStrikeAndBallCntForWholeNum (String inputVal, String answer) {
        int sCnt = 0; // strikeCnt
        int bCnt = 0; // ballCnt

        for (int i=0; i<3; i++) {

            HashMap<String,Integer> result
                    = setStrikeAndBallCntForDigit(inputVal, answer, i);

            sCnt = sCnt + result.get("strikeCnt");
            bCnt = bCnt + result.get("ballCnt");

        }

        HashMap<String,Integer> map = new HashMap<>();
        map.put("strikeCnt", sCnt);
        map.put("ballCnt", bCnt);

        return map;
    }

    HashMap<String, Integer> setStrikeAndBallCntForDigit (String inputVal, String answer, int idx) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("strikeCnt", 0);
        map.put("ballCnt", 0);

        char inputChar = inputVal.charAt(idx);
        String inputStr = Character.toString(inputChar);

        if (inputChar == answer.charAt(idx)) {
            map.put("strikeCnt", 1);
            return map;
        }

        if (answer.contains(inputStr)) {
            map.put("ballCnt", 1);
            return map;
        }

        return map;
    }
}
