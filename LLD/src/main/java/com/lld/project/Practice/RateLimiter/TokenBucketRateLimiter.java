package com.lld.project.Practice.RateLimiter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter implements RateLimiter {

    private final int capacity;
    private final double refillRate;

    private final Map<String, double[]> buckets = new ConcurrentHashMap<>();

    public TokenBucketRateLimiter(int capacity, double requestsPerSecond) {
        this.capacity = capacity;
        this.refillRate = requestsPerSecond / 1000.0;
    }

    @Override
    public synchronized boolean allowRequest(String clientId) {
        long now = System.currentTimeMillis();

        buckets.putIfAbsent(clientId, new double[]{capacity, now});
        double[] bucket = buckets.get(clientId);

        double elapsed = now - bucket[1];
        bucket[0] = Math.min(capacity, bucket[0] + elapsed * refillRate);
        bucket[1] = now;

        if (bucket[0] >= 1.0) {
            bucket[0] -= 1.0;
            return true;
        }
        return false;
    }
}
