// Given an integer array Arr of size N. For each element in the array, check whether the right adjacent element (on the next immediate position) of the array is smaller. If next element is smaller, update the current index to that element. If not, then  -1.

import java.util.Stack;

public class immediateSmall {
    void immediateSmaller(int arr[], int n){
        Stack<Integer> st = new Stack<>();

        for (int i = arr.length -1; i >= 0; i--) {
            if(st.size() == 0){
                st.push(arr[i]);
                arr[i] = -1;
            }else{
                if(st.peek() < arr[i]){
                    int temp = arr[i];
                    arr[i] = st.peek();
                    st.push(temp);
                }else{
                    st.push(arr[i]);
                    arr[i] = -1;
                }
            }
        }
    }
}
