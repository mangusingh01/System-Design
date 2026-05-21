package com.lld.project.Practice.ElevatorSystem;

public interface ElevatorEventListener {
    void onElevatorArrived(int elevatorId, int floor, Direction direction);
}
