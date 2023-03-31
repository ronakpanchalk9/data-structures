// You are given array nums of n elements and integer K, and count the number of subarrays that has k odd numbers.
public class sub_k_odds {
    static int countSubarray(int n, int[] nums, int k) {
        int left = 0;
        int right = 0;
        int numOfOdds = 0;
        int count = 0;

        while (right < n) {
            if (nums[right] % 2 != 0) {
                numOfOdds++;
            }

            while(numOfOdds > k){
                if(nums[left] % 2 != 0){
                    left++;
                    numOfOdds--;
                }else{
                    left++;
                }
            }

            if (numOfOdds == k) {
                count++;
                int i = left;
                while (i < right && nums[i] % 2 == 0) {
                    count++;
                    i++;
                }
            }

            right++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,5,3,2,4,5,2,6};
    }
}
