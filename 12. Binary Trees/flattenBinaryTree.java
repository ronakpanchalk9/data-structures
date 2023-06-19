public class flattenBinaryTree {
    private static void flatten(Node root) {
        // Morris Traversal
        Node curr = root;
        while(curr != null){
            if(curr.left != null){
                Node pred = curr.left;
                
                while(pred.right != null){
                    pred = pred.right;
                }
                
                pred.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}
