class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class symmetric {
    static boolean mirrorCheck(Node root1, Node root2){
        if(root1 == null || root2 == null){
            return root1 == root2;
        }
        return (root1.data == root2.data) && mirrorCheck(root1.left, root2.right) && mirrorCheck(root1.right, root2.left);
    }
    
    static boolean isSymmetric(Node root){
        if(root == null){
            return true;
        }
        return mirrorCheck(root.left, root.right);
    }
}
