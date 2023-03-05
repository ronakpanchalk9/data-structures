
// Given an array arr[ ] of size N having elements, the task is to find the next greater element for each element of the array in order of their appearance in the array.
// Next greater element of an element in the array is the nearest element on the right which is greater than the current element.
// If there does not exist next greater of current element, then next greater element for current element is -1. For example, next greater of the last element is always -1.
import java.util.*;

public class nextGreater {
    // arr[] = [1 3 2 4]
    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> st = new Stack<>();
        long[] ans = new long[n];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (st.size() == 0) {
                ans[i] = -1;
                st.push(arr[i]);
            }else{
                while (st.size() != 0) {
                    if (st.peek() <= arr[i]) {
                        st.pop();
                    } else {
                        ans[i] = st.peek();
                        st.push(arr[i]);
                        break;
                    }
                }
                if(st.size() == 0){
                    st.push(arr[i]);
                ans[i] = -1;
                }
                
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        long[] arr = {1,3,2,4};
        int nm = 4;
        System.out.println(Arrays.toString(nextLargerElement(arr, nm)));
    }
}
