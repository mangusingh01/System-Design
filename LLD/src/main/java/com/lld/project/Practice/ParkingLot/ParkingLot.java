package com.lld.project.Practice.ParkingLot;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private static volatile ParkingLot instance;

    private final List<ParkingFloor>        floors         = new ArrayList<>();
    private final Map<String, ParkingTicket> activeTickets = new ConcurrentHashMap<>();
    private final List<ParkingEventListener> listeners     = new ArrayList<>();
    private FeeCalculator feeCalculator;

    private ParkingLot() {}

    public static ParkingLot getInstance() {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) instance = new ParkingLot();
            }
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) { floors.add(floor); }

    public void setFeeCalculator(FeeCalculator calc) {
        this.feeCalculator = calc;
    }

    public void addListener(ParkingEventListener l) { listeners.add(l); }

    public ParkingTicket park(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle.getType())
                .orElseThrow(() -> new IllegalStateException(
                        "No available spot for vehicle type: " + vehicle.getType()));

        spot.park(vehicle);

        ParkingTicket ticket = new ParkingTicket(vehicle, spot);
        activeTickets.put(ticket.getTicketId(), ticket);

        notifyListeners(spot.getType());
        System.out.printf("Vehicle %s parked at spot %s | Ticket: %s%n",
                vehicle.getLicensePlate(), spot.getSpotId(), ticket.getTicketId());

        return ticket;
    }

    public BigDecimal exit(String ticketId) {
        ParkingTicket ticket = activeTickets.remove(ticketId);
        if (ticket == null)
            throw new IllegalArgumentException("Invalid ticket: " + ticketId);

        LocalDateTime exitTime = LocalDateTime.now();
        BigDecimal fee = feeCalculator.calculate(ticket, exitTime);

        ticket.getSpot().vacate();
        ticket.markPaid(fee);

        notifyListeners(ticket.getSpot().getType());
        System.out.printf("Vehicle %s exited | Duration: %s -> %s | Fee: ₹%.2f%n",
                ticket.getVehicle().getLicensePlate(),
                ticket.getEntryTime(), exitTime, fee);

        return fee;
    }

    private Optional<ParkingSpot> findAvailableSpot(VehicleType type) {
        // "First-fit across floors — could swap strategy here
        //  for nearest-available or load-balanced assignment."
        return floors.stream()
                .map(f -> f.getAvailableSpot(type))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst();
    }

    private void notifyListeners(SpotType changedType) {
        long count = floors.stream()
                .mapToLong(f -> f.getAvailableCount(changedType))
                .sum();
        listeners.forEach(l -> l.onAvailabilityChanged(changedType, (int) count));
    }
}
