package Inheritance.VehicleHierarchy;

public class ElectricCar extends Car {
    private int batteryRangeKm;

    public ElectricCar(String make, String model, int year, int doors, int rangeKm) {
        super(make, model, year, doors);
        this.batteryRangeKm = rangeKm;
    }

    public String describe() {
        return super.describe() + ", electric (" + batteryRangeKm + " km)";
    }
}
