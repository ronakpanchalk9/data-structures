// Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a number of contiguous bars. For simplicity, assume that all bars have the same width and the width is 1 unit, there will be N bars height of each bar will be given by the array arr.

import java.util.*;
class Pair{
    long element;
    long frequency;
    Pair(long elem, long minFreq){
        element = elem;
        frequency = minFreq;
    }
}
public class maxRectangle {
    static long getMaxArea(long hist[], long n){
        Stack<Pair> st = new Stack<>();
        long[] left = new long[(int)n];
        long[] right = new long[(int)n];

        for (int i = 0; i < n; i++) {
            long curr = hist[i];
            long cnt = 1;
            while(st.size() != 0 && curr < st.peek().element){
                cnt += st.peek().frequency;
                st.pop();
            }
            st.push(new Pair(curr, cnt));
            left[i] = cnt;
        }

        st.clear();

        for (int i = hist.length - 1; i >= 0; i--) {
            long curr = hist[i];
            long cnt = 1;
            while(st.size() != 0 && curr <= st.peek().element){
                cnt += st.peek().frequency;
                st.pop();
            }
            st.push(new Pair(curr, cnt));
            right[i] = cnt;
        }
        long ans = 0;

        for (int i = 0; i < hist.length; i++) {
            long area = hist[i] * (left[i] + right[i] - 1);
            if(area > ans){
                ans = area;
            }
        }
        return ans;
    }
}
