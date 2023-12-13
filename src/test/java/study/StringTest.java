package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("String 관련 메소드에 대한 UnitTest")
public class StringTest {
    @Test
    @DisplayName("replace 메소드를 사용하여 타겟과 대체하려는 문자열에 대한 정확한 변환이 일어나는지 확인")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split 메소드를 사용하여 selector 기준으로 Collection 에 요구한 단위에 맞게 분리되어 들어가는지 확인")
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");

        actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("substring 메소드를 사용하여 beginIndex 와 endIndex 로 원하는 만큼만 문자열이 나오는지 확인")
    void substring() {
        String bracketString = "(1,2)";
        String actual = bracketString.substring(1, bracketString.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메소드를 사용하여 인덱스에 대한 문자를 출력하고 해당 인덱스가 존재하지 않는 경우 StringIndexOutOfBoundsException 예외가 발생하는지 확인")
    void charAt() {
        String abc = "abc";
        assertThat(abc.charAt(0)).isEqualTo('a');
        assertThat(abc.charAt(1)).isEqualTo('b');
        assertThat(abc.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> abc.charAt(3))
                .withMessage("String index out of range: " + 3);
    }
}
