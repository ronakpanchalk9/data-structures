// Create a link list of size N according to the given input literals. Each integer input is accompanied by an indicator which can either be 0 or 1. If it is 0, insert the integer in the beginning of the link list. If it is 1, insert the integer at the end of the link list. 
// Hint: When inserting at the end, make sure that you handle NULL explicitly.

public class insertion {
    private Node head;
    private Node tail;
    private int size;

    public insertion() {
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

    Node insertAtBeginning(Node head, int x) {
        Node node = new Node(x);

        if (head == null) {
            head = node;
            return head;
        }
        node.next = head;
        head = node;
        return head;
    }

    Node insertAtEnd(Node head, int x) {
        Node node = new Node(x);
        if (head == null) {
            head = node;
            return head;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }

    public static void main(String[] args) {

    }
}