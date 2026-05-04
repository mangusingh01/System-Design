package com.lld.project.Practice.ParkingLot;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface FeeCalculator {
    BigDecimal calculate(ParkingTicket ticket, LocalDateTime exitTime);
}

