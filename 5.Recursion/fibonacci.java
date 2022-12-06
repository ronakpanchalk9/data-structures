// Given a number N, find the first N Fibonacci numbers. The first two number of the series are 1 and 1.
public class fibonacci {
    static long fib(int n){
        if(n <= 1){
            return 1;
        }
        long first = fib(n-1);
        long last = fib(n-2);
        return first + last;
    }
    static long[] printFib(int n){
        long[] ans = new long[n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = fib(i);
        }
        return ans;
    }
}
