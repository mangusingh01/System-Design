package com.lld.project.Practice.ParkingLot;

public interface ParkingEventListener {
    void onAvailabilityChanged(SpotType type, int available);
}
