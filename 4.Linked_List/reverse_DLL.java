public class reverse_DLL {
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

    static Node reverse(Node head){
        Node ptr1 = head;
        Node ptr2 = ptr1.next;

        ptr1.next = null;
        ptr1.prev = ptr2;

        while(ptr2 != null){
            ptr2.prev = ptr2.next;
            ptr2.next = ptr1;
            ptr1 = ptr2;
            ptr2 = ptr2.prev;
        }

        head = ptr1;
        return head;

    }
}
