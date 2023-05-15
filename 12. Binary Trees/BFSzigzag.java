// Complete the function to find spiral order traversal of a tree. For below tree, function should return 1, 2, 3, 4, 5, 6, 7.
import java.util.ArrayList;

import queue_using_stack.Queue;
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class BFSzigzag {
    static ArrayList<Integer> findSpiral(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> leftStack = new Stack<>();
        Stack<Node> rightStack = new Stack<>();

        if(root == null){
            return ans;
        }
        
        leftStack.push(root);

        while(!leftStack.isEmpty() || !rightStack.isEmpty()){
            while(!leftStack.isEmpty()){
                Node temp = leftStack.pop();
                ans.add(temp.data);
                if(temp.right != null){
                    rightStack.push(temp.right);
                }
                if(temp.left != null){
                    rightStack.push(temp.left);
                }
            }

            while(!rightStack.isEmpty()){
                Node temp = rightStack.pop();
                ans.add(temp.data);
                if(temp.left != null){
                    leftStack.push(temp.left);
                }
                if(temp.right != null){
                    leftStack.push(temp.right);
                }
            }
        }
        return ans;
    }
}
