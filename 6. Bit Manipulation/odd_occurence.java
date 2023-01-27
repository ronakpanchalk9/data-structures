// Given an array of N positive integers where all numbers occur even number of times except one number which occurs odd number of times. Find the exceptional number.
public class odd_occurence {
    static int getOddOccurence(int[] arr, int n){
        int ans = arr[0];
        for (int i = 1; i < n; i++) {
            ans ^= arr[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
