import java.util.*;

/**
 * RateLimiter
 *
 * Description:
 * Implements an API rate limiter using the Token Bucket algorithm.
 * Limits the number of requests each client can make.
 */

public class RateLimiter {

    private Map<String, TokenBucket> clients = new HashMap<>();

    public boolean allowRequest(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(5));

        TokenBucket bucket = clients.get(clientId);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }
}