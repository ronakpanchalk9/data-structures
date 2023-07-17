import java.util.*;

class Pair {
    int target;
    int weight;

    Pair(int t, int w) {
        this.target = t;
        this.weight = w;
    }
}

class dijkstraAlgo {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.weight - y.weight);
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = (int) (1e9);
        }
        distance[S] = 0;
        pq.add(new Pair(S, 0));

        while (pq.size() != 0) {
            int curr = pq.peek().target;
            int wt = pq.peek().weight;
            pq.remove();

            for (int i = 0; i < adj.get(curr).size(); i++) {
                int edgeWt = adj.get(curr).get(i).get(1);
                int adjNode = adj.get(curr).get(i).get(0);

                if (wt + edgeWt < distance[adjNode]) {
                    distance[adjNode] = wt + edgeWt;
                    pq.add(new Pair(adjNode, distance[adjNode]));
                }
            }
        }
        return distance;
    }
}