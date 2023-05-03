// Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
// Note: Unlike 0/1 knapsack, you are allowed to break the item. 

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class fractional_knapsack {
    class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    class itemComparator implements Comparator<Item>{
        @Override
        public int compare(Item a, Item b){
            double r1 = (double)(a.value) / (double)(a.weight);
            double r2 = (double)(b.value) / (double)(b.weight);

            if(r1 < 2){
                return 1;
            }else if(r1 > r2){
                return -1;
            }else{
                return 0;
            }
        }
    }

    double fractionalKnapsack(int W, Item arr[], int n) {

        Arrays.sort(arr,new itemComparator());
        
        double profit = 0;
        int currW = 0;
        for (int i = 0; i < n; i++) {
            if(currW <= W){
                currW += arr[i].weight;
                profit += arr[i].value;
            }else{
                int remain = W - currW;
                profit += ((double)arr[i].value / (double) arr[i].weight)*remain;
                break; 
            }
        }

        return profit;
    }
}
