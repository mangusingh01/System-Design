package com.lld.project.Practice.ElevatorSystem;

public class InternalRequest extends Request {
    private final int elevatorId;
    public InternalRequest(int destinationFloor, int elevatorId) {
        super(destinationFloor);
        this.elevatorId = elevatorId;
    }
    public int getElevatorId() { return elevatorId; }
}
