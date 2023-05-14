class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}
public class inorderTraversal {
    static void addTree(ArrayList<Integer> ans, Node root){
        if(root == null){
            return;
        }else{
            addTree(ans, root.left);
            ans.add(root.data);
            addTree(ans, root.right);
        }
    }
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> ans = new ArrayList<>();
        addTree(ans, root);
        return ans;
    }
}
