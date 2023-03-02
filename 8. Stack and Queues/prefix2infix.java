import java.util.Stack;

public class prefix2infix {
    static String prefixToInfix(String pre_exp) {
        String ans = "";
        Stack<String> st = new Stack<>();

        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            if ((pre_exp.charAt(i) > 96 && pre_exp.charAt(i) < 123)
                    || (pre_exp.charAt(i) > 64 && pre_exp.charAt(i) < 91)) {
                st.push(pre_exp.substring(i, i + 1));
            } else if (pre_exp.charAt(i) == '/' || pre_exp.charAt(i) == '-' || pre_exp.charAt(i) == '+'
                    || pre_exp.charAt(i) == '*' || pre_exp.charAt(i) == '^') {
                int popper = 2;
                String temp = "(";

                while (popper != 0) {
                    temp += st.pop();
                    popper--;
                    if (popper == 1) {
                        temp += pre_exp.charAt(i);
                    }
                }

                temp += ")";
                st.push(temp);
            }

        }
        ans += st.pop();
        return ans;
    }
}
