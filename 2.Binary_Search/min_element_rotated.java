public class min_element_rotated {
    public static int pivotBinarySearch(int[] arr, int low, int high) {
        if(high < low){
            return -1;
        }
        if(high == low){
            return low;
        }

        int mid = low + (high-low)/2;

        if(mid < high && arr[mid] > arr[mid+1]){
            return mid;
        }
        if(mid > low && arr[mid] < arr[mid-1]){
            return mid-1;
        }
        if(arr[low] >= arr[mid]){
            return pivotBinarySearch(arr, low, mid-1);
        }

        return pivotBinarySearch(arr, mid+1, high);
    }

    public static int findMin(int[] arr, int n){
        int pivot = pivotBinarySearch(arr,0,n-1);
        return arr[pivot+1];
    }
    
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,4,5,7};
        int n = arr.length;
        System.out.println(findMin(arr, n-1));
    }
}
