public class length_loop {
    private Node head;
    private Node size;
    private Node tail;

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

    static int countNodes(Node head){
        Node f = head;
        Node s = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
            if(f == s){
                Node temp = head;
                int num = 1;
                while(s != temp){
                    s = s.next;
                    temp = temp.next;
                    num++;
                }
                s = s.next;
                int count = num+1;
                while(s != temp){
                    s = s.next;
                    count++;
                }
                return count - num;
            }
        }
        return 0;
    }
}
