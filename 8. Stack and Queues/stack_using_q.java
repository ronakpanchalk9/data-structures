// Implement a Stack using two queues q1 and q2.
import java.util.Queue;

public class stack_using_q {
    class Queues {
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();

        // Function to push an element into stack using two queues.
        void push(int a) {
            if(q2.size() > 0){
                q2.add(a);
            }else{
                q1.add(a);
            }
            
        }
        // 1 78 2 2 2 1 93 2 2 1 28 1 60 2 1 41 1 73 1 12 1 68 2 1 31 1 24 2 2 2 1 23 1 70 2 2 1 12 1 30 2 2 2 1 38 1 25 2 1 14 1 92 1 57 2 1 71 1 82 2 2 1 28 1 6 1 30 2 2 1 96 1 46 1 68 1 65 2 1 88 1 77 1 89 1 4 2 1 100 1 61 1 69 2 1 27 1 95 2 2 1 35 1 68 2 2 1 18 1 53 1 2 1 87 2 2 2 1 20 1 30 2 2 2 2 2 2 2 2
        // Function to pop an element from stack using two queues.
        int pop() {
            if (q1.size() != 0) {
                while (q1.size() != 1) {
                    q2.add(q1.poll());
                }
                return q1.poll();
            } else if (q2.size() != 0) {
                while (q2.size() != 1) {
                    q1.add(q2.poll());
                }
                return q2.poll();
            } else {
                return -1;
            }
        }

    }
}
