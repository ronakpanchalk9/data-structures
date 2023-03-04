import java.util.Stack;

public class postfix2Infix {
    static String postToInfix(String exp) {
        Stack<String> st = new Stack<>();
        String ans = "";

        for (int i = 0; i < exp.length(); i++) {
            if ((exp.charAt(i) > 96 && exp.charAt(i) < 123) || (exp.charAt(i) > 64 && exp.charAt(i) < 91)) {
                st.push(exp.substring(i, i + 1));
            }else{
                String temp = "(";
                String one = "";
                one += st.pop();
                temp += st.pop();//(A
                temp += exp.charAt(i); //(A-
                temp += one; //(A-B
                temp += ")";
                st.push(temp);
            }
        }
        ans = st.pop();
        return ans;
    }
}
