import java.util.Arrays;

public class koko_bananas {
    static int solve(int n, int[] piles, int hours){
        Arrays.sort(piles);
        int min = piles[0];
        int low = 0;
        int high = piles[n-1];
        
        while(low <= high){
            int time = 0;
            int mid = (low+high)>>1;

            for (int i = 0; i < piles.length; i++) {
                time += Math.ceil((double)piles[i]/mid);
            }

            if(time > hours){
                low = mid+1;
            }else if(time <= hours){
                min = mid;
                high = mid-1;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        System.out.println(Math.ceil((double)7/20));
    }
}
