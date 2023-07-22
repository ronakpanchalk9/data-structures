// You are given a weighted undirected graph having n vertices numbered from 1 to n and m edges describing there are edges between a to b with some weight, find the shortest path between the vertex 1 and the vertex n and if path does not exist then return a list consisting of only -1.

import java.util.*;
class Pair{
    int target;
    int weight;
    Pair(int t, int w){
        this.target = t;
        this.weight = w;
    }
}
public class shortestPath_weigtUAG {
    public static List<Integer> shortestPath(int n, int m, int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.target - y.target);
        
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];

        for (int i = 1; i <= n; i++) {
            dist[i] = (int)1e9;
            parent[i] = i;
        }
        dist[1] = 0;
        pq.add(new Pair(1, 0));

        while(pq.size() != 0){
            Pair currPair = pq.peek();
            int curr = currPair.target;
            int wt = currPair.weight;
            pq.remove();

            for (Pair iter : adj.get(curr)) {
                int adjNode = iter.target;
                int adjW = iter.weight;
                if(wt + adjW < dist[adjNode]){
                    dist[adjNode] = wt+adjW;
                    pq.add(new Pair(adjNode,wt+adjW));
                    parent[adjNode] = curr;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == 1e9){
            path.add(-1);
            return path;
        }
        
        int node=n;

        while(parent[node] != node){
            path.add(0,node);
            node = parent[node];
        }

        path.add(0,1);
        return path;
    }
}
