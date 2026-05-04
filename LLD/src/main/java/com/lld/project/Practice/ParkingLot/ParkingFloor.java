package com.lld.project.Practice.ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private final String floorId;
    private final List<ParkingSpot> spots;

    public ParkingFloor(String floorId, List<ParkingSpot> spots) {
        this.floorId = floorId;
        this.spots   = new ArrayList<>(spots);
    }

    public Optional<ParkingSpot> getAvailableSpot(VehicleType vehicleType) {
        return spots.stream()
                .filter(s -> s.isAvailable() && s.canFit(vehicleType))
                .findFirst();
    }

    public long getAvailableCount(SpotType type) {
        return spots.stream()
                .filter(s -> s.getType() == type && s.isAvailable())
                .count();
    }

    public String getFloorId() { return floorId; }
}
