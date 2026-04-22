package com.lld.project.Factory.AbstractFactory.NotificationService;

public class EmailTracker implements DeliveryTracker {
    @Override
    public String track(String messageId) {
        return "EMAIL:" + messageId + " — delivered at 14:32 UTC";
    }
}
