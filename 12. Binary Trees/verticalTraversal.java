// Given a Binary Tree, find the vertical traversal of it starting from the leftmost level to the rightmost level.
// If there are multiple nodes passing through a vertical line, then they should be printed as they appear in level order traversal of the tree.

class verticalTraversal{
    static ArrayList <Integer> verticalOrder(Node root)
    {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, ArrayList <Integer>> mpp = new TreeMap<>();
        
        q.add(new Pair(0, root));
        
        while(!q.isEmpty()){
            Pair curr = q.poll();
            
            if(mpp.containsKey(curr.hd)){
                mpp.get(curr.hd).add(curr.node.data);
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