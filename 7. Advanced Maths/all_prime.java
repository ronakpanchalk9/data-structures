// Given a number N. Find its unique prime factors in increasing order.
public class all_prime {
    static void primeFactors(int n){
        int[] spf = new int[n+1];

        for (int i = 2; i <= n; i++) {
            spf[i] = i;
        }

        for (int i = 2; i*i <= n; i++) {
            if(spf[i] == i){
                for (int j = i*i; j <= n; j+=i) {
                    if(spf[j] == j){
                        spf[j] = i;
                    }
                }
            }
        }

        while(n != 1){
            System.out.print(spf[n]+ " ");
            int last = spf[n];
            n = n / spf[n];
            if((n % last) == 0 && (n > 1)){
                n /= spf[n];
            }
        }

    }
    public static void main(String[] args) {
        int n = 100;
        primeFactors(n);
        // int[] seive = new int[n];
        // for (int i = 2; i <= n; i++) {
        //     if((n % i) == 0){
        //         for (int j = i*i; j < seive.length; j+=i) {
        //             seive[j] = 1;
        //         }
        //     }
        // }
    
        // for (int i = 2; i < seive.length; i++) {
        //     if(seive[i] == 0){
        //         System.out.print(i + " ");
        //     }
        // }

        // primeFactors(n);
    }
}