// Find all valid combinations of K numbers that sum upto to N such that the following conditions are true:

// Only number 1 through 9 are used.
// Each number is used atmost once.
// Return the list of all possible valid combinations.

// Note: The list must not contain the same combination twice, and the combinations returned in any order.

import java.util.*;

public class combination_sum3 {
    static void generate(int idx, int k, int sum, ArrayList<ArrayList<Integer>> finans, ArrayList<Integer> temp,
            int[] arr) {
        if (idx == arr.length) {
            if (sum == 0 && temp.size() == k) {
                finans.add(new ArrayList<>(temp));
            }
            return;
        }

        if (sum >= arr[idx]) {
            temp.add(arr[idx]);
            generate(idx + 1, k, sum - arr[idx], finans, temp, arr);
            temp.remove(temp.size() - 1);
        }
        generate(idx + 1, k, sum, finans, temp, arr);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int k, int n) {
        ArrayList<ArrayList<Integer>> finans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        generate(0, k, n, finans, temp, arr);
        return finans;
    }
}