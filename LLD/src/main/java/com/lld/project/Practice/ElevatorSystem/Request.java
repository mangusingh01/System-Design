package com.lld.project.Practice.ElevatorSystem;

public abstract class Request {
    protected final int destinationFloor;
    protected Request(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }
    public int getDestination() { return destinationFloor; }
}

