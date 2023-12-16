package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Set 관련 메소드에 대한 UnitTest")
public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("contains 메소드를 ParameterizedTest 를 이용하여 각 Number 포함여부 검증")
    void contains_shouldReturnTrueForNumberSet(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("contains 메소드를 ParameterizedTest 와 함께 CsvSource 의 값,결과 배열 기준으로 각 Number 별 포함/불포함여부 검증")
    public void contains_shouldReturnTrueForNumberSetWithBoolean(int number, boolean contains) {
        assertThat(numbers.contains(number)).isEqualTo(contains);
    }
}
