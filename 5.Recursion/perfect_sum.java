// Given an array arr[] of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

// Note: Answer can be very large, so, output answer modulo 109+7

public class perfect_sum {
    public int sumcheck(int[] arr, int sum, int count, int idx, int check){
        if(idx == arr.length){
            if(check == sum){
                count++;
            }
            return count%(100000000 + 7);
        }

        check += arr[idx];
        int take = sumcheck(arr, sum, count, idx+1, check);

        check -= arr[idx];
        int not_take = sumcheck(arr, sum, count, idx+1, check);
        
        return (take + not_take)%(100000000 + 7);
    }
    public int perfectSum(int[] arr, int n, int sum){
        return sumcheck(arr, sum, 0, 0, 0);
    }
}
