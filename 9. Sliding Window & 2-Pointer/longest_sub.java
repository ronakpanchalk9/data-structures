import java.util.*;

public class longest_sub {
    static int longestUniqueSub(String S) {
        int len = 0;
        String str = "";
        int max = 0;
        for (int i = 0; i < S.length(); i++) {
            if (str.indexOf(S.charAt(i)) == -1) {
                str += S.charAt(i);
            } else {
                max = Math.max(max, str.length());
                str = str.substring(str.indexOf(S.charAt(i)) + 1, str.length());
                str += S.charAt(i);
            }
        }
        max = Math.max(max, str.length());
        return max;
    }

    public static void main(String[] args) {
        String s = "sdjfkndfkjsdnmflskf";
        System.out.println(longestUniqueSub(s));
    }
}
