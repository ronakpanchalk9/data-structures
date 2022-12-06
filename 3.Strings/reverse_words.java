import java.util.Stack;

public class reverse_words {
    // Given a String S, reverse the string without reversing its individual words. Words are separated by dots.
    static String reverseWords(String s){
        Stack<String> ans = new Stack<String>();
       
        int beg = 0;
        for (int i = 0; i < s.length(); i++) {            
            if(s.charAt(i)=='.'){
                ans.push(s.substring(beg, i));
                ans.push(".");
                beg = i+1;
            }
            if(i==s.length()-1){
                ans.push(s.substring(beg,i+1));
            }
        }
        
        String ansString = new String();

        while(ans.size() != 0){
            ansString += ans.peek();
            ans.pop();
        }
        return ansString;
    }
    public static void main(String[] args) {
        
    }
}
