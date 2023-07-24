// There are n cities and m edges connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from the city fromi to city toi with cost pricei.

// You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
import java.util.*;

class Pair {
    int destination;
    int price;

    Pair(int d, int p) {
        this.destination = d;
        this.price = p;
    }
}

class Tuple{
    int first;
    int second;
    int third;
    
    Tuple(int f, int s, int t){
        this.first = f;
        this.second = s;
        this.third = t;
    }
}

public class cheapestFlight {
    public int cheapflight(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int[] prices = new int[n];
        Queue<Tuple> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        
        for(int i = 0; i < prices.length; i++){
            prices[i] = (int)1e9;
        }

        q.add(new Tuple(0,src, 0));
        prices[src] = 0;
        
        while (!q.isEmpty()) {
            Tuple curr = q.peek();
            q.remove();
            int stop = curr.first;
            int dest = curr.second;
            int cost = curr.third;
            
            if(stop > k){
                continue;
            }
            
            for (Pair it : adj.get(dest)) {
                int nextCity = it.destination;
                int travelPrice = it.price;
                if (cost + travelPrice < prices[nextCity] && stop <= k) {
                    prices[nextCity] = cost + travelPrice;
                    q.add(new Tuple(stop+1, nextCity, cost + travelPrice));
                }
            }
        }
        if(prices[dst] == (int)1e9){
            return -1;
        }
        return prices[dst];
    }
}
