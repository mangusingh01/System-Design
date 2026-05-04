package com.lld.project.Practice.ParkingLot;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;
    private java.math.BigDecimal fee;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId  = UUID.randomUUID().toString();
        this.vehicle   = vehicle;
        this.spot      = spot;
        this.entryTime = LocalDateTime.now();
    }

    public String        getTicketId()     { return ticketId; }
    public Vehicle       getVehicle()      { return vehicle; }
    public ParkingSpot   getSpot()         { return spot; }
    public LocalDateTime getEntryTime()    { return entryTime; }
    public PaymentStatus getPaymentStatus(){ return paymentStatus; }

    public void markPaid(java.math.BigDecimal amount) {
        this.fee           = amount;
        this.paymentStatus = PaymentStatus.PAID;
    }
}

