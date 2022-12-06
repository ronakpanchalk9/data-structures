//Given an increasing sequence a[], we need to find the K-th missing contiguous element in the increasing sequence which is not present in the sequence. If no k-th missing element is there output -1.


public class kth_missing_element {
    static int kthMissingElement(int a[], int n, int k) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = (low + high) >> 1;

            int missing_till_mid = a[mid] - (mid + a[0]);

            if (missing_till_mid < k) {
                low = mid + 1;
            } else { // missing_till_mid >= k
                high = mid - 1;
            } 

        }

        if (low == n) {
            return -1;
        } else {
            return (low - 1 + a[0] + k);
        }
    }

    public static void main(String[] args) {

    }
}
