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
public class maxWidth {
    int getMaxWidth(Node root) {
        int maxW = 0;
        Stack<Node> leftStack = new Stack<>();
        Stack<Node> rightStack = new Stack<>();

        if(root == null){
            return maxW;
        }
        
        leftStack.push(root);
        maxW = 1;

        while(!leftStack.isEmpty() || !rightStack.isEmpty()){
            while(!leftStack.isEmpty()){
                Node temp = leftStack.pop();
                if(temp.right != null){
                    rightStack.push(temp.right);
                }
                if(temp.left != null){
                    rightStack.push(temp.left);
                }
                maxW = Math.max(rightStack.size(), maxW);
            }

            while(!rightStack.isEmpty()){
                Node temp = rightStack.pop();
                if(temp.left != null){
                    leftStack.push(temp.left);
                }
                if(temp.right != null){
                    leftStack.push(temp.right);
                }
                maxW = Math.max(maxW, leftStack.size());
            }
        }
        return maxW;
    }
}
