
// Given an array arr of size N containing positive integers, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since answer may be very large, return the answer modulo 109 +7. 
import java.util.*;

class Pair {
    int element;
    int minFreq;

    Pair(int elem, int nm) {
        element = elem;
        minFreq = nm;
    }
}

public class subarray_Min_sum {
    public static int sumSubarraySum(int[] arr, int n) {
        /////////////////////// BRUTE FORCE time -> O(n^2) Space-> O(n)
        /////////////////////// //////////////////////////
        Stack<Integer> st = new Stack<>();
        int min = arr[0];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];

                }
                sum += min;
            }
        }
        while (st.size() != 0) {
            sum += st.pop();
        }
        // return sum % (1000000007);

        //////////////// OPTIMIZED SOLUTION//////////
        int m = 1000000007;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Pair> st1 = new Stack<>();
        Stack<Pair> st2 = new Stack<>();

        // Filling Left Array

        for (int i = 0; i < n; i++) {
            int current = arr[i];
            int count = 1;

            while (st1.size() != 0 && st1.peek().element > current) {
                count += st1.peek().minFreq;
                st1.pop();
            }
            st1.push(new Pair(current, count));
            left[i] = count;
        }

        // Filling Right Array

        for (int i = n - 1; i >= 0; i--) {
            int current = arr[i];
            int count = 1;

            while (st2.size() != 0 && st2.peek().element >= current) {
                count += st2.peek().minFreq;
                st2.pop();
            }
            st2.push(new Pair(current, count));
            right[i] = count;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long aslicnt = (left[i] * right[i]) % m;
            ans += (aslicnt * arr[i]) % m;
            ans %= m;
        }

        return (int) (ans);
    }
}
