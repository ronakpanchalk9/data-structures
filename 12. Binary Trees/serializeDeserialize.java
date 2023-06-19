// Serialization is to store a tree in an array so that it can be later restored and Deserialization is reading tree back from the array. Now your task is to complete the function serialize which stores the tree into an array A[ ] and deSerialize which deserializes the array to the tree and returns it.
// Note: The structure of the tree must be maintained. Multiple nodes can have the same data.
public class serializeDeserialize {
    int index = 0;
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    //code here
	    if(root == null){
	        A.add(-1);
	        return;
	    }
	    
	    A.add(root.data);
	    serialize(root.left, A);
	    serialize(root.right, A);
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        
        if(A.size()==index){
            return null;
        }
        
        int val = A.get(index);
        index++;
        
        if(val == -1){
            return null;
        }
        
        Node root = new Node(val);
        
        root.left=(deSerialize(A));
        root.right=(deSerialize(A));
        
        return root;
    }
}
