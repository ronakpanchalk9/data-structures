import java.util.HashMap;

public class intersection {
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

    static Node findIntersection(Node head1, Node head2){
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        int count = 1;

        while(head2 != null){
            hmap.put(head2.value, count);
            count++;
        }

        Node temp = new Node(-1);

        while(head1 != null){
            if(hmap.containsKey(head1.value)){
                Node ans = new Node(head1.value);
                temp.next = ans;
            }
        }
        temp.next = null;
        return temp;
    }
}
