package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

/* 학습 테스트 실습 */
public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /* 요구 사항 1 */
    @Test
    void splitOneAndTwo() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1","2");
    }

    @Test
    void splitOne() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    /* 요구 사항 2 */
    @Test
    void substring() {
        String actual = "(1,2)".substring(1,4);
        assertThat(actual).isEqualTo("1,2");
    }

    /* 요구 사항 3 */
    @Test
    @DisplayName("charAt 함수 테스트")
    void charAt() {
        char actual = "abc".charAt(1);
        assertThat(actual).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt 함수의 인덱스예외처리 테스")
    void charAtIndexOutOfBoundTest() {
        try {
            char actual = "abc".charAt(3);
            fail("IndexOutOfBoundsException expected because actual has only 3 elements");
        }catch(IndexOutOfBoundsException e) {
            assertThat(e).hasMessage("String index out of range: 3");
        }
    }

}
