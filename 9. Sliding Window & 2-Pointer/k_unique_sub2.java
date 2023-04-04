
// Given an integer array arr of size N and an integer k, return the number of good subarrays of arr.
// A good array is an array where the number of different integers in that is exactly k.
import java.util.*;

public class k_unique_sub2 {
    static int atmost(int arr[], int n, int k) {
        int left = 0;
        int right = 0;
        int count = 0;

        HashMap<Integer, Integer> mpp = new HashMap<>();

        while (right < n) {
            mpp.put(arr[right], mpp.getOrDefault(arr[right], 0) + 1);

            if (mpp.size() > k) {
                while (mpp.size() != k) {
                    mpp.put(arr[left], mpp.get(arr[left]) - 1);
                    if (mpp.get(arr[left]) == 0) {
                        mpp.remove(arr[left]);
                    }
                    left++;
                }
            }

            if (mpp.size() <= k) {
                count += right - left + 1;
            }

            right++;
        }
        return count;
    }

    static int subarrayCount(int arr[], int n, int k) {
        return atmost(arr, n, k) - atmost(arr, n, k-1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 1, 1, 6, 2, 1, 1 };
        int k = 3;
        int n = arr.length;
        System.out.println(subarrayCount(arr, n, k));
    }
}
