package com.lld.project.Observer.OrderService;

public class EmailNotifier implements OrderObserver {
    @Override
    public void onOrderPlaced(Order order) {
        System.out.println("[Email] Confirmation sent for order #" + order.getId()
                + " to " + order.getCustomerEmail());
    }
}
