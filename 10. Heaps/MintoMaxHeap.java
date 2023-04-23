// You are given an array arr of N integers representing a min Heap. The task is to convert it to max Heap.

// A max-heap is a complete binary tree in which the value in each internal node is greater than or equal to the values in the children of that node
public class MintoMaxHeap {
    static void heapify(int i, int N, int[] arr){
        int l = 2*i+1;
        int r = 2*i+2;
        int greatest = i;

        if(l < N && arr[l] > arr[greatest]){
            greatest = l;
        }
        if(r < N && arr[r] > arr[greatest]){
            greatest = r;
        }
        if(i != greatest){
            int temp = arr[i];
            arr[i] = arr[greatest];
            arr[greatest] = temp;
            heapify(greatest, N, arr);
        }
    }
    static void convertMinToMaxHeap(int N, int arr[]) {
        // code here
        for (int i = N/2; i >= 0; i--) {
            heapify(i, N, arr);
        }
      }
}
