package com.lld.project.Factory.AbstractFactory.NotificationService;

public interface MessageSender {
    void send(String recipient, String message);
    String getChannelName();
}
