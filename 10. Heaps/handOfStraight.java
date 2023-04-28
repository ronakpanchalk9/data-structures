// Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.
// Given an integer array hand of size N where hand [ i ] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

import java.util.*;

public class handOfStraight{
    static boolean isStraightHand(int N, int groupSize, int hand[]){
        if(N % groupSize != 0){
            return false;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < hand.length; i++) {
            pq.add(hand[i]);
        }

        while(!pq.isEmpty()){
            int curr = pq.poll();

            for (int i = 1; i < groupSize; i++) {
                if(!pq.remove(curr + i)){
                    return false;
                }
            }
        }
        return true;
    }
}