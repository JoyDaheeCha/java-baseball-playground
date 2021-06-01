package BaseballGame.Domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {
    @Test
    void Ball_ball은_1에서_9사이의_정수() {
        assertThatCode(() -> new Ball(1, 1)).doesNotThrowAnyException();
        assertThatCode(() -> new Ball(1, 9)).doesNotThrowAnyException();
        assertThatThrownBy(() -> new Ball(1, 0)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Ball(1, 10)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void Ball_두_ball은_같다() {
        assertThat(new Ball(1, 1)).isEqualTo(new Ball(1, 1));
        assertThat(new Ball(1, 1)).isNotEqualTo(new Ball(1, 2));
    }

    @Test
    void Ball_스트라이크_볼_낫싱_테스트() {
        assertThat(new Ball(1,1).play(new Ball(1,1))).isEqualTo(BallStatus.STRIKE);
        assertThat(new Ball(1,1).play(new Ball(2,1))).isEqualTo(BallStatus.BALL);
        assertThat(new Ball(1,1).play(new Ball(1,3))).isEqualTo(BallStatus.NOTHING);
    }

}
