package com.lld.project.Factory.AbstractFactory.NotificationService;

public class SmsTracker implements DeliveryTracker {
    @Override
    public String track(String messageId) {
        return "SMS:" + messageId + " — delivered at 14:33 UTC";
    }
}

