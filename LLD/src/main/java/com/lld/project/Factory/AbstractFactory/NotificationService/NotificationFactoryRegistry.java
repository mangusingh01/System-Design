package com.lld.project.Factory.AbstractFactory.NotificationService;

import java.util.HashMap;
import java.util.Map;

public class NotificationFactoryRegistry {
    private final Map<String, NotificationFactory> registry = new HashMap<>();

    public NotificationFactoryRegistry() {
        registry.put("EMAIL", new EmailNotificationFactory());
        registry.put("SMS",   new SmsNotificationFactory());
        // Adding WhatsApp: registry.put("WHATSAPP", new WhatsAppNotificationFactory());
        // Zero changes to existing classes.
    }

    public NotificationFactory get(String channel) {
        NotificationFactory factory = registry.get(channel.toUpperCase());
        if (factory == null) throw new IllegalArgumentException("No factory for: " + channel);
        return factory;
    }
}

