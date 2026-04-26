package com.lld.project.Singleton.ConfigManager;

public class Main {
    public static void main(String[] args) {
        // All four produce exactly one instance across all callers
        System.out.println(EagerConfigManager.getInstance().get("db.host"));
        System.out.println(SynchronizedConfigManager.getInstance().get("db.host"));
        System.out.println(DoubleCheckedConfigManager.getInstance().get("db.host"));
        System.out.println(AppConfig.INSTANCE.get("db.host"));

        // Identity check — same reference every time
        System.out.println("\nSame instance? " +
                (DoubleCheckedConfigManager.getInstance() ==
                        DoubleCheckedConfigManager.getInstance())); // true
    }
}
