public class findBalance {
    int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftside = height(root.left);
        if(leftside == -1){
            return -1;
        }
        int rightside = height(root.right);
        if(rightside == -1){
            return -1;
        }
        
        if(Math.abs(leftside - rightside) > 1){
            return -1;
        }
        
        return Math.max(leftside, rightside) +1;

    }

    static boolean isBalanced(Node root){
        if(height(root) == -1){
            return false;
        }
        return true;
    }
}
