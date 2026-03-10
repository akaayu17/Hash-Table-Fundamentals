import java.util.*;

/**
 * AutocompleteSystem
 *
 * Description:
 * Implements a search autocomplete feature.
 * Stores search queries with frequency counts
 * and suggests top results for a given prefix.
 */

public class AutocompleteMain {

    private Map<String, Integer> queries = new HashMap<>();

    public void addQuery(String query) {

        queries.put(query, queries.getOrDefault(query, 0) + 1);
    }

    public List<String> search(String prefix) {

        List<String> results = new ArrayList<>();

        for (String q : queries.keySet()) {

            if (q.startsWith(prefix))
                results.add(q);
        }

        results.sort((a, b) -> queries.get(b) - queries.get(a));

        return results.subList(0, Math.min(10, results.size()));
    }
}