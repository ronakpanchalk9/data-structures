import java.util.ArrayList;

// You are given an integer array nums that may contain duplicates. Your task is to return all possible subsets. Return only unique subsets and they can be in any order.

public class subset {
    static void generate(ArrayList<ArrayList<Integer>> finans, ArrayList<Integer> temp, int idx, int[] arr) {
        if (idx == arr.length) {
            if (!finans.contains(temp)) {
                finans.add(new ArrayList<>(temp));
            }

            return;
        }

        temp.add(arr[idx]);
        generate(finans, temp, idx + 1, arr);
        temp.remove(temp.size() - 1);
        generate(finans, temp, idx + 1, arr);
    }

    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        ArrayList<ArrayList<Integer>> finans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        generate(finans, temp, 0, nums);
        return finans;
    }
}
