// Implement a Queue using Linked List. 
// A Query Q is of 2 Types
// (i) 1 x   (a query of this type means  pushing 'x' into the queue)
// (ii) 2     (a query of this type means to pop an element from the queue and print the poped element)
public class queue_using_LL {
    static class QueueNode {
        int data;
        QueueNode next;

        QueueNode(int a) {
            data = a;
            next = null;
        }
    }

    static class MyQueue {
        QueueNode front, rear;

        // Function to push an element into the queue.
        void push(int a) {
            QueueNode newNode = new QueueNode(a);
            if (front == null) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                rear = rear.next;
            }
        }

        // Function to pop front element from the queue.
        int pop() {
            int ans = -1;
            if (front == null) {
                return ans;
            } else {
                ans = front.data;
                front = front.next;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();

        obj.push(78);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.push(93);
        obj.pop();
        obj.pop();
        obj.push(28);
        obj.push(60);
        obj.pop();
        obj.push(41);
        obj.push(73);
        obj.push(12);
        obj.push(68);
        obj.push(31);
        obj.push(24);
        obj.pop();
        obj.pop();
        obj.pop();
    }
}
