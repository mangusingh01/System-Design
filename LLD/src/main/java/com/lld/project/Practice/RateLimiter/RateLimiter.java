package com.lld.project.Practice.RateLimiter;

public interface RateLimiter {
    boolean allowRequest(String clientId);
}
