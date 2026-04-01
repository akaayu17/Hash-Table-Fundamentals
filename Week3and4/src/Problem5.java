import java.util.*;

public class Problem5 {

    // Linear Search (first + last occurrence)
    public static void linearSearch(String[] arr, String target) {
        int first = -1, last = -1;
        int comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear Search:");
        System.out.println("First occurrence: " + first);
        System.out.println("Last occurrence: " + last);
        System.out.println("Comparisons: " + comparisons);
    }

    //  Binary Search (find one occurrence)
    public static int binarySearch(String[] arr, String target, Counter counter) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            counter.count++;
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // Count occurrences (left + right expansion)
    public static int countOccurrences(String[] arr, String target, int index) {
        if (index == -1) return 0;

        int count = 1;

        int left = index - 1;
        while (left >= 0 && arr[left].equals(target)) {
            count++;
            left--;
        }

        int right = index + 1;
        while (right < arr.length && arr[right].equals(target)) {
            count++;
            right++;
        }

        return count;
    }

    static class Counter {
        int count = 0;
    }

    public static void main(String[] args) {

        String[] logs = {"accA", "accB", "accB", "accC"}; // sorted

        String target = "accB";

        //  Linear Search
        linearSearch(logs, target);

        //Binary Search
        Counter counter = new Counter();
        int index = binarySearch(logs, target, counter);

        int count = countOccurrences(logs, target, index);

        System.out.println("\nBinary Search:");
        System.out.println("Found at index: " + index);
        System.out.println("Count: " + count);
        System.out.println("Comparisons: " + counter.count);
    }
}