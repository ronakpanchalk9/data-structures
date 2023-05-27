public class modifyLL {
    private Node head;
    private Node tail;
    private Node size;

    private class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static Node modifyTheList(Node head) {
        Node s = head;
        Node f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        Node temp = head;
        int n = 0;

        while (temp != null) {
            n++;
            temp = temp.next;
        }
        temp = head;

        while (temp.next != s) {
            temp = temp.next;
        }

        Node mid = s;
        temp.next = reverseList(s);

        temp = temp.next;
        Node change = head;

        if (n % 2 == 0) {
            while (temp != null) {
                int start_data = change.data;
                change.data = temp.data - start_data;
                temp.data = start_data;
                temp = temp.next;
                change = change.next;
            }
        } else {
            while (temp.next != null) {
                int start_data = change.data;
                change.data = temp.data - start_data;
                temp.data = start_data;
                temp = temp.next;
                change = change.next;
            }
        }

        mid = head;

        while (mid.next != change) {
            mid = mid.next;
        }

        mid.next = reverseList(change);
        return head;
    }
}
