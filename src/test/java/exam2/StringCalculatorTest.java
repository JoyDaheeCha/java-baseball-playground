package exam2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("StringCalculator 에 대한 UnitTest")
public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource({
            "1,식에는 ' ' 가 포함되어 있어야 합니다.",
            "2+3,식에는 ' ' 가 포함되어 있어야 합니다.",
            "1+4*4,식에는 ' ' 가 포함되어 있어야 합니다.",
            "1 /,최소 3개 이상의 요소가 필요합니다.",
            "1 * 3 +,요소의 개수가 홀수만 가능합니다. 요소 수: 4",
            "+ 3 -,For input string: \"+\""
    })
    @DisplayName("input 값에 대한 정합성 체크를 확인한다.")
    public void inputStringCheck(String inputString, String exceptionMessage) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> stringCalculator.execute(inputString))
                .withMessage(exceptionMessage);
    }

    @ParameterizedTest
    @CsvSource({"3 + 1,false", "3 - 1,false", "3 * 1,false", "3 / 1,false", "3 % 1,true", "3 ^ 1,true"})
    @DisplayName("사칙연산(+-*/) 외에는 Exception 이 발생하는지 확인한다.")
    public void operatorCheck(String inputString, boolean throwException) {
        if (throwException) {
            assertThatExceptionOfType(NotSupportedOperatorException.class)
                    .isThrownBy(() -> stringCalculator.execute(inputString))
                    .withMessage("사칙연산 외에는 계산할 수 없습니다. 연산자: " + inputString.charAt(2));
            return;
        }

        assertThat(stringCalculator.execute(inputString)).isGreaterThan(0);
    }

    @ParameterizedTest
    @CsvSource({
            "1 + 3,4",
            "1 - 3,-2",
            "1 * 3,3",
            "1 / 3,0.3333333333333333",
            "3 + 4 * 3,21",
            "4 * 3 / 2,6",
            "1 + 2 - 3 * 4 / 2,0",
            "4 * 3 / 2 + 1 - 2,5",
    })
    @DisplayName("정상적인 식을 연산자 우선순위에 상관없이 앞에서부터 계산하고 그에 대한 결과 값이 맞는지 확인한다.")
    public void calculate(String inputString, double result) {
        assertThat(stringCalculator.execute(inputString)).isEqualTo(result);
    }
}
