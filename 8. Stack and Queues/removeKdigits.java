import java.util.*;

public class removeKdigits {
    public static String removeDigits(String s, int k) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            while (st.size() != 0 && k != 0 && s.charAt(i) - '0' < st.peek()) {
                st.pop();
                k--;
            }
            if (st.size() == 0 && s.charAt(i) - '0' == 0) {
                continue;
            }
            st.push(s.charAt(i) - '0');
        }

        while (st.size() != 0 && k != 0) {
            st.pop();
            k--;
        }

        if (st.size() == 0) {
            return "0";
        }

        while (st.size() != 0) {
            sb.append(st.pop());
        }

        ans = sb.reverse().toString();

        return ans;

    }

    public static void main(String[] args) {
        String s = "51200003";
        int k = 3;
        System.out.println(removeDigits(s, k));
    }
}