package com.lld.project.Observer.GenericEventBus;

public class TheMainEquivalentClass {
    EventBus bus = new EventBus();
    WelcomeEmailService welcomeEmail = new WelcomeEmailService();
    AnalyticsService analytics = new AnalyticsService();

    // Subscribe — note: subject (EventBus) never imports these service classes
    bus.subscribe(UserRegisteredEvent.class, welcomeEmail::onUserRegistered);
    bus.subscribe(UserRegisteredEvent.class, analytics::onUserRegistered);
    bus.subscribe(PaymentProcessedEvent.class, analytics::onPayment);

    System.out.println("\n--- User registers ---");
    bus.publish(new UserRegisteredEvent("USR-42", "alice@example.com"));

    System.out.println("\n--- Payment processed ---");
    bus.publish(new PaymentProcessedEvent("ORD-007", 149.99));

    System.out.println("\n--- Unknown event ---");
    bus.publish("just a string"); // no listeners registered
}
