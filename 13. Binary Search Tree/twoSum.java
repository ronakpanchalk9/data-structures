import java.util.ArrayList;

public class twoSum {
    static void in(ArrayList<Integer> inorder, Node root){
        if(root == null){
            return;
        }
        in(inorder, root.left);
        inorder.add(root.data);
        in(inorder, root.right);
    }

    static int isPairPresent(Node root, int target){
        ArrayList<Integer> inorder = new ArrayList<>();
        in(inorder, root);
        int start = 0;
        int end = 1;
        
        while(start < inorder.size()){
            if(inorder.get(start) + inorder.get(end) == target){
                return 1;
            }else if(inorder.get(start)+inorder.get(end) < target){
                end++;
            }else{
                start++;
            }
        }
        return 0;
    }
}
