package com.lld.project.Practice.ParkingLot;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Build floor 1
        List<ParkingSpot> f1Spots = List.of(
                new ParkingSpot("F1-M1", SpotType.MOTORCYCLE),
                new ParkingSpot("F1-M2", SpotType.MOTORCYCLE),
                new ParkingSpot("F1-C1", SpotType.COMPACT),
                new ParkingSpot("F1-C2", SpotType.COMPACT),
                new ParkingSpot("F1-L1", SpotType.LARGE)
        );
        ParkingFloor floor1 = new ParkingFloor("Floor-1", f1Spots);

        // Configure the singleton
        ParkingLot lot = ParkingLot.getInstance();
        lot.addFloor(floor1);
        lot.setFeeCalculator(new HourlyFeeCalculator(new BigDecimal("50")));

        DisplayBoard board = new DisplayBoard();
        lot.addListener(board);

        // Simulate entry/exit
        Vehicle car1  = VehicleFactory.create("MH-12-AB-1234", VehicleType.CAR);
        Vehicle moto1 = VehicleFactory.create("MH-12-XY-9999", VehicleType.MOTORCYCLE);

        ParkingTicket t1 = lot.park(car1);
        ParkingTicket t2 = lot.park(moto1);

        lot.exit(t1.getTicketId());
        lot.exit(t2.getTicketId());
    }
}
