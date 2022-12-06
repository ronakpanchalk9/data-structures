public class sum_of_N {
    static long nSeries(long n){
        if(n == 1){
            return 1;
        }else{
            return (long)Math.pow(n, 3) + nSeries(n-1);
        }
    }
}
