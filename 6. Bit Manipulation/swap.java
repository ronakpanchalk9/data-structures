// Swap given two numbers and print them. (Try to do it without a temporary variable.) and return it.
import java.util.*;
public class swap {
    static List<Integer> get(int a, int b){
        List<Integer> ans = new ArrayList<>();
        //Sol 1
        ans.add((a & 0) | b);
        ans.add((b & 0) | a);
        
        // Sol 2
        // a = 1011, b = 1110
        a = a ^ b; //1010
        b = a ^ b; //1011
        a = a ^ b; //1110
        return ans;
    }
}
