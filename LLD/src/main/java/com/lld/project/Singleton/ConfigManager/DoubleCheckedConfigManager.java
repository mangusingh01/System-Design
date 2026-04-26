package com.lld.project.Singleton.ConfigManager;

import java.util.HashMap;
import java.util.Map;

// ═══════════════════════════════════════════════════════
// IMPLEMENTATION 3: Double-checked locking (production standard)
// ═══════════════════════════════════════════════════════
// The most common interview answer at SDE2-3 level.
// Two checks: one outside the lock (cheap, handles steady state),
// one inside the lock (handles the race on first creation).
// volatile is REQUIRED — without it, CPU instruction reordering can
// cause another thread to observe a partially-constructed instance.
public class DoubleCheckedConfigManager {
    // volatile prevents instruction reordering across the write.
    // Guarantees: write to instance is visible to all threads immediately.
    private static volatile DoubleCheckedConfigManager instance;
    private final Map<String, String> config = new HashMap<>();

    private DoubleCheckedConfigManager() {
        config.put("db.host", "localhost");
        config.put("db.port", "5432");
        System.out.println("[DoubleChecked] Initialised on first call");
    }

    public static DoubleCheckedConfigManager getInstance() {
        if (instance == null) {                          // Check 1: no lock — fast path
            synchronized (DoubleCheckedConfigManager.class) {
                if (instance == null) {                  // Check 2: inside lock — safe
                    instance = new DoubleCheckedConfigManager();
                }
            }
        }
        return instance;
    }

    public String get(String key) { return config.getOrDefault(key, ""); }
}
