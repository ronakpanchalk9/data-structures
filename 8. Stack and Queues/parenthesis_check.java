import java.util.*;

public class parenthesis_check {
    static boolean isPar(String x) {
        Stack<Character> st = new Stack<>();
        int succptr = -1;
        
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == '(') {
                st.push(x.charAt(i));
                succptr++;
            }
            if (x.charAt(i) == '[') {
                st.push(x.charAt(i));
                succptr++;
            }
            if (x.charAt(i) == '{') {
                st.push(x.charAt(i));
                succptr++;
            }
            
            if(st.size() > 0){
                if (x.charAt(i) == ')' && st.peek() == '(') {
                st.pop();
                succptr++;
            }
            if (x.charAt(i) == '}' && st.peek() == '{') {
                st.pop();
                succptr++;
            }
            if (x.charAt(i) == ']' && st.peek() == '[') {
                st.pop();
                succptr++;
            }
            }
            
        }
        if(st.size() == 0 && (succptr == x.length()-1)){
            return true;
        }
        return false;
    }
}
