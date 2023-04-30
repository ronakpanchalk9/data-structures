// There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost. Given N size array arr[] contains the lengths of the ropes.

import java.util.*;
public class minimumCostRopes {
    long minCost(long arr[], int n){
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long cost = 0;
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        while(pq.size()!=1){
            long first = pq.poll();
            long second = pq.poll();
            cost += first+ second;
            pq.add(first+second);
        }
        return cost;
    }
}
