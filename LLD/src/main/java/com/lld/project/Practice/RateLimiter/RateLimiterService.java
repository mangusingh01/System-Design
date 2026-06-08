package com.lld.project.Practice.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterService {

    private final Map<String, RateLimiter> limiters = new ConcurrentHashMap<>();
    private final RateLimiter defaultLimiter;

    public RateLimiterService(RateLimiter defaultLimiter) {
        this.defaultLimiter = defaultLimiter;
    }

    public void register(String clientId, RateLimiter limiter) {
        limiters.put(clientId, limiter);
    }

    public boolean isAllowed(String clientId) {
        RateLimiter limiter = limiters.getOrDefault(clientId, defaultLimiter);
        return limiter.allowRequest(clientId);
    }
}
