class search{
    boolean searchBST(Node root, int x) {
        // Your code here
        while(root != null){
            if(x==root.data){
                return true;
            }
            if(x > root.data){
                root= root.right;
            }else{
                root = root.left;
            }
        }
        return false;
    }
}