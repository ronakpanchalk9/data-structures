public class insertion_DLL {
    Node head;
    public void addNode(Node head, int pos, int data){
        Node node = new Node(data);
        Node temp = head;

        while(pos != 0){
            temp = temp.next;
            pos--;
        }
        node.prev = head;
        node.next = head.next;
        head.next = node;
        if(node.next != null){
            node.next.prev = node;
        }
    }
    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
