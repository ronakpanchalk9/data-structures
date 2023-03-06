// Given an array of N integers and Q queries of indices, print the number of next greater elements(NGEs) to the right of the given index element. 
import java.util.*;

public class nextGreaterElements {
    public static int[] count_NGEs(int n, int arr[], int queries, int indices[]){
        //Brute Force
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[queries];
        
        for (int i = 0; i < queries; i++) {
            int cnt = 0;
            for (int j = indices[i]; j < n; j++) {
                if(arr[j] > arr[indices[i]]){
                    cnt++;
                }
                ans[i] = cnt;
            }
        }
        return ans;
    }
}
