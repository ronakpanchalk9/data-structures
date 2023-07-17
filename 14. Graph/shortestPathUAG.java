import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class shortestPathUAG{
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < m; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            adj.get(start).add(end);
            adj.get(end).add(start);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] distance = new int[n];
        for(int i = 0; i < n; i++){
            distance[i] = (int)1e9;
        }
        q.add(src);
        distance[src] = 0;
        while(!q.isEmpty()){
            int curr = q.peek();
            q.remove();
            
            for(int adjacent: adj.get(curr)){
                if(distance[curr] + 1 < distance[adjacent]){
                    distance[adjacent] = 1+distance[curr];
                    q.add(adjacent);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(distance[i] == 1e9){
                distance[i] = -1;
            }
        }
        return distance;
    }
}