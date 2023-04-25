import java.util.*;
public class k_smallest {
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //ForMinHeap
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);
        }

       

        while(k-1>0){
            pq.remove();
            k--;
        }
        
        return pq.peek();
    } 
    public static void main(String[] args) {
        
    }
}
