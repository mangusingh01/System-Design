package Inheritance.VehicleHierarchy;

public class Vehicle {
    protected String make, model;
    protected int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String describe() {
        return year + " " + make + " " + model;
    }
}
