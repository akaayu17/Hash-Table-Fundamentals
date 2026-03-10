import java.util.*;

/**
 * AnalyticsDashboard
 *
 * Description:
 * Simulates a real-time website analytics system.
 * Processes page view events and tracks statistics such as:
 * - Total page views
 * - Unique visitors
 * - Traffic sources
 * - Top pages
 *
 * Data Structures Used:
 * HashMap<String, Integer> - Page view counts
 * HashMap<String, Set<String>> - Unique visitors per page
 * HashMap<String, Integer> - Traffic source counts
 *
 * Author: Anjan
 */

public class AnalyticsDashboard {

    private Map<String, Integer> pageViews = new HashMap<>();
    private Map<String, Set<String>> uniqueVisitors = new HashMap<>();
    private Map<String, Integer> trafficSources = new HashMap<>();

    public void processEvent(String url, String userId, String source) {

        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);

        uniqueVisitors.putIfAbsent(url, new HashSet<>());
        uniqueVisitors.get(url).add(userId);

        trafficSources.put(source,
                trafficSources.getOrDefault(source, 0) + 1);
    }

    public void displayTopPages() {

        System.out.println("Top Pages:");

        pageViews.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(10)
                .forEach(System.out::println);
    }

    public void displayTrafficSources() {

        System.out.println("Traffic Sources:");

        for (String source : trafficSources.keySet()) {
            System.out.println(source + " : " + trafficSources.get(source));
        }
    }
}