// Given an unsorted array, Arr[] of size N and that contains even number of occurrences for all numbers except two numbers. Find the two numbers in decreasing order which has odd occurrences.

public class two_odd_num {
    public static int[] twoOdd(int arr[], int n) {
        int odd1 = 0;
        int odd2 = 0;
        int temp = 0;
        int setbit = 0;
        int[] ans = new int[2];

        for (int i = 0; i < n; i++) {
            temp ^= arr[i];
        }

        for (int i = 0; i < 31; i++) {
            int curr = 1 << i;
            if ((temp & curr) != 0) {
                setbit = curr;
                break;
            }
        }
        
        for (int i = 0; i < n; i++) {
            if ((arr[i] & setbit) != 0) {
                odd1 ^= arr[i];
            } else {
                odd2 ^= arr[i];
            }
        }

        if (odd1 > odd2) {
            ans[0] = odd1;
            ans[1] = odd2;
        } else {
            ans[0] = odd2;
            ans[1] = odd1;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
