class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}
public class postorderTraversal {
    static void addTree(ArrayList<Integer> ans, Node root){
        if(root == null){
            return;
        }else{
            addTree(ans, root.left);
            addTree(ans, root.right);
            ans.add(root.data);
        }
    }
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root)
    {
       // Your code goes here
       ArrayList<Integer> ans = new ArrayList<>();
        addTree(ans, root);
        return ans;
    }
}
