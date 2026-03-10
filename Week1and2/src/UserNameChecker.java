import java.util.*;
class UsernameChecker {


    private HashSet<String> usernames = new HashSet<>();


    private HashMap<String, Integer> attempts = new HashMap<>();


    public void registerUser(String username, int id) {
        usernames.add(username);
    }

    public String checkAvailability(String username) {

        attempts.put(username, attempts.getOrDefault(username, 0) + 1);

        if (usernames.contains(username)) {
            return username + " is not available";
        } else {
            return username + " is available";
        }
    }

    public List<String> suggestAlternatives(String username) {

        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            suggestions.add(username + i);
        }

        return suggestions;
    }

    public String getMostAttempted() {

        String maxUser = "";
        int max = 0;

        for (String user : attempts.keySet()) {
            if (attempts.get(user) > max) {
                max = attempts.get(user);
                maxUser = user;
            }
        }

        return maxUser;
    }

    public static void main(String[] args) {

        UsernameChecker service = new UsernameChecker();

        service.registerUser("john_doe", 1);

        System.out.println(service.checkAvailability("john_doe"));
        System.out.println(service.checkAvailability("jane_smith"));

        System.out.println(service.suggestAlternatives("john_doe"));

        System.out.println("Most attempted: " + service.getMostAttempted());
    }
}