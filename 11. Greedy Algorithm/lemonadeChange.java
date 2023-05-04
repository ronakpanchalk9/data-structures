// You are a owner of lemonade island, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.
// Given an integer array bills of size N where bills [ i ] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.

import java.util.HashMap;

public class lemonadeChange {
    static boolean lemonadeChange(int N, int bills[]){
        int current = 0;
        HashMap<Integer, Integer> notes = new HashMap<>();
        
        notes.put(5, 0);
        notes.put(10, 0);
        notes.put(20, 0);

        for (int i = 0; i < bills.length; i++) {
            notes.put(bills[i], notes.getOrDefault(bills[i], 0)+1);
            int ret = bills[i] - 5;
            if(ret == 0){
                continue;
            }else if(ret == 5 && notes.get(5) > 0){
                notes.put(5,notes.get(5)-1);
            }else if((ret == 15 && notes.get(5) > 0 && notes.get(10) > 0) ){
                notes.put(5, notes.get(5)-1);
                notes.put(10, notes.get(10)-1);
            }else if (ret == 15 && notes.get(5) > 2) {
                notes.put(5, notes.get(5)-3);
            }else{
                return false;
            }
            
        }

        return true;
    }
}
