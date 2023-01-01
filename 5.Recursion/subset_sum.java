// Given a list arr of N integers, print sums of all subsets in it.

import java.util.ArrayList;

public class subset_sum {
    static void generate(ArrayList<Integer> arr, int N, int idx, int sum, ArrayList<Integer> sumSub){
        if(idx == N){
            sumSub.add(sum);
            return;
        }

        sum += arr.get(idx);
        generate(arr, N, idx+1, sum, sumSub);

        sum -= arr.get(idx);
        generate(arr, N, idx+1, sum, sumSub);
    }

    static ArrayList<Integer> subsetSum(ArrayList<Integer> arr, int N){
        ArrayList<Integer> sumSub = new ArrayList<>();
        generate(arr, N, 0, 0, sumSub);
        return sumSub;
    }
}
