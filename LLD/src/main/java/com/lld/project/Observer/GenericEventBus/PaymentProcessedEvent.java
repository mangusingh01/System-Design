package com.lld.project.Observer.GenericEventBus;

public class PaymentProcessedEvent {
    public final String orderId;
    public final double amount;

    public PaymentProcessedEvent(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }
}
