public class odd_even {
    static String oddEven(int N){
        int bitmask = 1 << 0;
        int ans = N & bitmask;

        if(ans == 0){
            return "even";
        }else{
            return "odd";
        }
    }
}
