package com.lld.project.Practice.ParkingLot;

public abstract class Vehicle {
    protected final String licensePlate;
    protected final VehicleType type;

    protected Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public VehicleType getType()       { return type; }
    public String getLicensePlate()    { return licensePlate; }
}
