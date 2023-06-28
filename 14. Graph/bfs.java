import java.util.*;

public class bfs {
    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = 1;

        while (!q.isEmpty()) {
            int curr = q.poll();
            ans.add(curr);

            for (int i = 0; i < adj.get(curr).size(); i++) {
                if (visited[adj.get(curr).get(i)] == 0) {
                    visited[adj.get(curr).get(i)] = 1;
                    q.add(adj.get(curr).get(i));
                }
            }

        }
        return ans;
    }
}
