//Q.Given a sorted array arr[] of size N. Find the element that appears only once in the array. All other elements appear exactly twice.

public class single_element {
    // All elements before the required element have the first occurrence at even
    // index and next occurrence at odd index.
    // All elements after the required element have the first occurrence at odd
    // index and next occurrence at even index
    public static int binarySearch(int[] arr, int low, int high) {
        int mid = -1;

        if (low > high) {
            return -1;
        }

        while (low < high) {
            mid = low + (high - low) / 2;

            if (mid % 2 != 0) {
                if (arr[mid] == arr[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (arr[mid] == arr[mid + 1]) {
                    low = mid + 2;
                } else {
                    high = mid;
                }

            }
        }

        return low;
    }

    public static int findOnce(int[] arr, int n) {
        int idx = binarySearch(arr, 0, n - 1);
        return arr[idx];
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,5,6,6,7};
        System.out.println(findOnce(arr, arr.length));
        
    }
}
