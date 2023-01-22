// Given two integers dividend and divisor. Find the quotient after dividing dividend by divisor without using multiplication, division and mod operator.
public class divide {
    static long divide(long a, long b) {
        int sign = 1;
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            sign = -1;
        }

        a = Math.abs(a);
        b = Math.abs(b);

        long quotient = 0;
        long temp = 0;

        for (int i = 31; i >= 0; i--) {
            if (temp + (b << i) <= a) {
                temp += b << i;
                quotient = quotient | (1L << i);
            }
        }
        
        if (sign == -1) {
            quotient = -quotient;
        }
        return quotient;
    }

    public static void main(String[] args) {
        System.out.println(divide(45, 3));
    }
}
