import java.util.*;

public class infix2postfix {
    public static String infixToPostfix(String exp) {
        Stack<Character> st = new Stack<>();
        String ans = "";

        for (int index = 0; index < exp.length(); index++) {
            if ((exp.charAt(index) > 96 && exp.charAt(index) < 123) || (exp.charAt(index) > 64 && exp.charAt(index) < 91)) {
                ans += exp.charAt(index);
            } else if (exp.charAt(index) == '(') {
                st.push(exp.charAt(index));
            } else if (exp.charAt(index) == ')') {
                while (st.peek() != '(') {
                    ans += st.pop();
                }
                st.pop();
            } else if (exp.charAt(index) == '+' || exp.charAt(index) == '-' || exp.charAt(index) == '/'
                    || exp.charAt(index) == '*' || exp.charAt(index) == '^') {

                if (st.size() == 0) {
                    st.push(exp.charAt(index));
                } else if (exp.charAt(index) == '+' || exp.charAt(index) == '-') {
                    while (st.size() != 0 && (st.peek() == '+' || st.peek() == '-' || st.peek() == '/' || st.peek() == '*' || st.peek() == '^')) {
                        ans += st.pop();
                    }
                    st.push(exp.charAt(index));
                } else if (exp.charAt(index) == '/' || exp.charAt(index) == '*') {
                    while (st.size() != 0 && (st.peek() == '^' || st.peek() == '*' || st.peek() == '/')) {
                        ans += st.pop();
                    }
                    st.push(exp.charAt(index));
                } else {
                    st.push(exp.charAt(index));
                }

            }
        }
        while (st.size() != 0) {
            ans += st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(exp));
    }
}
