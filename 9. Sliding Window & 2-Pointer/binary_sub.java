// Given a binary array arr of size N and an integer target, return the number of non-empty subarrays with a sum equal to target.
public class binary_sub {
    static int numOfSubarrays(int arr[], int N, int target) {
        int left = 0, right = 0;
        int sum = 0, count = 0;
        while (right < N) {
            sum += arr[right];
            while (left < right && sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                count++;
                int i = left;
                while (i < right && arr[i] == 0) {
                    count++;
                    i++;
                }
            }
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0,
                1, 1, 1, 0, 1, 1, 0, 1, 1 };
        int N = 42;
        int target = 30;
        System.out.println(arr.length);

        System.out.println(numOfSubarrays(arr, N, target));
    }
}
