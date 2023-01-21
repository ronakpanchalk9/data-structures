// Given a number N and a bit number K, check if Kth bit of N is set or not. A bit is called set if it is 1. Position of set bit '1' should be indexed starting with 0 from LSB side in binary representation of the number.
// import java.util.*;
public class k_bit {
    static boolean checkKthBit(int n, int k){
        int bitmask = 1 << k;
        if((n & bitmask) == 0){
            return false;
        }else{
            return true;
        }
    }
    public static void main(String[] args) {
        int n = 76;
        int k = 4;
        int bitmask = 1<<k;
        int setbit = n | bitmask;
        System.out.println("N:"+Integer.toBinaryString(n));
        System.out.println("bitmask:" + Integer.toBinaryString(bitmask));
        System.out.println("setbit:" + Integer.toBinaryString(setbit));
        System.out.println("Kth digit check: "+Integer.toBinaryString(setbit & bitmask));
    }
}
