// You are given a collection of numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to the target. Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.

import java.util.*;

public class combination_sum2 {
    static void generate(int[] a, int target, int idx, List<List<Integer>> finans, List<Integer> temp) {
        if (target == 0) {
            finans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = idx; i < a.length; i++) {
            if (i > idx && a[i] == a[i - 1]) {
                continue;
            }
            if (a[i] > target) {
                break;
            }
            temp.add(a[i]);
            generate(a, target - a[i], i + 1, finans, temp);
            temp.remove(temp.size() - 1);
        }

    }

    public static List<List<Integer>> combinationSum2(int[] a, int s) {
        Arrays.sort(a);
        List<List<Integer>> finans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        generate(a, s, 0, finans, temp);
        return finans;
    }

}
