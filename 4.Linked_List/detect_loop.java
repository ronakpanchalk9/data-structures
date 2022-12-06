public class detect_loop{
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
    static boolean detect(Node head){
        Node s = head;
        Node f = head;

        while(s.next != null){
            s = s.next;
            f = f.next.next;
            if(f == s){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}