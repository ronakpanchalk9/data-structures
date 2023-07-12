// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[k];
        k %= n;
        if(k > n){
            return;
        }
        for(int i = n-k; i < n; i++){
            temp[i-n+k] = nums[i];
        }
        for(int i = n-k-1; i >= 0; i--){
            nums[i+k] = nums[i];
        }
        for(int i = 0; i < k; i++){
            nums[i] = temp[i];
        }
    }
}
