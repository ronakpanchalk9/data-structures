// Given a binary tree, print the bottom view from left to right.
// A node is included in bottom view if it can be seen when we look at the tree from bottom.
import java.util.*;
public class BottomView {
    public ArrayList <Integer> bottomView(Node root)
    {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, ArrayList <Integer>> mpp = new TreeMap<>();
        
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            if(!mpp.containsKey(curr.hd)){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curr.node.data);
                mpp.put(curr.hd, temp);
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curr.node.data);
                mpp.put(curr.hd, temp);
            }
            
            if(curr.node.left != null){
                q.add(new Pair(curr.hd-1, curr.node.left));
            }
            if(curr.node.right != null){
                q.add(new Pair(curr.hd+1, curr.node.right));
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry: mpp.entrySet()){
            ans.addAll(entry.getValue());
        }
        
        return ans;
    }
    static class Pair{
        int hd;
        Node node;
        
        public Pair(int hd, Node node){
            this.node = node;
            this.hd = hd;
        }
    }
}
