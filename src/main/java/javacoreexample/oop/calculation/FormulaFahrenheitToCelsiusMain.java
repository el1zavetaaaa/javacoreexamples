package javacoreexample.oop.calculation;

import java.util.Scanner;

public class FormulaFahrenheitToCelsiusMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter temperature (°F): ");
        double getFahrenheitTemperature;
        getFahrenheitTemperature = scanner.nextInt();
        int STATIC_SUBTRACT = 32;
        double STATIC_MULTIPLE = 0.556;

        FormulaFahrenheitToCelsius formulaFahrenheitToCelsius = new FormulaFahrenheitToCelsius(getFahrenheitTemperature
                , STATIC_SUBTRACT, STATIC_MULTIPLE);
        formulaFahrenheitToCelsius.resultTemperature();
    }

}
