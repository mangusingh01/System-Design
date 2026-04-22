package com.lld.project.Factory.AbstractFactory.NotificationService;

public class EmailNotificationFactory implements NotificationFactory {
    @Override public MessageSender   createSender()  { return new EmailSender(); }
    @Override public DeliveryTracker createTracker() { return new EmailTracker(); }
}
