import java.util.Stack;

public class trappingWater {
    static long trapWater(int arr[], int n) {
        ///////////// BruteForce Time:O(3*n) Space:O(n) + O(n)///////
        // long res = 0;
        // int[] lMax = new int[n];
        // int[] rMax = new int[n];

        // lMax[0] = arr[0];
        // for(int i = 1;i<n;i++){
        // lMax[i] = Math.max(arr[i], lMax[i-1]);
        // }

        // rMax[n-1] = arr[n-1];
        // for(int i = n-2;i>=0;i--){
        // rMax[i] = Math.max(arr[i], rMax[i+1]);
        // }

        // for(int i = 0;i<n;i++){
        // res = res+(Math.min(lMax[i], rMax[i]) - arr[i]);
        // }

        ////////////////// Optimized Sol -> Time:O(n) Space:O(1) /////////
        int maxL = 0;
        int maxR = 0;
        long res = 0;
        int left = 0;
        int right = n - 1;

        for (int i = 0; i < n; i++) {

            while (left <= right) {
                if (arr[left] <= arr[right]) {
                    if (arr[left] >= maxL) {
                        maxL = arr[left];
                    } else {
                        res += maxL - arr[left];
                    }
                    left++;
                } else {
                    if (arr[right] >= maxR) {
                        maxR = arr[right];
                    } else {
                        res += maxR - arr[right];
                    }
                    right--;
                }
            }

        }
        return res;
    }
}
