package com.lld.project.Factory.AbstractFactory.NotificationService;

public class SmsNotificationFactory implements NotificationFactory {
    @Override public MessageSender   createSender()  { return new SmsSender(); }
    @Override public DeliveryTracker createTracker() { return new SmsTracker(); }
}
