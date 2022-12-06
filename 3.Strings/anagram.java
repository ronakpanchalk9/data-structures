// Given two strings a and b consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other.
public class anagram {
    static boolean isAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        int[] count = new int[123];
        // int sum1 = 0;
        // int sum2 = 0;
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i)]++;
            count[b.charAt(i)]--;
        }
        
        for (int i = 0; i < count.length; i++) {
            if(count[i] != 0){
                return false;
            }
        }

        return true;
    }
}
