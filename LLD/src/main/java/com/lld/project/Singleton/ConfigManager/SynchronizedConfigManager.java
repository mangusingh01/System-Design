package com.lld.project.Singleton.ConfigManager;

import java.util.HashMap;
import java.util.Map;

// ═══════════════════════════════════════════════════════
// IMPLEMENTATION 2: Synchronized lazy initialisation
// ═══════════════════════════════════════════════════════
// Simple and correct. The `synchronized` keyword on getInstance()
// means only one thread can enter at a time — but this is a lock
// acquisition on EVERY call, even after the instance exists.
// Fine for low-traffic code; bottleneck for hot paths.
public class SynchronizedConfigManager {
    private static SynchronizedConfigManager instance;
    private final Map<String, String> config = new HashMap<>();

    private SynchronizedConfigManager() {
        config.put("db.host", "localhost");
        config.put("db.port", "5432");
        System.out.println("[Synchronized] Initialised on first call");
    }

    // synchronized = class-level monitor lock on every invocation
    public static synchronized SynchronizedConfigManager getInstance() {
        if (instance == null) {
            instance = new SynchronizedConfigManager();
        }
        return instance;
    }

    public String get(String key) { return config.getOrDefault(key, ""); }
}
