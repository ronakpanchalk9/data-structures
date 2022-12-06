// Q.Given a linked list consisting of L nodes and given a number N. The task is to find the Nth node from the end of the linked list.

public class nth_fromLast {
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

    static int get_nth_from_last(Node head, int n){
        int count = 0;
    	Node temp = head;
    	while(temp != null){
    	    count++;
    	    temp = temp.next;
    	}
    	temp = head;
    	if(count < n){
    	    return -1;
    	}
    	while(count - n != 0){
    	    temp = temp.next;
    	    count--;
    	}
    	return temp.value;
    }
}
