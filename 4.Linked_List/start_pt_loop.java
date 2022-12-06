public class start_pt_loop {
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

    static Node detectCycle(Node head){
        Node fast = head;
        Node slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                Node temp = head;
                while(slow != temp){
                    slow = slow.next;
                    temp = temp.next;
                }
                return temp;
            }
        }
        
        return null;
    }
}
