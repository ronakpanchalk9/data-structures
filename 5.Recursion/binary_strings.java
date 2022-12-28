// Given an integer N , generate all binary strings of size N which do not contain consecutive 1s.

// A binary string is that string which contains only 0 and 1.
import java.util.*;

public class binary_strings {
    public static List<String> generateBinaryStrings(int n){
        List<String> ans = new ArrayList<>();
        String s = new String();
        generate(n, ans, s);
        return ans;
    }

    public static void generate(int n, List<String> ans, String s) {
        if(s.length() >= n){
            ans.add(s);
            return;
        }

        generate(n, ans, s + "0");
        if(s.length() > 0){
            if(s.charAt(s.length()-1) != '1'){
                generate(n, ans, s+"1");
            }
        }else{
            generate(n, ans, s+"1");
        }
        
    }
}
