package BaseballGame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class BallTest {
    @Test
    void Ball_ball은_1에서_9사이의_정수() {
        assertThatCode(() -> new Ball(1)).doesNotThrowAnyException();
        assertThatCode(() -> new Ball(9)).doesNotThrowAnyException();
        assertThatThrownBy(() -> new Ball(0)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Ball(10)).isInstanceOf(RuntimeException.class);
    }
}
