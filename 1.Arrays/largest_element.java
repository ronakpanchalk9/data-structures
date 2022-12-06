
public class largest_element {
    public static int findLargestElement(int[] arr, int n) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,7,1,4,2};
        System.out.println(findLargestElement(arr, arr.length));
        
    }
}