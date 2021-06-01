package BaseballGame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

}
