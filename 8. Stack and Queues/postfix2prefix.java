import java.util.Stack;

/**
 * postfix2prefix
 */
public class postfix2prefix {

    static String postfix2prefix(String exp) {
        Stack<String> st = new Stack<>();
        String ans = "";

        for (int i = 0; i < exp.length(); i++) {
            if ((exp.charAt(i) > 96 && exp.charAt(i) < 123) || (exp.charAt(i) > 64 && exp.charAt(i) < 91)) {
                st.push(exp.substring(i, i + 1));
            }else if(exp.charAt(i) == '-' || exp.charAt(i) == '+' || exp.charAt(i) == '^' || exp.charAt(i) == '*' || exp.charAt(i) == '/'){
                String temp = "";
                String one = "";
                int popper = 1;
                temp += exp.charAt(i);
                while(popper != 0){
                    one = st.pop();
                    popper--;
                    if(popper == 0){
                        temp += st.pop();
                    }
                }
                temp += one;
                st.push(temp);
            }
        }
        ans = st.pop();
        return ans;
    }
    public static void main(String[] args) {
        String exp = "ABC/-AK/L-*";
        System.out.println(postfix2prefix(exp));
    }
}