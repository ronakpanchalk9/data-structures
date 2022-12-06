public class search_in_rotated {
    public static int binarySearch(int[] arr, int low, int hi, int key) {

        if(hi < low){
            return -1;
        }

        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static int findPivot(int arr[], int low, int hi){
        if(hi < low){
            return -1;
        }
        if(hi == low){
            return low;
        }
        int mid = low + (hi - low)/2;

        if(mid < hi && arr[mid] > arr[mid+1]){
            return mid;
        }

        if(mid > low && arr[mid] < arr[mid-1]){
            return (mid-1);
        }

        if(arr[low] >= arr[mid]){
            return findPivot(arr, low, mid-1);
        }
        return findPivot(arr, mid+1, hi);
    }

    // Optimal solution of this to solve in O(logN)
    // Using Pivot method

    public static int search(int[] arr, int low, int hi, int key) {
        int pivot = findPivot(arr, low, hi);

        if(pivot == -1){
            return binarySearch(arr, low, hi, key);
        }

        if(arr[pivot] == key){
            return pivot;
        }

        if (arr[0] <= key){
            return binarySearch(arr, 0, pivot - 1, key);
        }
        
        return binarySearch(arr, pivot + 1, hi, key);
        // return -1;
    }

    public static void main(String[] args) {

    }
}