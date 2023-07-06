import java.util.ArrayList;

public class directedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[V];
        int[] path = new int[V];

        for (int i = 0; i < V; i++) {
            if(visited[i] == 0){
                if(dfs(visited, path, i, adj)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int[] visited, int[] path, int src, ArrayList<ArrayList<Integer>> adj) {
        // its like a trail, keep on adding 1 on the path by following a path with directed graph till you reach the end case where the node is not pointing towards any other node. Once reached there with the help of recursion we keep deleting our trail by entering 0 in path[], if any time you see any node visited and also your trail in the path[] it means it's a cycle
        visited[src] = 1;
        path[src] = 1;

        for (int i = 0; i < adj.get(src).size(); i++) {
            if(visited[adj.get(src).get(i)] == 0){
                if(dfs(visited, path, adj.get(src).get(i), adj)){
                    return true;
                }
            }else if(path[adj.get(src).get(i)] == 1){
                return true;
            }
        }

        path[src] = 0;
        return false;
    }
}
