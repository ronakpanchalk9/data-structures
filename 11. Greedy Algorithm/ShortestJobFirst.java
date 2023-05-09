import java.util.Arrays;

public class ShortestJobFirst {
    static int solve(int bt[]){
        int[] wt = new int[bt.length];
        Arrays.sort(bt);
        int sum = 0;
        for (int i = 0; i < wt.length; i++) {
            sum += bt[i];
            wt[i] = sum; 
        }
        sum = 0;
        for (int i = 0; i < wt.length; i++) {
            wt[i] = wt[i] - bt[i];
            sum += wt[i];
        }
        return (int) Math.floor(sum/bt.length);
    }
}
