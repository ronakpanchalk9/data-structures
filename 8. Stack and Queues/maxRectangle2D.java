// Given a binary matrix M of size n X m. Find the maximum area of a rectangle formed only of 1s in the given matrix.
import java.util.*;
class Pair{
    int element;
    int frequency;
    Pair(int elem, int minFreq){
        element = elem;
        frequency = minFreq;
    }
}

public class maxRectangle2D {
    static int getMaxArea(int hist[], int n){
        Stack<Pair> st = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            int curr = hist[i];
            int cnt = 1;
            while(st.size() != 0 && curr < st.peek().element){
                cnt += st.peek().frequency;
                st.pop();
            }
            st.push(new Pair(curr, cnt));
            left[i] = cnt;
        }

        st.clear();

        for (int i = hist.length - 1; i >= 0; i--) {
            int curr = hist[i];
            int cnt = 1;
            while(st.size() != 0 && curr <= st.peek().element){
                cnt += st.peek().frequency;
                st.pop();
            }
            st.push(new Pair(curr, cnt));
            right[i] = cnt;
        }
        int ans = 0;

        for (int i = 0; i < hist.length; i++) {
            int area = hist[i] * (left[i] + right[i] - 1);
            if(area > ans){
                ans = area;
            }
        }
        return ans;
    }
    
    static int maxArea(int arr[][] ,int n,int m){
        int maxArea = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 1){
                    arr[i][j] += arr[i-1][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if(getMaxArea(arr[i], n) > maxArea){
                maxArea = getMaxArea(arr[i], n);
            }
        }
        return maxArea;
    }
}