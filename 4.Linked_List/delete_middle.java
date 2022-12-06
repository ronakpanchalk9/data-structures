// Given a singly linked list, delete middle of the linked list. For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5.
// If there are even nodes, then there would be two middle nodes, we need to delete the second middle element. For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
// If the input linked list is NULL or has 1 node, then it should return NULL
public class delete_middle {
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

    static Node delete_mid(Node head){
        Node f = head;
        Node s = head;
        Node prev = head;
        if(f.next == null){
            return null;
        }
        if(f.next.next == null){
            f.next = null;
            return head;
        }
        while(f != null && f.next != null){
            prev = s;
            s = s.next;
            f = f.next.next;            
        }
        prev.next = s.next;
        return head;
    }
}
