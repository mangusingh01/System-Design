package com.lld.project.Practice.ElevatorSystem;

public class IdleState implements ElevatorState {

    @Override
    public void handleRequest(Elevator elevator, int floor) {
        elevator.addFloorToQueue(floor);
        int current = elevator.getCurrentFloor();
        if (floor > current) {
            elevator.setDirection(Direction.UP);
            elevator.setState(new MovingUpState());
        } else if (floor < current) {
            elevator.setDirection(Direction.DOWN);
            elevator.setState(new MovingDownState());
        } else {
            // Already here — just open doors
            elevator.setState(new DoorsOpenState());
        }
    }

    @Override
    public void move(Elevator elevator) {
        System.out.printf("[Elevator %d] Idle — nothing to do%n",
                elevator.getId());
    }

    @Override
    public void openDoors(Elevator elevator) {
        System.out.printf("[Elevator %d] Doors open at floor %d%n",
                elevator.getId(), elevator.getCurrentFloor());
    }
}
