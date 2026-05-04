package com.lld.project.Practice.ParkingLot;

public class VehicleFactory {
    public static Vehicle create(String plate, VehicleType type) {
        return switch (type) {
            case CAR        -> new Car(plate);
            case MOTORCYCLE -> new Motorcycle(plate);
            case TRUCK      -> new Truck(plate);
        };
    }
}
