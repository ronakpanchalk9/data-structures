// Given a number N, calculate the prime numbers up to N using Sieve of Eratosthenes.  
import java.util.*;

public class seive {
    static ArrayList<Integer> sieveOfEratosthenes(int n){
        ArrayList<Integer> ans = new ArrayList<>();
        int[] spf = new int[n+1];
        
        for(int i = 2; i <= Math.sqrt(n); i++){
            for(int j = i*i; j <= n; j += i){
                spf[j] = 1;
            }
        }
        
        for(int i = 2; i<= n; i++){
            if(spf[i] == 0){
                ans.add(i);
            }
        }
        return ans;
    }
}
