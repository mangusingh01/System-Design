package com.lld.project.Observer.OrderService;

public class InventoryService implements OrderObserver {
    @Override
    public void onOrderPlaced(Order order) {
        System.out.println("[Inventory] Stock decremented for order #" + order.getId());
    }
}
