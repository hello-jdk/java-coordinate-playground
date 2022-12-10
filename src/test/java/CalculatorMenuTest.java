import static org.assertj.core.api.Assertions.assertThat;

import domain.ui.CalculatorMenu;
import domain.ui.UserInterface;
import org.junit.jupiter.api.Test;

class CalculatorMenuTest {

    @Test
    void 입력에따라_서비스를_생성한다() {
        UserInterface menu = new CalculatorMenu("(10,10)-(14,15)");
        assertThat(menu.runProgram()).isEqualTo(6.403124);

    }
}