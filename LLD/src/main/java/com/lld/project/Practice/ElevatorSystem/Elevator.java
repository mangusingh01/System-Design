package com.lld.project.Practice.ElevatorSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Elevator {
    private final int id;
    private int       currentFloor;
    private Direction direction = Direction.IDLE;

    // TreeSet gives us sorted floors for free — O(log n) insert
    // "I use TreeSet so I can efficiently find the next floor above
    //  or below current position, enabling SCAN-style dispatch."
    private final TreeSet<Integer>            requests  = new TreeSet<>();
    private final List<ElevatorEventListener> listeners = new ArrayList<>();

    private ElevatorState state = new IdleState();

    public Elevator(int id, int startFloor) {
        this.id           = id;
        this.currentFloor = startFloor;
    }

    // ── Delegates to current state ────────────────────────
    public void handleRequest(int floor) { state.handleRequest(this, floor); }
    public void step()                   { state.move(this); }

    // ── Accessors (package-visible to states) ─────────────
    public int           getId()           { return id; }
    public int           getCurrentFloor() { return currentFloor; }
    public Direction     getDirection()    { return direction; }
    public TreeSet<Integer> getRequests()  { return requests; }
    public ElevatorState getState()        { return state; }

    public void setCurrentFloor(int f)     { this.currentFloor = f; }
    public void setDirection(Direction d)  { this.direction = d; }
    public void setState(ElevatorState s)  { this.state = s; }
    public void addFloorToQueue(int f)     { requests.add(f); }

    public void addListener(ElevatorEventListener l) { listeners.add(l); }
    public void notifyListeners() {
        listeners.forEach(l ->
                l.onElevatorArrived(id, currentFloor, direction));
    }

    public boolean isIdle() { return state instanceof IdleState; }

    @Override
    public String toString() {
        return String.format("Elevator[id=%d, floor=%d, dir=%s, queue=%s]",
                id, currentFloor, direction, requests);
    }
}
