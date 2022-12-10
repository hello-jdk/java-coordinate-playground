package domain.program;

import domain.Coordinate;
import java.util.List;

public class LineLengthCalculator implements Calculator {
    private List<Coordinate> coordinate;

    public LineLengthCalculator(List<Coordinate> coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public double findResult() {
        return 0;
    }
}
