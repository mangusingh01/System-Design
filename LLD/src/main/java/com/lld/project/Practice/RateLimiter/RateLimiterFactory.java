package com.lld.project.Practice.RateLimiter;

public class RateLimiterFactory {

    public static RateLimiter create(RateLimiterType type, int limit, long windowMs) {
        return switch (type) {
            case TOKEN_BUCKET    -> new TokenBucketRateLimiter(limit, limit);
            case FIXED_WINDOW    -> new FixedWindowRateLimiter(limit, windowMs);
            case SLIDING_WINDOW  -> new SlidingWindowRateLimiter(limit, windowMs);
        };
    }
}
