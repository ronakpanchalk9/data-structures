// Given a circular interger array arr of size N (i.e ., the next element of arr [N-1] is arr[0] ), return the next greater number for every element in arr.
// The next greater element of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

import java.util.*;

public class nextGreater2 {
    static int[] nextGreaterElement(int n, int arr[]){
        Stack<Integer> st  = new Stack<>();
        int[] ans = new int[n];

        for (int i = arr.length -1; i >= 0; i--) {
            st.push(arr[i]);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            while(st.size() != 0){
                if(arr[i] >= st.peek()){
                    st.pop();
                }else{
                    arr[i] = st.peek();
                    st.push(arr[i]);
                    break;
                }
            }
            if(st.size() == 0){
                st.push(arr[i]);
                arr[i] = -1;
            }
        }
        return ans;
    }
}
