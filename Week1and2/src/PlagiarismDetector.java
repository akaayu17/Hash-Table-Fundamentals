import java.util.*;

/**
 * PlagiarismDetector
 *
 * Detects plagiarism by comparing n-grams of documents.
 */

public class PlagiarismDetector {

    private Map<String, Set<String>> index = new HashMap<>();

    public void addDocument(String id, String text) {

        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 4; i++) {

            String gram = words[i] + " " + words[i + 1] + " " +
                    words[i + 2] + " " + words[i + 3] + " " + words[i + 4];

            index.putIfAbsent(gram, new HashSet<>());

            index.get(gram).add(id);
        }
    }

    public Set<String> check(String text) {

        Set<String> matches = new HashSet<>();

        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 4; i++) {

            String gram = words[i] + " " + words[i + 1] + " " +
                    words[i + 2] + " " + words[i + 3] + " " + words[i + 4];

            if (index.containsKey(gram))
                matches.addAll(index.get(gram));
        }

        return matches;
    }
}