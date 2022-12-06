public class largest_odd_subString {
    // Given an string S, representing a large interger. Return the largest-valued odd integer (as a string) that is substring of the given string S.

    String maxOdd(String s) {
        String ans = "";
        for(int i = 0; i < s.length();i++){
            if(s.charAt(i) % 2 != 0){
                ans = s.substring(0,i+1);
            }
        }
        return ans;
    }
}
