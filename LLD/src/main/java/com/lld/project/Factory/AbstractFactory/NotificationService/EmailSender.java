package com.lld.project.Factory.AbstractFactory.NotificationService;

public class EmailSender implements MessageSender {
    @Override
    public void send(String recipient, String message) {
        System.out.printf("[EmailSender] → %s: \"%s\"%n", recipient, message);
    }
    @Override public String getChannelName() { return "EMAIL"; }
}

