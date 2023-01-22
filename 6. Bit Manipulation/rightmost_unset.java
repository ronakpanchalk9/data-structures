// Given a non-negative number N. The problem is to set the rightmost unset bit in the binary representation of N. If there are no unset bits, then just leave the number as it is.
public class rightmost_unset {
    static int setBit(int N){
        int i = 0;
        while((1 << i) <= N+1){
            if(((1 << i) - 1) == N){
                return N;
            }
            i++;
        }
        return N | N+1;
    }
}
