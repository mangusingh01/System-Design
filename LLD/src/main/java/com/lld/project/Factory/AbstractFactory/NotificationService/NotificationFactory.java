package com.lld.project.Factory.AbstractFactory.NotificationService;

public interface NotificationFactory {
    MessageSender  createSender();
    DeliveryTracker createTracker();
}
