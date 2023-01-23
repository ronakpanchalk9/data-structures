// You are given two numbers A and B. The task is to count the number of bits needed to be flipped to convert A to B
public class bit_difference {
    static int countBitsFlip(int a, int b) {
        int ans = a ^ b;
        int count = 0;
        int i = 0;
        while ((1 << i) <= ans) {
            if (((1 << i) & ans) != 0) {
                count++;
            }
            i++;
        }
        return count;
    }
}
