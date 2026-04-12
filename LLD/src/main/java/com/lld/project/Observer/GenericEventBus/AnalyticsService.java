package com.lld.project.Observer.GenericEventBus;

public class AnalyticsService {
    public void onUserRegistered(UserRegisteredEvent event) {
        System.out.println("  [Analytics] Tracked new user: " + event.userId);
    }

    public void onPayment(PaymentProcessedEvent event) {
        System.out.println("  [Analytics] Recorded payment $" + event.amount
                + " for order " + event.orderId);
    }
}
