// Given an array and a number k, find the largest sum of the subarray containing at least k numbers. It may be assumed that the size of array is at-least k.


//Use Kadane's Algo make a array of size n with maximum sum of subarrays. Then create a window of K elements and move it till N. Keep adding the maximum sum to that window to find the greatest sum of atleast k-elements.

//Time Complexity - O(n), Space- O(n)


public class maxSumWith_K {
    static long maxSumWithK(long a[], long n, long k) {

        long ans = Integer.MIN_VALUE;

        long[] maxSum = new long[(int) n];

        long currSum = a[0];
        maxSum[0] = currSum;

        for (int i = 1; i < maxSum.length; i++) {
            if (currSum > 0) {
                currSum += a[i];
            } else {
                currSum = a[i];
            }
            maxSum[i] = currSum;
        }

        long exactK = 0;

        for (int i = 0; i < k; i++) {
            exactK += a[i];
        }

        if (exactK > ans) {
            ans = exactK;
        }

        for (int i = (int) k; i < n; i++) {
            exactK = exactK + a[(int) i] - a[(int) (i - k)];

            if (exactK > ans) {
                ans = exactK;
            }

            long morethanK = maxSum[(int) (i - k)] + exactK;

            if (morethanK > ans) {
                ans = morethanK;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(-242534 >> 1);
    }
}
