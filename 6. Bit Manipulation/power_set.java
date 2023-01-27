import java.util.*;
public class power_set {
    static String decToBinary(int n){
        String ans = "";
        for (int i = 16; i >=0; i--) {
            int k = n >> i;
            if((k & 1) > 0){
                ans += "1";
            }else{
                ans += "0";
            }
        }
        return ans;
    }
    static List<String> AllPossibleStrings(String s){
        List<String> ans = new ArrayList<>();

        for (int i = 1; i < 1<<s.length(); i++) {
            String str = decToBinary(i);;
            String addy = "";
            int j = str.length()-3;

            while(j >= 0){
                if(str.charAt(j) == '1'){
                    addy+= s.charAt(str.length() - j);
                }
                j--;
            }

            ans.add(addy);
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(AllPossibleStrings("abc")); //Correct output -> [a, ab, abc, b, bc, c]
        // System.out.println(decToBinary(5));
    }
}
