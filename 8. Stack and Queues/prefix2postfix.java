import java.util.Stack;

public class prefix2postfix {
    static String preToPost(String pre_exp) {
        Stack<String> st = new Stack<>();
        String ans = "";

        for (int i = pre_exp.length() - 1; i >= 0; i--) {
            if ((pre_exp.charAt(i) > 96 && pre_exp.charAt(i) < 123)
                    || (pre_exp.charAt(i) > 64 && pre_exp.charAt(i) < 91)) {
                st.push(pre_exp.substring(i, i + 1));
            }else if(pre_exp.charAt(i) == '-' || pre_exp.charAt(i) == '+' || pre_exp.charAt(i) == '/' || pre_exp.charAt(i) == '*' || pre_exp.charAt(i) == '^'){
                String temp = "";
                int popper = 2;
                while(popper != 0){
                    temp += st.pop();
                    popper--;
                }
                temp += pre_exp.charAt(i);
                st.push(temp);
            }
        }
        ans = st.pop();
        return ans;
    }
}
