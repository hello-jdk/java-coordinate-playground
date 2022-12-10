import static org.assertj.core.api.Assertions.assertThat;

import domain.ui.CalculatorMenu;
import domain.ui.UserInterface;
import org.junit.jupiter.api.Test;

class CalculatorMenuTest {

    @Test
    void 프로그램구동_및_값반환() {
        UserInterface menu = new CalculatorMenu("(10,10)-(14,15)");
        assertThat(menu.runProgram()).isEqualTo(6.403124);
    }
}