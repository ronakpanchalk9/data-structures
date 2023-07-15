import java.util.ArrayList;
import java.util.Stack;

class Pair{
    int target;
    int weight;

    Pair(int t, int w){
        this.target = t;
        this.weight = w;
    }
}
public class shortestPathDAG {
    public int[] shortestPath(int N, int M, int[][] edges){
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < M; i++) {
            int start = edges[i][0];
            int end = edges[i][1];
            int wt = edges[i][2];
            adj.get(start).add(new Pair(end, wt));
        }
        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if(vis[i] == 0){
                topoSort(i, adj, vis, st);
            }
        }

        int[] distance = new int[N];

        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[0] = 0;

        while(!st.isEmpty()){
            int curr = st.peek();
            st.pop();

            for (int i = 0; i < adj.get(curr).size(); i++) {
                int t = adj.get(curr).get(i).target;
                int w = adj.get(curr).get(i).weight;

                if(distance[curr] + w < distance[t]){
                    distance[t] = distance[curr] + w;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if(distance[i] == Integer.MAX_VALUE){
                distance[i] = -1;
            }
        }
        return distance;
    }

    private void topoSort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).target;
            if(vis[v] == 0){
                topoSort(v, adj, vis, st);
            }
            
        }
        st.add(node);
    }
}
