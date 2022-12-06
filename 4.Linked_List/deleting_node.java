// Given a singly linked list and an integer x.Delete xth node from the singly linked list.
public class deleting_node {
    private Node head;
    private Node tail;
    private int size;

    public deleting_node() {
        this.size = 0;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node delete_node(Node head, int x) {
        Node prev = head;
        Node current = head;
        if(x == 1){
            head = head.next;
        }

        while(x != 1){
            prev = current;
            current = current.next;
            x--;
        }
        prev.next = current.next;
        current = null;
        return head;
    }

}
