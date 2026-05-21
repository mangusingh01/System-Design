package com.lld.project.Practice.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {

    private static volatile ElevatorController instance;

    private final List<Elevator> elevators = new ArrayList<>();
    private DispatchStrategy     strategy;

    private ElevatorController(DispatchStrategy strategy) {
        this.strategy = strategy;
    }

    public static ElevatorController getInstance(DispatchStrategy strategy) {
        if (instance == null) {
            synchronized (ElevatorController.class) {
                if (instance == null)
                    instance = new ElevatorController(strategy);
            }
        }
        return instance;
    }

    public void addElevator(Elevator e) { elevators.add(e); }

    // External hall call
    public void requestElevator(ExternalRequest req) {
        Elevator chosen = strategy.selectElevator(elevators, req);
        System.out.printf("[Controller] Dispatching Elevator %d to floor %d (%s)%n",
                chosen.getId(), req.getSourceFloor(), req.getDirection());
        chosen.handleRequest(req.getDestination());
    }

    // Internal cabin call
    public void requestFloor(InternalRequest req) {
        elevators.stream()
                .filter(e -> e.getId() == req.getElevatorId())
                .findFirst()
                .ifPresent(e -> e.handleRequest(req.getDestination()));
    }

    // Simulate one time step across all elevators
    public void runStep() {
        elevators.forEach(Elevator::step);
    }

    public void setStrategy(DispatchStrategy s) { this.strategy = s; }

    public void printStatus() {
        elevators.forEach(e -> System.out.println("  " + e));
    }
}
