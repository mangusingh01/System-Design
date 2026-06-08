package com.lld.project.Practice.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowRateLimiter implements RateLimiter {

    private final int limit;
    private final long windowMs;

    private final Map<String, long[]> windows = new ConcurrentHashMap<>();

    public FixedWindowRateLimiter(int limit, long windowMs) {
        this.limit = limit;
        this.windowMs = windowMs;
    }

    @Override
    public synchronized boolean allowRequest(String clientId) {
        long now = System.currentTimeMillis();
        windows.putIfAbsent(clientId, new long[]{0, now});
        long[] window = windows.get(clientId);

        long windowStart = window[1];
        long count = window[0];

        if (now - windowStart >= windowMs) {
            window[0] = 1;
            window[1] = now;
            return true;
        }

        if (count < limit) {
            window[0]++;
            return true;
        }
        return false;
    }
}
