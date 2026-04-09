package com.lld.project.Observer.OrderService;

public class Order {
    private final String id;
    private final String customerEmail;

    public Order(String id, String customerEmail) {
        this.id = id;
        this.customerEmail = customerEmail;
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
}

