package domain.ui;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

import org.junit.jupiter.api.Test;

class CalculatorMenuTest {

    @Test
    void 예시_결과값_테스트() {
        // given
        UserInterface userInterface = new CalculatorMenu("(10,10)-(14,15)");

        // when
        double result = userInterface.runProgram();

        // then
        assertThat(result).isEqualTo(6.403124, offset(0.00000099));
    }
}