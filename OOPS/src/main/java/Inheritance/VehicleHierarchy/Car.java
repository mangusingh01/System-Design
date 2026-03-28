package Inheritance.VehicleHierarchy;

public class Car extends Vehicle{
    private int numDoors;

    public Car(String make, String model, int year, int numDoors) {
        super(make, model, year);
        this.numDoors = numDoors;
    }

    public String describe(){
        return super.describe() + ", " + numDoors + "-door";
    }
}

