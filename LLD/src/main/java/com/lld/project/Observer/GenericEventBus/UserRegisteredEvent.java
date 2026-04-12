package com.lld.project.Observer.GenericEventBus;

public class UserRegisteredEvent {
    public final String userId;
    public final String email;

    public UserRegisteredEvent(String userId, String email) {
        this.userId = userId;
        this.email = email;
    }
}

