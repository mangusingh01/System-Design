package com.lld.project.Factory.AbstractFactory.NotificationService;

public class NotificationService {
    private final MessageSender   sender;
    private final DeliveryTracker tracker;

    public NotificationService(NotificationFactory factory) {
        this.sender  = factory.createSender();
        this.tracker = factory.createTracker();
    }

    public void notify(String recipient, String message) {
        System.out.println("Sending via " + sender.getChannelName() + "...");
        sender.send(recipient, message);
    }

    public void checkDelivery(String messageId) {
        System.out.println("Tracking: " + tracker.track(messageId));
    }
}
