// Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.
import java.util.*;

public class k_unique_sub {
    public static int longestSubstr(String s, int k){
        int left = 0;
        int right = 0;
        int maxlen = -1;
        int n = s.length();
        HashMap<Character, Integer> mpp = new HashMap<>();

        while(right < n){

            if(mpp.size() > k){
                while(mpp.size() != k){
                    mpp.put(s.charAt(left), mpp.get(s.charAt(left))-1);
                    if(mpp.get(s.charAt(left)) <= 0){
                        mpp.remove(s.charAt(left));
                    }
                    left++;
                }
            }
            
            mpp.put(s.charAt(right), mpp.getOrDefault(s.charAt(right), 0) + 1);

            if(mpp.size() == k){
                maxlen = Math.max(maxlen, right - left + 1);
            }

            right++;
        }

        return maxlen;
    }
    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestSubstr(s, k));
    }    
}
