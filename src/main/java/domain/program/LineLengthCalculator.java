package domain.program;

import domain.Coordinate;
import java.util.List;

public class LineLengthCalculator implements Calculator {
    private List<Coordinate> coordinates;

    public LineLengthCalculator(List<Coordinate> coordinates) {
        validate(coordinates);
        this.coordinates = coordinates;
    }

    private void validate(List<Coordinate> coordinates) {
        boolean isNotLine = (coordinates.size() != 2);
        if (isNotLine) {
            throw new IllegalArgumentException("LineLengthCalculator를 이용하기 위해선 두개의 좌표만을 입력해야합니다.");
        }
    }

    @Override
    public double findResult() {
        Coordinate firstCoordinate = coordinates.get(0);
        Coordinate secondCoordinate = coordinates.get(1);
        return calculateLength(firstCoordinate, secondCoordinate);
    }

    private double calculateLength(Coordinate firstCoordinate, Coordinate secondCoordinate) {
        double abscissaSub = firstCoordinate.getX() - secondCoordinate.getX();
        double ordinateSub = firstCoordinate.getY() - secondCoordinate.getY();

        double powAbscissa = Math.pow(abscissaSub, 2);
        double powOrdinate = Math.pow(ordinateSub, 2);

        return Math.sqrt(powAbscissa+powOrdinate);
    }
}
