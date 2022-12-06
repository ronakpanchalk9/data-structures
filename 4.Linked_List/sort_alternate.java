// Given a Linked list of size N, the list is in alternating ascending and descending orders. Sort the given linked list in non-decreasing order.
public class sort_alternate {
    private Node head;
    private Node tail;
    private Node size;

    private class Node{
        private Node next;
        private int value;
        
        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    static Node merge(Node t1, Node t2){
        Node dummy = new Node(-1);
        Node temp = dummy;

        while(t1 != null && t2 != null){
            if(t1.value <= t2.value){
                temp.next = t1;
                t1 = t1.next;
            }else{
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
        }
        if(t1 != null){
            temp.next = t1;
            
        }

        if(t2 != null){
            temp.next = t2;
        }
        return dummy.next;
    }
    static Node reverse(Node head){
        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    static Node sort(Node head){
        Node asc = head;
        Node desc = asc.next;
        Node t1 = asc;
        Node t2 = desc;

        while(asc.next.next != null){
            asc.next = asc.next.next;
            asc = asc.next;
            desc.next = desc.next.next;
            desc = desc.next;
        }
        asc.next  = null;

        desc = reverse(desc);

        return merge(t1,t2);
    }
}
