// Given two decimal numbers represented by two linked lists of size N and M respectively. The task is to return a linked list that represents the sum of these two numbers.

// For example, the number 190 will be represented by the linked list, 1->9->0->null, similarly 25 by 2->5->null. Sum of these two numbers is 190 + 25 = 215, which will be represented by 2->1->5->null. You are required to return the head of the linked list 2->1->5->null.

public class add_two_num {
    private Node head;
    private Node tail;
    private Node size;

    private class Node{
        private Node next;
        private int data;
        
        public Node(int data){
            this.data = data;
        }

        public Node(int data, Node next){
            this.data = data;
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
    static Node addTwoLists(Node first, Node second){
        int carry = 0;
        Node t1 = first;
        Node t2 = second;
        
        Node ans = new Node(-1);
        Node finT = ans;
        t1 = reverse(t1);
        t2 = reverse(t2);

        while(t1 != null && t2 != null){
            Node node = new Node(t1.data + t2.data + carry);
            carry = 0;
            if(node.data > 9){
                node.data %= 10;
                carry = 1;
            }
            ans.next = node;

            ans = ans.next;
            t1 = t1.next;
            t2 = t2.next;
        }

        while(t1 != null){
            Node node = new Node(t1.data + carry);
            carry = 0;
            if(node.data > 9){
                node.data %= 10;
                carry = 1;
            }

            ans.next = node;
            ans = ans.next;
            t1 = t1.next;
        }

        while(t2 != null){
            Node node = new Node(t2.data + carry);
            carry = 0;
            if(node.data > 9){
                node.data %= 10;
                carry = 1;
            }

            ans.next = node;
            ans = ans.next;
            t2 = t2.next;
        }
        
        if(carry == 1){
            Node one = new Node(1);
            ans.next = one;
            ans = ans.next;
        }
        finT = reverse(finT.next);

        return finT;
    }
}
