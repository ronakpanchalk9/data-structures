public class power_of_2 {
    static boolean isPowerofTwo(long n){
        return (n != 0) && ((n & (n-1)) == 0);
    }
}
