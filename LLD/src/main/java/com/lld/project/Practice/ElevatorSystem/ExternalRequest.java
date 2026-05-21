package com.lld.project.Practice.ElevatorSystem;

public class ExternalRequest extends Request {
    private final int       sourceFloor;
    private final Direction direction;

    public ExternalRequest(int sourceFloor, Direction direction) {
        super(sourceFloor);               // destination = source for dispatch
        this.sourceFloor = sourceFloor;
        this.direction   = direction;
    }
    public int       getSourceFloor() { return sourceFloor; }
    public Direction getDirection()   { return direction; }
}
