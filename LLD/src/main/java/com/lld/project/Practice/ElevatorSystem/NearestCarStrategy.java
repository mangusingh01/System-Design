package com.lld.project.Practice.ElevatorSystem;

import java.util.List;

public class NearestCarStrategy implements DispatchStrategy {

    @Override
    public Elevator selectElevator(List<Elevator> elevators, ExternalRequest req) {
        int    reqFloor = req.getSourceFloor();
        Direction reqDir = req.getDirection();

        Elevator best     = null;
        int      bestCost = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            int cost = computeCost(e, reqFloor, reqDir);
            if (cost < bestCost) {
                bestCost = cost;
                best     = e;
            }
        }
        return best;
    }

    private int computeCost(Elevator e, int reqFloor, Direction reqDir) {
        int distance = Math.abs(e.getCurrentFloor() - reqFloor);

        if (e.isIdle())                                        return distance;
        if (e.getDirection() == reqDir) {
            // Moving same direction AND on the way
            if (reqDir == Direction.UP   && e.getCurrentFloor() <= reqFloor) return distance;
            if (reqDir == Direction.DOWN && e.getCurrentFloor() >= reqFloor) return distance;
        }
        // Moving away or wrong direction — high cost
        return distance + 100;
    }
}
