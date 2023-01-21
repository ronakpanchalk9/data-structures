// You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive)

public class count_setbits {
    static int countSetbits(int n){
        if(n == 0){
            return 0;
        }
        int x = 0;
        while((1<<x) <= n){
            x++;
        }
        x-= 1; // Power of 2

        int onesTill2x = x * (1 << (x-1));
        int remBits = n - (1 << x) + 1;
        int rest = n - (1 << x);
        int ans = onesTill2x + remBits + countSetbits(rest);
        return ans;
    }
}
