package domain.ui;

import domain.program.Calculator;

public class CalculatorMenu implements UserInterface {
    private final Calculator calculator;

    public CalculatorMenu(String userInput) {
        calculator = generateCalculator(userInput);
    }

    private Calculator generateCalculator(String userInput) {
        return new Calculator() {
            // Line
            // Triangle
            // Rectangle
        };
    }

    @Override
    public int runProgram() {
        return 0;
    }
}
