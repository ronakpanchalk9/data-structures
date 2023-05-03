// Given a non-empty array of integers, find the top k elements which have the highest frequency in the array. If two numbers have the same frequency then the larger number should be given preference. 

// Note: Print the elements according to the frequency count (from highest to lowest) and if the frequency is equal then larger number will be given preference.

import java.util.*;

public class top_k_frequency {
    static class Pair implements Comparable<Pair> {
        int value;
        int element;

        Pair(int element, int value) {
            this.value = value;
            this.element = element;
        }

        public int compareTo(Pair p) {
            return p.element - this.element;
        }
    }

    public static int[] topk(int[] nums, int k) {
        int[] ans = new int[k];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> mpp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mpp.put(nums[i], mpp.getOrDefault(nums[i], 0) + 1);
        }

        mpp.forEach((key,val)
                    ->pq.add(new Pair(key, val)));

        // for (int i = 0; i < nums.length; i++) {
        //     pq.add(new Pair(mpp.get(nums[i]), nums[i]));
        // }

        int i = 0;

        while (k-- != 0) {
            ans[i++] = pq.poll().value;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(Arrays.toString(topk(arr, k)));
    }
}
