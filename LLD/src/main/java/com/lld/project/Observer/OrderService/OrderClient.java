package com.lld.project.Observer.OrderService;

public final class OrderClient {
    OrderService orderService = new OrderService();

    // Wire observers at startup — configuration, not modification
    orderService.addObserver(new EmailNotifier());
    orderService.addObserver(new InventoryService());
    orderService.addObserver(new AuditLogger());

    orderService.placeOrder(new Order("ORD-001", "alice@example.com"));

    System.out.println("\n--- Adding SMS notifier at runtime ---");
    orderService.addObserver(order ->
        System.out.println("[SMS] Text sent for order #" + order.getId())
        ); // lambda as observer — works because OrderObserver is a @FunctionalInterface

    orderService.placeOrder(new Order("ORD-002", "bob@example.com"));

}
