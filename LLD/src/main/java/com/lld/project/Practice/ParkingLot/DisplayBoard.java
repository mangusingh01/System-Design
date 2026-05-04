package com.lld.project.Practice.ParkingLot;

import java.util.EnumMap;
import java.util.Map;

public class DisplayBoard implements ParkingEventListener {
    private final Map<SpotType, Integer> availableCounts = new EnumMap<>(SpotType.class);

    public DisplayBoard() {
        for (SpotType t : SpotType.values()) availableCounts.put(t, 0);
    }

    @Override
    public void onAvailabilityChanged(SpotType type, int available) {
        availableCounts.put(type, available);
        show();
    }

    public void show() {
        System.out.println("=== Parking Availability ===");
        availableCounts.forEach((t, n) ->
                System.out.printf("  %-12s : %d spots%n", t, n));
    }
}
