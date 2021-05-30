package numberBaseballGame;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberBaseballGameTest {

    private NumberBaseballGame numBasGm;

    @BeforeEach
    void setUp() {
        numBasGm = new NumberBaseballGame("713");
    }

    @Test
    @DisplayName("3스트라이크 테스트 1")
    void is3Strike1(){
        boolean actual = numBasGm.checkThreeStrike("713", "713");
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("1볼 1스트라이크 테스트")
    void oneBallOneStrikeTest(){
        HashMap<String, Integer> actual = numBasGm.setStrikeAndBallCntForWholeNum("123", "713");
        assertThat(actual.get("ballCnt")).isEqualTo(1);
        assertThat(actual.get("strikeCnt")).isEqualTo(1);
    }

    @Test
    @DisplayName("1볼 0스트라이크 테스트")
    void oneBallZeroStrikeTest(){
        HashMap<String, Integer> actual = numBasGm.setStrikeAndBallCntForWholeNum("145", "713");
        assertThat(actual.get("ballCnt")).isEqualTo(1);
        assertThat(actual.get("strikeCnt")).isEqualTo(0);
    }

    @Test
    @DisplayName("2볼 0스트라이크 테스트")
    void twoBallZeroStrikeTest(){
        HashMap<String, Integer> actual = numBasGm.setStrikeAndBallCntForWholeNum("671", "713");
        assertThat(actual.get("ballCnt")).isEqualTo(2);
        assertThat(actual.get("strikeCnt")).isEqualTo(0);
    }

    @Test
    @DisplayName("0볼 1스트라이크 테스트")
    void zeroBallOneStrikeTest(){
        HashMap<String, Integer> actual = numBasGm.setStrikeAndBallCntForWholeNum("216", "713");
        assertThat(actual.get("ballCnt")).isEqualTo(0);
        assertThat(actual.get("strikeCnt")).isEqualTo(1);
    }


}
