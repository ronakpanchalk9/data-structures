// Given two strings s1 and s2. The task is to check if s2 is a rotated version of the string s1. The characters in the strings are in lowercase.

public class strings_rotation {
    static boolean areRotation(String s1, String s2){
        String s3 = s1.concat(s1);
        if(s1.length() != s2.length() || !s3.contains(s2) ){
            return false;
        }
        
        return true;
    }
}
