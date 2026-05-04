package com.lld.project.Practice.ParkingLot;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FlatRateFeeCalculator implements FeeCalculator {
    private final BigDecimal flatRate;

    public FlatRateFeeCalculator(BigDecimal flatRate) {
        this.flatRate = flatRate;
    }

    @Override
    public BigDecimal calculate(ParkingTicket ticket, LocalDateTime exitTime) {
        return flatRate;
    }
}
