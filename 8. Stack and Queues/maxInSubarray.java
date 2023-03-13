// Given an array arr[] of size N and an integer K. Find the maximum for each and every contiguous subarray of size K.
import java.util.*;
public class maxInSubarray{
    static ArrayList<Integer> max_of_subarray(int[] a, int n, int k){
        ArrayList<Integer> ans = new ArrayList<>();
        
        // store index
        Deque < Integer > q = new ArrayDeque < > ();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                ans.add(a[q.peek()]);
            }
        }
        return ans;
    }
}