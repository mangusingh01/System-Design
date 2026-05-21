package com.lld.project.Practice.ElevatorSystem;

public class FloorPanel implements ElevatorEventListener {
    private final int floor;
    public FloorPanel(int floor) { this.floor = floor; }

    @Override
    public void onElevatorArrived(int elevatorId, int arrivedFloor, Direction direction) {
        if (arrivedFloor == this.floor) {
            System.out.printf("[FloorPanel %d] Elevator %d arrived going %s%n",
                    floor, elevatorId, direction);
        }
    }
}
