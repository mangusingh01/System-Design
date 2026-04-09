package com.lld.project.Observer.OrderService;

public class AuditLogger implements OrderObserver {
    @Override
    public void onOrderPlaced(Order order) {
        System.out.println("[Audit] Logged ORDER_PLACED event for order #" + order.getId());
    }
}
