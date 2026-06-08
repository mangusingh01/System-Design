package com.lld.project.Practice.RateLimiter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter implements RateLimiter {

    private final int limit;
    private final long windowMs;

    private final Map<String, Deque<Long>> logs = new ConcurrentHashMap<>();

    public SlidingWindowRateLimiter(int limit, long windowMs) {
        this.limit = limit;
        this.windowMs = windowMs;
    }

    @Override
    public synchronized boolean allowRequest(String clientId) {
        long now = System.currentTimeMillis();
        long windowStart = now - windowMs;

        logs.putIfAbsent(clientId, new ArrayDeque<>());
        Deque<Long> log = logs.get(clientId);

        while (!log.isEmpty() && log.peekFirst() <= windowStart) {
            log.pollFirst();
        }

        if (log.size() < limit) {
            log.addLast(now);
            return true;
        }
        return false;
    }
}

