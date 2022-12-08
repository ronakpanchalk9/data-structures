// Given a number and its reverse. Find that number raised to the power of its own reverse.
// Note: As answers can be very large, print the result modulo 109 + 7.

public class pow_of_num {
    static long power(int N, int R){
        if(R == 0){
            return 1;
        }
        long temp = power(N, R/2);
        temp = temp * temp % 1000000007;
        if(R % 2 == 0){
            return temp;
        }else{
            return temp * N % 1000000007;
        }
    }
}
