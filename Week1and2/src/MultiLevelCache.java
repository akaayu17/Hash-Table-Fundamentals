import java.util.*;

/**
 * MultiLevelCache
 *
 * Description:
 * Simulates a multi-level caching system similar to
 * those used in video streaming platforms.
 *
 * Levels:
 * L1 - Memory cache (fast)
 * L2 - Secondary cache
 * L3 - Database
 */

public class MultiLevelCache {

    private Map<String, String> L1 = new LinkedHashMap<>();
    private Map<String, String> L2 = new HashMap<>();
    private Map<String, String> L3 = new HashMap<>();

    public MultiLevelCache() {

        L3.put("video1", "Video Data 1");
        L3.put("video2", "Video Data 2");
    }

    public String getVideo(String id) {

        if (L1.containsKey(id)) {

            return "L1 Cache HIT: " + L1.get(id);
        }

        if (L2.containsKey(id)) {

            String data = L2.get(id);
            L1.put(id, data);
            return "L2 Cache HIT: " + data;
        }

        if (L3.containsKey(id)) {

            String data = L3.get(id);
            L2.put(id, data);
            return "Database HIT: " + data;
        }

        return "Video not found";
    }
}