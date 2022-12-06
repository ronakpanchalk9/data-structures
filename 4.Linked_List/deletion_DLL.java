public class deletion_DLL {
    Node head;

    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next, Node prev){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    Node deleteNode(Node head, int x){
        Node prevNode = head;
        while(x != 1){
            prevNode = head;
            head = head.next;
            x--;
        }
        prevNode.next = head.next;
        if(head.next != null){
            head.next.prev = prevNode;
        }
        return head;
    }
    
}
