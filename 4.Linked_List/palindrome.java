public class palindrome {
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
    
    static boolean checkPalindrome(Node head){
        Node f = head;
        Node s = head;
        Node temp = head;

        while(f.next != null && f.next.next != null){
            f = f.next.next;
            s = s.next;
        }

        s = reverse(s.next);

        while(s != null){
            if(s.value != temp.value){
                return false;
            }
            s = s.next;
            temp = temp.next;
        }

        return true;
    }
}
