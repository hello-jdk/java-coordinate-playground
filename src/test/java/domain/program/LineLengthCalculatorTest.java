package domain.program;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.offset;

import domain.Coordinate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LineLengthCalculatorTest {

    @Test
    void 두개의_좌표값이외_입력시_예외를_발생시킵니다() {
        // given
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(1, 2));
        coordinates.add(new Coordinate(2, 3));
        coordinates.add(new Coordinate(3, 4));

        // when then
        assertThatThrownBy(() ->
                new LineLengthCalculator(coordinates)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예시_결과값_테스트() {
        // given
        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(10, 10));
        coordinates.add(new Coordinate(14, 15));
        Calculator calculator = new LineLengthCalculator(coordinates);

        // when
        double result = calculator.findResult();

        // then
        assertThat(result).isEqualTo(6.403124, offset(0.00000099));
        System.out.println(result);
    }
}