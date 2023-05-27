// Given a Binary Tree of size N, you need to find all the possible paths from root node to all the leaf node's of the binary tree.

public class root2leaf {
    public void pathfill(ArrayList<ArrayList<Integer>> finans, ArrayList<Integer> ans, Node root){
        ans.add(root.data);
        if(root.left == null && root.right == null){
            finans.add(new ArrayList<>(ans));
            ans.remove(ans.size()-1);
            return;
        }
        
        if(root.left != null){
        pathfill(finans, ans, root.left);
        }
        if(root.right != null){
        pathfill(finans, ans,root.right);
        }
        ans.remove(ans.size()-1);
    }
    public ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here
        ArrayList<ArrayList<Integer>> finans = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        pathfill(finans,ans,root);
        
        return finans;
    }
}
