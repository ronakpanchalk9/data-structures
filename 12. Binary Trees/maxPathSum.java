// Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
public class maxPathSum {
    static int sum(Node root, int[] curr){
        if(root == null){
            return 0;
        }
        
        int l = Math.max(0,sum(root.left, curr));
        // curr[0] = l;
        int r = Math.max(0,sum(root.right, curr));
        curr[0] = Math.max(curr[0],l+r+root.data);
        
        return Math.max(l,r) + root.data;
        
    }
    //Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node root)
    {
        //your code goes here
        int[] temp = new int[1];
        temp[0] = Integer.MIN_VALUE;
        // temp[0] = root.data;
        sum(root,temp);
        return temp[0];
    } 
}
