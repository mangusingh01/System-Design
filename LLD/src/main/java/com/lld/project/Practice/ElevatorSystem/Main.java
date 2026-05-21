package com.lld.project.Practice.ElevatorSystem;

public class Main {
    public static void main(String[] args) {

        // Build two elevators starting at floor 1
        Elevator e1 = new Elevator(1, 1);
        Elevator e2 = new Elevator(2, 5);

        // Attach floor panels as observers
        for (int f = 1; f <= 10; f++) {
            FloorPanel panel = new FloorPanel(f);
            e1.addListener(panel);
            e2.addListener(panel);
        }

        ElevatorController controller =
                ElevatorController.getInstance(new NearestCarStrategy());
        controller.addElevator(e1);
        controller.addElevator(e2);

        System.out.println("=== Initial state ===");
        controller.printStatus();

        // Hall calls
        controller.requestElevator(new ExternalRequest(7, Direction.UP));
        controller.requestElevator(new ExternalRequest(3, Direction.DOWN));

        // Cabin call inside elevator 1: passenger wants floor 9
        controller.requestFloor(new InternalRequest(9, 1));

        System.out.println("\n=== Stepping simulation ===");
        for (int step = 0; step < 6; step++) {
            System.out.printf("%n-- Step %d --%n", step + 1);
            controller.runStep();
            controller.printStatus();
        }
    }
}