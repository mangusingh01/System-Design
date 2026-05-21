package com.lld.project.Practice.ElevatorSystem;

public class MovingDownState implements ElevatorState {

    @Override
    public void handleRequest(Elevator elevator, int floor) {
        elevator.addFloorToQueue(floor);
    }

    @Override
    public void move(Elevator elevator) {
        java.util.TreeSet<Integer> reqs = elevator.getRequests();
        Integer nextFloor = reqs.lower(elevator.getCurrentFloor());
        if (nextFloor == null) nextFloor = reqs.last();

        elevator.setCurrentFloor(nextFloor);
        elevator.getRequests().remove(nextFloor);
        System.out.printf("[Elevator %d] ↓ Moving to floor %d%n",
                elevator.getId(), nextFloor);
        elevator.notifyListeners();

        elevator.setState(new DoorsOpenState());
    }

    @Override
    public void openDoors(Elevator elevator) {
        System.out.printf("[Elevator %d] Doors open at floor %d%n",
                elevator.getId(), elevator.getCurrentFloor());
    }
}