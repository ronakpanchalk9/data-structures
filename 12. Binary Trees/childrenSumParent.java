class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root == null){
            return 1;
        }
        if(root.left != null && root.right != null){
            if(root.left.data + root.right.data != root.data){
                return 0;
            }
        }else if(root.left != null && root.left.data != root.data){
            return 0;
        }else if(root.right != null && root.right.data != root.data){
            return 0;
        }
        return isSumProperty(root.left) & isSumProperty(root.right);
    }
}
