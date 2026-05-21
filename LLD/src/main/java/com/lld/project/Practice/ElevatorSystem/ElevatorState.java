package com.lld.project.Practice.ElevatorSystem;

public interface ElevatorState {
    void handleRequest(Elevator elevator, int floor);
    void move(Elevator elevator);
    void openDoors(Elevator elevator);
}
