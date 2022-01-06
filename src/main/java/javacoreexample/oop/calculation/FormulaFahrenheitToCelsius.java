package javacoreexample.oop.calculation;

import java.text.DecimalFormat;

public class FormulaFahrenheitToCelsius {
    public double getFahrenheitTemperature;
    public double result;
    public int subtract;
    public double multiple;

    public FormulaFahrenheitToCelsius(double getFahrenheitTemperature, int subtract, double multiple) {
        this.getFahrenheitTemperature = getFahrenheitTemperature;
        this.subtract = subtract;
        this.multiple = multiple;
    }

    public double getGetFahrenheitTemperature() {
        return getFahrenheitTemperature;
    }

    public void setGetFahrenheitTemperature(double getFahrenheitTemperature) {
        this.getFahrenheitTemperature = getFahrenheitTemperature;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public int getSubtract() {
        return subtract;
    }

    public void setSubtract(int subtract) {
        this.subtract = subtract;
    }

    public double getMultiple() {
        return multiple;
    }

    public void setMultiple(double multiple) {
        this.multiple = multiple;
    }

    public void resultTemperature() {
        result = (getFahrenheitTemperature - subtract) * multiple;
        DecimalFormat f = new DecimalFormat("##");
        System.out.println("Converted temperature is " + f.format(result) + "°C.");
    }
}
