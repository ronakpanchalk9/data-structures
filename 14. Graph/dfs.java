// You are given a connected undirected graph. Perform a Depth First Traversal of the graph.
// Note: Use a recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.

import java.util.ArrayList;

public class dfs {
    static void dfsTraversal(boolean[] visited, int node, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        ans.add(node);

        for (int i = 0; i < adj.get(node).size(); i++) {
            if(visited[adj.get(node).get(i)] != true){
                dfsTraversal(visited, adj.get(node).get(i), ans, adj);
            }
        }
    }
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();

        dfsTraversal(visited, 0, ans, adj);
        return ans;
    }
}
