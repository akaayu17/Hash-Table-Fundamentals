import java.util.*;

/**
 * TransactionAnalyzer
 *
 * Description:
 * Detects transaction pairs that sum to a given target.
 * Useful for fraud detection or financial analysis.
 */

public class TransactionAnalyzer {

    public List<int[]> findTwoSum(int[] transactions, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        for (int num : transactions) {

            int complement = target - num;

            if (map.containsKey(complement)) {

                result.add(new int[]{num, complement});
            }

            map.put(num, 1);
        }

        return result;
    }
}