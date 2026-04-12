package com.lld.project.Observer.GenericEventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventBus {

    private final Map<Class<?>, List<Consumer<Object>>> listeners = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> void subscribe(Class<T> eventType, Consumer<T> listener) {
        listeners
                .computeIfAbsent(eventType, k -> new ArrayList<>())
                .add((Consumer<Object>) listener);
        System.out.println("[EventBus] Subscribed listener for: " + eventType.getSimpleName());
    }

    public <T> void publish(T event) {
        List<Consumer<Object>> eventListeners = listeners.get(event.getClass());
        if (eventListeners == null) {
            System.out.println("[EventBus] No listeners for: " + event.getClass().getSimpleName());
            return;
        }
        System.out.println("[EventBus] Publishing " + event.getClass().getSimpleName()
                + " to " + eventListeners.size() + " listener(s)");
        for (Consumer<Object> listener : eventListeners) {
            listener.accept(event);
        }
    }

    public <T> void unsubscribe(Class<T> eventType, Consumer<T> listener) {
        List<Consumer<Object>> list = listeners.get(eventType);
        if (list != null) list.remove(listener);
    }

}

