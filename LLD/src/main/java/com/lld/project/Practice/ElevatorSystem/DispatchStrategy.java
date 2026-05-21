package com.lld.project.Practice.ElevatorSystem;

import java.util.List;

public interface DispatchStrategy {
    Elevator selectElevator(List<Elevator> elevators, ExternalRequest request);
}
