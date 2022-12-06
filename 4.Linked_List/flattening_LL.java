// Given a Linked List of size N, where every node represents a sub-linked-list and contains two pointers:
// (i) a next pointer to the next node,
// (ii) a bottom pointer to a linked list where this node is head.
// Each of the sub-linked-list is in sorted order.
// Flatten the Link List such that all the nodes appear in a single level while maintaining the sorted order. 
// Note: The flattened list will be printed using the bottom pointer instead of next pointer. For more clearity have a look at the printList() function in the driver code.

public class flattening_LL {
    private Node head;
    private Node tail;
    private Node size;
    private Node bottom;

    private class Node{
        private Node next;
        private Node bottom;
        private int data;
        
        public Node(int data){
            this.data = data;
        }

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    static Node merge2LL(Node a, Node b){
        Node temp = new Node(0);
        Node res = temp; 
        
        while(a != null && b != null) {
            if(a.data < b.data) {
                temp.bottom = a; 
                temp = temp.bottom; 
                a = a.bottom; 
            }
            else {
                temp.bottom = b;
                temp = temp.bottom; 
                b = b.bottom; 
            }
        }
        
        if(a != null) temp.bottom = a; 
        else temp.bottom = b;
        return res.bottom; 
    }

    static Node flattening(Node root){
        if (root == null || root.next == null) 
                return root; 
      
            // recur for list on right 
            root.next = flatten(root.next); 
      
            // now merge 
            root = mergeTwoLists(root, root.next); 
      
            // return the root 
            // it will be in turn merged with its left 
            return root; 
    }
}
