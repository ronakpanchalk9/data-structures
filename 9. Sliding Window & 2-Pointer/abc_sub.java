// Given string s consisting only a,b,c. return the number of substrings containing at least one occurrence of all these characters a, b, and c
public class abc_sub {
    static int countSubstring(String s){
        int a = 0;
        int b = 0;
        int c = 0;
        int right = 0;
        int left = 0;
        int count = 0;

        while(right < s.length()){
            if(s.charAt(right) == 'a'){
                a++;
            }else if(s.charAt(right) == 'b'){
                b++;
            }else if(s.charAt(right) == 'c'){
                c++;
            }
            
            while(a >= 1 && b >= 1 && c >=1){
                count += s.length() - right;
                
                if(s.charAt(left) == 'a'){
                    a--;
                }else if(s.charAt(left) == 'b'){
                    b--;
                }else if(s.charAt(left) == 'c'){
                    c--;
                }
                
                left++;
            }
            right++;
        }

        return count;
    }
    public static void main(String[] args) {
        String s = "abcabc";
        String s1 = "ccababacbaca";
        System.out.println(countSubstring(s));
        System.out.println(countSubstring(s1));
    }
}
