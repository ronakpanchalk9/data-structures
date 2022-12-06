// A number N is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.
public class add_one {
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

    static Node add1(Node head){
        Node temp = head;
        temp = reverse(temp);
        Node t1 = temp;
        Node prev = t1;
        boolean carry = true;

        while(temp != null && carry){
            prev = temp;
            temp.value += 1;
            if(temp.value == 10){
                temp.value = 0;
                carry = true;
            }else{
                carry = false;
            }
            temp = temp.next;
        }
        if(prev.value == 0){
            Node one = new Node(1);
            prev.next = one;
        }
        t1 = reverse(t1);
        return t1;
    }
    public static void main(String[] args) {
        System.out.println(10%10);
    }
}
