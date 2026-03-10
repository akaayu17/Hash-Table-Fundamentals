import java.util.*;

class DNSEntry {

    String domain;
    String ipAddress;
    long expiryTime;

    public DNSEntry(String domain, String ipAddress, int ttlSeconds) {

        this.domain = domain;
        this.ipAddress = ipAddress;
        this.expiryTime = System.currentTimeMillis() + (ttlSeconds * 1000);
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }
}
public class DNSCache {

    private int capacity;
    private Map<String, DNSEntry> cache;

    public DNSCache(int capacity) {

        this.capacity = capacity;

        cache = new LinkedHashMap<String, DNSEntry>(capacity, 0.75f, true) {

            protected boolean removeEldestEntry(Map.Entry<String, DNSEntry> eldest) {
                return size() > DNSCache.this.capacity;
            }
        };
    }

    public String resolve(String domain) {

        DNSEntry entry = cache.get(domain);

        if (entry != null && !entry.isExpired()) {
            System.out.println("Cache HIT → " + entry.ipAddress);
            return entry.ipAddress;
        }

        System.out.println("Cache MISS");

        String ip = "172.217.14." + new Random().nextInt(50);

        cache.put(domain, new DNSEntry(domain, ip, 5));

        return ip;
    }

    public static void main(String[] args) {

        DNSCache dns = new DNSCache(5);

        dns.resolve("google.com");
        dns.resolve("google.com");
    }
}