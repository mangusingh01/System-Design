package com.lld.project.Practice.ParkingLot;

public class ParkingSpot {
    private final String spotId;
    private final SpotType type;
    private boolean available = true;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotId, SpotType type) {
        this.spotId = spotId;
        this.type   = type;
    }

    public boolean canFit(VehicleType vehicleType) {
        return switch (type) {
            case MOTORCYCLE -> vehicleType == VehicleType.MOTORCYCLE;
            case COMPACT    -> vehicleType == VehicleType.CAR
                    || vehicleType == VehicleType.MOTORCYCLE;
            case LARGE      -> true;   // any vehicle
        };
    }

    public boolean isAvailable()     { return available; }
    public String  getSpotId()       { return spotId; }
    public SpotType getType()        { return type; }

    public synchronized void park(Vehicle v) {
        if (!available) throw new IllegalStateException("Spot already taken: " + spotId);
        parkedVehicle = v;
        available     = false;
    }

    public synchronized void vacate() {
        parkedVehicle = null;
        available     = true;
    }
}
