// Given an infinite supply of each denomination of Indian currency { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 } and a target value N.
// Find the minimum number of coins and/or notes needed to make the change for Rs N. You must return the list containing the value of coins required.

import java.util.List;

public class minimum_coins{
    static List<Integer> minPartition(int N){
        List<Integer> ans = new ArrayList<>();
        int[] notes = {2000,500,200,100,50,20,10,5,2,1};
        for (int i = 0; i < notes.length; i++) {
            while(N >= notes[i]){
                ans.add(notes[i]);
                N-=notes[i];
            }
        }
        return ans;
    }
}