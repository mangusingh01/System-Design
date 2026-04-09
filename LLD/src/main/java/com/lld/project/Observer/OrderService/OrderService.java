package com.lld.project.Observer.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private final List<OrderObserver> observers = new ArrayList<>();

    // Register / deregister — observers manage their own lifecycle
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    // Core business logic — clean, no notification sprawl
    public void placeOrder(Order order) {
        System.out.println("Order saved: #" + order.getId());
        notifyObservers(order); // pure delegation
    }

    // Private — notification is an implementation detail
    private void notifyObservers(Order order) {
        for (OrderObserver observer : observers) {
            observer.onOrderPlaced(order); // dynamic dispatch — subject never knows the concrete type
        }
    }
}
