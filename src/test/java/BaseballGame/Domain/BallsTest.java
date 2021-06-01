package BaseballGame.Domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallsTest {
    @Test
    void Balls_balls은_3자리의_정수() {
        assertThatCode(() -> new Balls(123)).doesNotThrowAnyException();
        assertThatThrownBy(() -> new Balls(12)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Balls(1234)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void Balls_balls의_각_자리는_다른_숫자다() {
        assertThatCode(() -> new Balls(123)).doesNotThrowAnyException();
        assertThatThrownBy(() -> new Balls(112)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Balls(121)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void Balls_두_balls는_같다() {
        assertThat(new Balls(123)).isEqualTo(new Balls(123));
        assertThat(new Balls(123)).isNotEqualTo(new Balls(321));
    }

    @Test
    void Balls_컴퓨터의_답안_기준으로_사용자_입력_수에_대해_STRIKE_BALL_NOTHING_중_하나_고른다() {
        assertThat(new Balls(123).play(new Ball(1,1))).isEqualTo(BallStatus.STRIKE);
        assertThat(new Balls(123).play(new Ball(2,1))).isEqualTo(BallStatus.BALL);
        assertThat(new Balls(123).play(new Ball(1,9))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void Balls_playResult_SRIKE_BALL_NOTHING_반환_테스트() {
        assertThat(new Balls(123).play(new Balls(123)).getStrike()).isEqualTo(3);

        assertThat(new Balls(123).play(new Balls(135)).getStrike()).isEqualTo(1);
        assertThat(new Balls(123).play(new Balls(135)).getBall()).isEqualTo(1);

        assertThat(new Balls(123).play(new Balls(789)).getStrike()).isEqualTo(0);
        assertThat(new Balls(123).play(new Balls(789)).getBall()).isEqualTo(0);

    }
}
