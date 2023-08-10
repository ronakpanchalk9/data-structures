import java.util.*;
class Pair{
    int node;
    int distance;
    Pair(int n, int wt){
        this.node = n;
        this.distance = wt;
    }
}
public class primsAlgo {
    static int spanningTree(int V, int E, int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        int vis[] = new int[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.distance - y.distance);

        pq.add(new Pair(0, 0));
        int sum = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.peek();
            int cNode = curr.node;
            int cDist = curr.distance;
            pq.remove();

            if(vis[cNode] == 1){
                continue;
            }
            vis[cNode] = 1;
            sum += cDist;

            for (Pair it : adj.get(cNode)) {
                int adjNode = it.node;
                int adjWt = it.distance;

                if(vis[adjNode] == 0){
                    pq.add(new Pair(adjNode, adjWt));
                }
            }
        }
        return sum;
    }
}
