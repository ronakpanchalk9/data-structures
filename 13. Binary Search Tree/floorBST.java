public class floorBST {
    public static int floor(Node root, int key) {
        
        int ans = -1;
        if (root == null) return -1;
        int diff = Integer.MAX_VALUE;
        while(root != null){
            if(diff - key < diff && root.data <= key){
                ans = root.data;
                diff = ans;
            }
            if(key == root.data){
                return root.data;
            }
            if(key < root.data){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return ans;
    }
}
