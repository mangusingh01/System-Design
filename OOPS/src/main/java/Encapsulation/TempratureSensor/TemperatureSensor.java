package Encapsulation.TempratureSensor;

public class TemperatureSensor {
    private static final double ABSOLUTE_ZERO = -273.15;
    private double celsius;

    public TemperatureSensor(double initialCelsius) {
        setTemperature(initialCelsius);
    }

    public void setTemperature(double val) {
        if (val < ABSOLUTE_ZERO) {
//            throw new IllegalArgumentException(
//                    "Temperature below absolute zero: " + val
//            );
            System.out.println("Invalid temperature");
            return;
        }
        this.celsius = val;
    }

    public double getTemperature() {
        return this.celsius;
    }

    public double getFahrenheit() {
        return (celsius * 9.0 / 5.0) + 32;
    }
}
