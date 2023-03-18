// You are given array nums of n length and an integer k .return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
public class maximum_ones {
    static int longestOnes(int n, int[] nums, int k) {
        int zeroes = k;
        int beg = 0;
        int end = 0;
        int max = 0;

        while (end < n) {
            if(nums[end] == 0 && zeroes > 0){
                zeroes--;
            }else if(nums[end] == 0 && zeroes <= 0){
                while(nums[beg] != 0){
                    beg++;
                }
                beg++;
                zeroes = 0;
            }
            max = Math.max(max, end - beg + 1);
            end++;
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 11;
        int[] nums = { 1, 1, 1, 0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(n, nums, k));
    }
}
