package com.lld.project.Practice.ParkingLot;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class HourlyFeeCalculator implements FeeCalculator {
    private final BigDecimal ratePerHour;

    public HourlyFeeCalculator(BigDecimal ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public BigDecimal calculate(ParkingTicket ticket, LocalDateTime exitTime) {
        long hours = ChronoUnit.HOURS.between(ticket.getEntryTime(), exitTime);
        long billableHours = Math.max(1, hours);   // minimum 1 hour
        return ratePerHour.multiply(BigDecimal.valueOf(billableHours));
    }
}
