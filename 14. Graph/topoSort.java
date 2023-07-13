import java.util.*;

class topoSort{
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] visited = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] != 1){
                dfs(visited, i, st,adj);
            }
        }
    }

    private static void dfs(int[] visited, int node, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = 1;

        for (int i = 0; i < adj.get(node).size(); i++) {
            if(visited[adj.get(node).get(i)] == 0){
                dfs(visited, i, st, adj);
                st.push(adj.get(node).get(i));
            }
        }
    }
    public static void main(String[] args) {
        
    }
}