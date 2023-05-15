// Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.
class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
public class BFSzigzag2 {
    ArrayList<Integer> zigZagTraversal(Node root)
	{
	    ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> leftStack = new Stack<>();
        Stack<Node> rightStack = new Stack<>();

        if(root == null){
            return ans;
        }
        
        rightStack.push(root);

        while(!leftStack.isEmpty() || !rightStack.isEmpty()){
            
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
        }
        return ans;
	}
}
