import java.util.*;
class Pair{
    int element;
    int frequency;

    Pair(int elem, int freq){
        element = elem;
        frequency = freq;
    }
}
public class stockSpan {
    static int[] calculateSpan(int price[], int n){
        Stack<Pair> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            int current = price[i];

            while(st.size() != 0 && current >= st.peek().element){
                cnt += st.peek().frequency;
                st.pop();
            }
            st.push(new Pair(current, cnt));
            ans[i] = cnt;
        }

        return ans;
    }
}

