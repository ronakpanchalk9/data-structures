// Given the adjacency list representation of an undirected graph
// your task is to complete the function printGraph() that takes the number of vertices (V) and the adjacency list as input parameters.
// The function should return a new adjacency list, where each adjacency list contains the vertex itself at first position then all its adjacent nodes, in the same order of the given adjacency list of that vertex.

import java.util.ArrayList;

public class printAdjList {
    public ArrayList<ArrayList<Integer>> printGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<ArrayList<Integer>> finans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.get(i).add(0, i);
            finans.add(adj.get(i));
        }
        return finans;
    }
}
