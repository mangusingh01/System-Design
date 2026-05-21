package com.lld.project.Practice.ElevatorSystem;

public class MovingUpState implements ElevatorState {

    @Override
    public void handleRequest(Elevator elevator, int floor) {
        // Serve floors above current on the way up; queue rest
        elevator.addFloorToQueue(floor);
    }

    @Override
    public void move(Elevator elevator) {
        int next = elevator.getRequests().first(); // lowest pending floor above
        // Find the next floor above current
        java.util.TreeSet<Integer> reqs = elevator.getRequests();
        Integer nextFloor = reqs.higher(elevator.getCurrentFloor());
        if (nextFloor == null) nextFloor = reqs.first(); // wrap if needed

        elevator.setCurrentFloor(nextFloor);
        elevator.getRequests().remove(nextFloor);
        System.out.printf("[Elevator %d] ↑ Moving to floor %d%n",
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
