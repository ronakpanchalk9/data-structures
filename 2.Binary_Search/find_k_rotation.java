public class find_k_rotation {
/*Given an ascending sorted rotated array Arr of distinct integers of size N. The array is right rotated K times. Find the value of K.

Just find the pivot(largest element in the array, pivot+1 index will be the answer */

    public static int findK(int[] arr, int n) {
        int high = n - 1;
        int low = 0;

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (mid < high && arr[mid] > arr[mid+1]) {
                return mid+1;
            }
            if(mid > low && arr[mid] < arr[mid-1]){
                return mid;
            }
            if(arr[low] >= arr[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}