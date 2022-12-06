public class atoi {
    // Your task  is to implement the function atoi. The function takes a string(str) as argument and converts it to an integer and returns it.

// Note: You are not allowed to use inbuilt function.
    static int atoi(String str){
        int res = 0;

        for (int i = 0; i < str.length(); ++i)
            res = res * 10 + str.charAt(i) - '0';

        return res;
    }
    
    public static void main(String[] args) {
        
    }
}
