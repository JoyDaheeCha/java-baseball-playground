package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("덧셈 테스트")
    void addTest(){
        int actual = calculator.add(1,2);
        assertThat(actual).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈 테스트")
    void subtractTest(){
        int actual = calculator.subtract(1,2);
        assertThat(actual).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셉 테스트")
    void multiplyTest(){
        int actual = calculator.multiply(1,2);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void divideTest(){
        int actual = calculator.divide(5,2);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("계산 분기 테스트")
    void calculateTest(){
        int actual = calculator.calculate(5,"/",2);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("계산기 문자열 입력 및 정상 계산 여 테스트")
    void calculatorGetResultMethodTest(){
        int actual = calculator.getResult("2 + 3 * 4 / 2");
        assertThat(actual).isEqualTo(10);
    }

}
