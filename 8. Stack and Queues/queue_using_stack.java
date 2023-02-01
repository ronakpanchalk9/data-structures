// Implement a Queue using two stack s1 and s2.
public class queue_using_stack {
    class Queue {
        Stack<Integer> input = new Stack<Integer>();
        Stack<Integer> output = new Stack<Integer>();

        /* The method pop which return the element poped out of the stack */
        int dequeue() {
            int ans = -1;
            if (input.size() != 0) {
                while (input.size() != 1) {
                    output.add(input.pop());
                }
                ans = input.pop();
                while(output.size()!= 0){
                    input.add(output.pop());
                }
            }
            return ans; 
        }

        /* The method push to push element into the stack */
        void enqueue(int x) {
            input.add(x);
        }
    }
}
