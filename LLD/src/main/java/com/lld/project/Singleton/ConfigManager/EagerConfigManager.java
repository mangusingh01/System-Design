package com.lld.project.Singleton.ConfigManager;

import java.util.HashMap;
import java.util.Map;

// ═══════════════════════════════════════════════════════
// IMPLEMENTATION 1: Eager initialisation
// ═══════════════════════════════════════════════════════
// The JVM initialises static fields when the class is first loaded,
// under a class-loading lock. Thread safety is guaranteed by the JVM itself.
// Cost: instance is created even if never used.
public class EagerConfigManager {
    // static final: initialised once at class-load time, never null
    private static final EagerConfigManager INSTANCE = new EagerConfigManager();

    private final Map<String, String> config = new HashMap<>();

    private EagerConfigManager() {
        config.put("db.host", "localhost");
        config.put("db.port", "5432");
        System.out.println("[Eager] Initialised at class load");
    }

    public static EagerConfigManager getInstance() {
        return INSTANCE; // no null check, no lock — just return
    }

    public String get(String key) { return config.getOrDefault(key, ""); }
}
