// Given an input stream arr[] of n integers. Find the Kth largest element for each element in the stream and if the Kth element doesn't exist, return -1

import java.util.*;
public class kth_largest_stream {
    static int[] kthlargest(int k, int[] arr, int n){
        int[] ans = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int j = 0;
        
        for(int i = 0; i < n; i++){
            pq.add(arr[i]);
            if(pq.size() < k){
                ans[j++] = -1;
            }else{
                if(pq.size() > k){
                    pq.remove();
                    ans[j++] = pq.peek();
                }else if(pq.size() == k){
                    ans[j++] = pq.peek();
                }
            }    
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {4,2,5,6,3,1};
        int k = 4;
        System.out.println(Arrays.toString(kthlargest(k, arr, arr.length)));
    }
}
