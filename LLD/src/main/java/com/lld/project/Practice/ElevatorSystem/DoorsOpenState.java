package com.lld.project.Practice.ElevatorSystem;

public class DoorsOpenState implements ElevatorState {

    @Override
    public void handleRequest(Elevator elevator, int floor) {
        elevator.addFloorToQueue(floor);
    }

    @Override
    public void move(Elevator elevator) {
        openDoors(elevator);

        if (elevator.getRequests().isEmpty()) {
            elevator.setDirection(Direction.IDLE);
            elevator.setState(new IdleState());
            return;
        }

        int current = elevator.getCurrentFloor();
        // Prefer continuing in same direction (SCAN behaviour)
        if (elevator.getDirection() == Direction.UP
                && elevator.getRequests().higher(current) != null) {
            elevator.setState(new MovingUpState());
        } else if (elevator.getDirection() == Direction.DOWN
                && elevator.getRequests().lower(current) != null) {
            elevator.setState(new MovingDownState());
        } else if (elevator.getRequests().higher(current) != null) {
            elevator.setDirection(Direction.UP);
            elevator.setState(new MovingUpState());
        } else {
            elevator.setDirection(Direction.DOWN);
            elevator.setState(new MovingDownState());
        }
    }

    @Override
    public void openDoors(Elevator elevator) {
        System.out.printf("[Elevator %d] 🚪 Doors open at floor %d%n",
                elevator.getId(), elevator.getCurrentFloor());
    }
}
