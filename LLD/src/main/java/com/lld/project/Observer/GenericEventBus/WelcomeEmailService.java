package com.lld.project.Observer.GenericEventBus;

public class WelcomeEmailService {
    public void onUserRegistered(UserRegisteredEvent event) {
        System.out.println("  [WelcomeEmail] Sent welcome to " + event.email);
    }
}
