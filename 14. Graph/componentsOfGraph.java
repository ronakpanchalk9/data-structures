// Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.

// Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

import java.util.ArrayList;

public class componentsOfGraph {
    static void traversal(int[] visited, ArrayList<ArrayList<Integer>> adj, int node) {
        visited[node] = 1;

        for (int i = 0; i < adj.size(); i++) {
            if (visited[i] == 0 && adj.get(node).get(i) == 1) {
                traversal(visited, adj, i);
            }
        }
    }

    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] visited = new int[V];
        int ans = 0;

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                traversal(visited, adj, i);
                ans++;
            }

        }
        return ans;
    }
}
