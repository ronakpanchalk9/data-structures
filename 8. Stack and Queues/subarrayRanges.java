import java.util.Stack;

class Pair{
    int element;
    int minFreq;

   Pair(int elem, int min){
        element = elem;
        minFreq = min;
    }
}
public class subarrayRanges {
    public static long subRanges(int n, int[] arr){
        Stack<Pair> st = new Stack<>();

        int[] leftmin = new int[n];
        int[] rightmin = new int[n];

        int[] leftmax = new int[n];
        int[] rightmax = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int cnt = 1;

            while(st.size() != 0 && arr[i] > st.peek().element ){
                cnt += st.peek().minFreq;
                st.pop();
            }
            st.push(new Pair(curr, cnt));
            leftmin[i] = cnt;
        }

        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            int cnt = 1;
            while(st.size() != 0 && arr[i] >= st.peek().element ){
                cnt += st.peek().minFreq;
                st.pop();
            }
            st.push(new Pair(curr, cnt));
            rightmin[i] = cnt;
        }

        while(st.size() != 0){
            st.pop();
        }

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int cnt = 1;

            while(st.size() != 0 && arr[i] < st.peek().element ){
                cnt += st.peek().minFreq;
                st.pop();
            }
            st.push(new Pair(curr,cnt));
            leftmax[i] = cnt;
        }

        for (int i = n - 1; i >= 0; i--) {
            int curr = arr[i];
            int cnt = 1;
            while(st.size() != 0 && arr[i] <= st.peek().element ){
                cnt += st.peek().minFreq;
                st.pop();
            }
            st.push(new Pair(curr,cnt));
            rightmax[i] = cnt;
        }

        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            long range = (rightmax[i]*leftmax[i]) - (rightmin[i]*leftmin[i]);
            ans += arr[i]*range;
        }

        return ans;
    }
}
