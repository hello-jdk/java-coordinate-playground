package domain.ui;

import domain.Coordinate;
import domain.program.Calculator;
import domain.program.LineLengthCalculator;
import java.util.ArrayList;
import java.util.List;

public class CalculatorMenu implements UserInterface {
    private final Calculator calculator;

    public CalculatorMenu(String userInput) {
        List<Coordinate> coordinateSet = generateCoordinateSet(userInput);
        calculator = generateCalculator(coordinateSet);
    }

    private List<Coordinate> generateCoordinateSet(String userInput) {
        List<String[]> stringCoordinateSet = generateStringCoordinateSet(userInput);
        return generateOrdinaryCoordinateSet(stringCoordinateSet);
    }

    private List<String[]> generateStringCoordinateSet(String userInput) {
        List<String[]> stringCoordinateSet = new ArrayList<>();
        while (userInput.contains("(")) {
            stringCoordinateSet.add(findStringCoordinate(userInput));
            userInput = updateUserInput(userInput);
        }
        return stringCoordinateSet;
    }

    private String[] findStringCoordinate(String userInput) {
        final int OFFSET = 1;
        int startIndex = userInput.indexOf('(') + OFFSET;
        int lastIndex = userInput.indexOf(')');
        return userInput
                .substring(startIndex, lastIndex)
                .split(",");
    }

    private String updateUserInput(String userInput) {
        final int OFFSET = 1;
        int startIndex = userInput.indexOf('-') + OFFSET;
        return userInput.substring(startIndex);
    }

    // TODO: 이거 없앨수 있을꺼같은데..
    private List<Coordinate> generateOrdinaryCoordinateSet(List<String[]> stringCoordinateSet) {
        List<Coordinate> ordinaryCoordinates = new ArrayList<>();
        for (String[] stringCoordinate : stringCoordinateSet) {
            int x = Integer.parseInt(stringCoordinate[0]);
            int y = Integer.parseInt(stringCoordinate[1]);
            ordinaryCoordinates.add(new Coordinate(x, y));
        }
        return ordinaryCoordinates;
    }

    private Calculator generateCalculator(List<Coordinate> coordinateSet) {
        int coordinateCount = coordinateSet.size();

        if (coordinateCount == 2) {
            return new LineLengthCalculator(coordinateSet);
        }

        throw new IllegalArgumentException("이건 나오면 안되요..");
    }

    @Override
    public double runProgram() {
        return calculator.findResult();
    }
}
