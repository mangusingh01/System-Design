package com.lld.project.Singleton.ConfigManager;

import java.util.HashMap;
import java.util.Map;

public enum AppConfig {
    INSTANCE;

    private final Map<String, String> config = new HashMap<>();

    // Enum constructors run once, at class-load time, under JVM lock
    AppConfig() {
        config.put("db.host", "localhost");
        config.put("db.port", "5432");
        System.out.println("[Enum] Initialised at class load");
    }

    public String get(String key) { return config.getOrDefault(key, ""); }
    public void set(String key, String value) { config.put(key, value); }
}
