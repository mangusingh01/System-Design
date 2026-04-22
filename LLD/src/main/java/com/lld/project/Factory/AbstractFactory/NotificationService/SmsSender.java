package com.lld.project.Factory.AbstractFactory.NotificationService;

public class SmsSender implements MessageSender {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("[SmsSender] → %s: \"%s\"%n", recipient, message);
    }
    @Override public String getChannelName() { return "SMS"; }
}
