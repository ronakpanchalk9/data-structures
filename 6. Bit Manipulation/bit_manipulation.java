// Given a 32 bit unsigned integer num and an integer i. Perform following operations on the number - 
// 1. Get ith bit
// 2. Set ith bit
// 3. Clear ith bit

public class bit_manipulation {
    static void bitManipulation(int num, int i) {
        int bitmask = 1 << i-1; //due to zero indexing
        int getbit = bitmask & num;
        int setbit = bitmask | num;
        int notbitmask = ~bitmask;
        int clearbit = num & notbitmask;

        if (getbit == 0) {
            System.out.println(0 + " ");
        } else {
            System.out.print(1 + " ");
        }
        System.out.println(setbit);
        System.out.println(clearbit);
    }
}
