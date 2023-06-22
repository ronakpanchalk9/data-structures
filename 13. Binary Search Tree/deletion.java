class deletion {
    public static deleteNode(Node root, int x){
        if(root == null){
            return null;
        }
        if(root.data == x){
            return helper(root);
        }

        Node temp = root;

        while(root != null){
            if(root.data > x){
                if(root.left != null && root.left.data == x){
                    root.left = helper(root.left);
                    break;
                }else{
                    root = root.left;
                }
            }else {
                if(root.right != null && root.right.data == x){
                    root.right = helper(root.right);
                    break;
                }else{
                    root = root.right;
                }
            }
        }
        return temp;
    }

    static Node helper(Node root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            Node rightChild = root.right;
            Node lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    static Node findLastRight(Node root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }

}