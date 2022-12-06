public class least_weight_capacity {

    //Given an array arr[] of N weights. Find the least weight capacity of a boat to ship all weights within D days. 
    
    //The ith weight has a weight of arr[i]. Each day, we load the boat with weights given by arr[i].We may not load more weight than the maximum weight capacity of the ship.

    //Note: You have to load weights on the boat in the given order

    static int leastWeightCapacity(int[] arr, int n, int d){
        int high = 0;
        int low = 0;
        int ans = 0;

        for(int i : arr){
            high += i;
            low = Math.max(low, i);
        }

        if(n == d){
            return low;
        }

        while(low <= high){
            int mid = (low+high)>>1;

            if(isPossible(arr, mid, d)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    static boolean isPossible(int[] arr, int mid, int d) {
        int daysCheck = 1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(sum > mid){
                daysCheck++;
                sum = arr[i];
            }
        }
        return daysCheck <= d;
    }

    public static void main(String[] args) {
        
    }
}
