public class remove_duplicates {    
    public static void swap(int a, int b, int[] arr) {
        int temp = 0;
        temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public static int remove_duplicates1(int[] A, int N) {
        int pt1 = 0;
        int pt2 = 1;
        int k = 1;
        for (int i = 1; i < N; i++) {
            if (A[pt1] == A[pt2]) {
                pt2++;
            } else {
                swap(pt1 + 1, pt2, A);
                pt1++;
                pt2++;
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,2,4,5,6,6,6,7,7,7,8,9,10,10,10};

        System.out.println(remove_duplicates1(arr, arr.length));
        
        // remove_duplicates1(arr, 3);
    }
}
