// Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
// Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.

import java.util.*;
class Pair implements Comparable<Pair>{
    int arrival_time;
    int departure_time;

    Pair(int arrival_time, int departure_time){
        this.arrival_time = arrival_time;
        this.departure_time = departure_time;
    }

    public int compareTo(Pair time){
        return this.arrival_time - time.arrival_time; 
    }
}
public class train_platform {
    static int findPlatform(int arr[], int dep[], int n){
        Arrays.sort(arr); 
        Arrays.sort(dep); 
  
        int plat_needed = 1, result = 1; 
        int i = 1, j = 0; 
  
        while (i < n && j < n) { 
        
            if (arr[i] <= dep[j]) { 
                plat_needed++; 
                i++; 
            } 
  
            else if (arr[i] > dep[j]) { 
                plat_needed--; 
                j++; 
            } 
  
            if (plat_needed > result) 
                result = plat_needed; 
        } 
  
        return result; 
        
    }
}
