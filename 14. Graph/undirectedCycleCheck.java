import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class undirectedCycleCheck {
    class Pair {
        int node;
        int parent;

        Pair(int n, int prnt) {
            this.node = n;
            this.parent = prnt;
        }
    }

    // Function to detect cycle in an undirected graph.
    public boolean cycleCheck(int src, int V, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[src] = 1;
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(src, -1));

        while (!q.isEmpty()) {
            int curr = q.peek().node;
            int par = q.peek().parent;
            q.remove();

            for (int i = 0; i < adj.get(curr).size(); i++) {
                if (visited[adj.get(curr).get(i)] == 0) {
                    visited[adj.get(curr).get(i)] = 1;
                    q.add(new Pair(adj.get(curr).get(i), curr));

                } else if (adj.get(curr).get(i) != par) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (cycleCheck(i, V, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
