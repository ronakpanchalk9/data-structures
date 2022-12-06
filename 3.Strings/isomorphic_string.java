import java.util.*;

public class isomorphic_string {
    static boolean isomorphic(String s1, String s2) {
        HashMap<Character, Character> hm = new HashMap<>();
        HashMap<Character, Boolean> hm2 = new HashMap<>();

        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if(hm.containsKey(c1)){
                if(hm.get(c1) != c2){
                    return false;
                }
            }else{
                if(hm2.containsKey(c2)){
                    return false;
                }else{
                    hm.put(c1,c2);
                    hm2.put(c2, true);
                }
            }
        }
        return true;
    }
}
