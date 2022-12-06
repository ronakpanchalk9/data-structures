public class separate_evenodd {
    private Node head;
    private Node tail;
    private Node size;

    private class Node {
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static Node divide(int N, Node head) {
        if (head == null || head.next == null){
            return head;
        }

        Node even = new Node(-1);
        Node pe = even;

        Node odd = new Node(-1);
        Node po = odd;

        Node curr = head;
        
        while (curr != null) {
            if (curr.value % 2 != 0) {
                po.next = curr;
                po = po.next;
            } else {
                pe.next = curr;
                pe = pe.next;
            }
            curr = curr.next;
        }
        pe.next = odd.next;
        po.next = null;
        return even.next;
    }
}
