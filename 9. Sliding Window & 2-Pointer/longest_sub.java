import java.util.*;

public class longest_sub {
    static int longestUniqueSub(String S) {
        // String str = "";
        // int max = 0;
        // for (int i = 0; i < S.length(); i++) {
        //     if (str.indexOf(S.charAt(i)) == -1) {
        //         str += S.charAt(i);
        //     } else {
        //         max = Math.max(max, str.length());
        //         str = str.substring(str.indexOf(S.charAt(i)) + 1, str.length());
        //         str += S.charAt(i);
        //     }
        // }
        // max = Math.max(max, str.length());
        // // return max;
        // Optimized Solution - 2 pointer approach
        HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();

        int left = 0, right = 0;
        int n = S.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(S.charAt(right))){
                left = Math.max(mpp.get(S.charAt(right)) + 1, left);
            } 

            mpp.put(S.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(longestUniqueSub(s));
    }
}
