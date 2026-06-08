package com.lld.project.Practice.RateLimiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        RateLimiter sliding = RateLimiterFactory.create(
                RateLimiterType.SLIDING_WINDOW, 3, 5000
        );

        RateLimiter premium = new TokenBucketRateLimiter(10, 5);

        RateLimiterService service = new RateLimiterService(sliding);
        service.register("premium-client", premium);

        String[] clients = {"user-1", "user-1", "user-1", "user-1", "premium-client",
                "premium-client", "premium-client"};

        for (String clientId : clients) {
            boolean allowed = service.isAllowed(clientId);
            System.out.printf("[%s] %s -> %s%n",
                    clientId,
                    allowed ? "ALLOWED" : "DENIED",
                    allowed ? "200 OK" : "429 Too Many Requests"
            );
        }
    }
}
