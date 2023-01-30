// You are given a positive number N. Using the concept of Sieve, compute its prime factorisation.
import java.util.*;

public class prime_factorisation {
    static List<Integer> findPrimefactors(int n) {
        List<Integer> ans = new ArrayList<>();
        int[] spf = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        while (n != 1) {
            ans.add(spf[n]);
            n = n / spf[n];
        }
        return ans;
    }
}