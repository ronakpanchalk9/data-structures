// A valid parentheses string is either empty "", "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.

public class remove_outer_parentheses{
    static String removeChar(String s, int idx){
        return s.substring(0, idx) + s.substring(idx + 1); 
    }
    static String removeOuterParentheses(String S){
        int countL = 0;
        int countR = 0;
        int p1 = Integer.MAX_VALUE;
        
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '('){
                countL++;
                p1 = Math.min(p1, i);
            }else{
                countR++;
            }

            if(countL == countR){
                S = removeChar(S, p1);
                S = removeChar(S, i-1);
                i = i-2;
                p1 = Integer.MAX_VALUE;
            }
        }
        return S;
    }
    public static void main(String[] args) {
        
    }
}