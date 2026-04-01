import java.util.*;

public class Problem6 {

    // Linear Search (unsorted)
    public static void linearSearch(int[] arr, int target) {
        int comparisons = 0;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;
            if (arr[i] == target) {
                found = true;
                break;
            }
        }

        System.out.println("Linear Search:");
        if (found)
            System.out.println("Found");
        else
            System.out.println("Not Found");

        System.out.println("Comparisons: " + comparisons);
    }

    //  Binary Search for insertion + floor + ceiling
    public static void binarySearchVariants(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int comparisons = 0;

        int floor = -1;
        int ceiling = -1;

        while (low <= high) {
            comparisons++;
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                floor = arr[mid];
                ceiling = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];     // possible floor
                low = mid + 1;
            } else {
                ceiling = arr[mid];   // possible ceiling
                high = mid - 1;
            }
        }

        int insertionPoint = low;

        System.out.println("\nBinary Search:");
        System.out.println("Insertion Index: " + insertionPoint);
        System.out.println("Floor: " + (floor == -1 ? "none" : floor));
        System.out.println("Ceiling: " + (ceiling == -1 ? "none" : ceiling));
        System.out.println("Comparisons: " + comparisons);
    }

    public static void main(String[] args) {

        int[] unsorted = {50, 10, 100, 25};   // unsorted
        int[] sorted = {10, 25, 50, 100};     // sorted

        int target = 30;

        // Linear Search
        linearSearch(unsorted, target);

        // Binary Search Variants
        binarySearchVariants(sorted, target);
    }
}