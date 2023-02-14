
// You are given N elements and your task is to implement a Stack in which you can get minimum element in O(1) time.
import java.util.*;

public class min_element {
    class GfG {
        int minEle;
        Stack<Integer> s;

        /* returns min element from stack */
        int getMin() {
            if (s.size() == 0) {
                return -1;
            }
            return minEle;
        }

        /* returns poped element from stack */
        int pop() {
            if (s.size() == 0) {
                return -1;
            }
            if (s.peek() >= minEle) {
                return s.pop();
            } else {
                int ans = minEle;
                minEle = 2 * minEle - s.peek();
                s.pop();
                return ans;
            }
        }

        /* push element x into the stack */
        void push(int x) {
            if (s.size() == 0) {
                minEle = x;
                s.push(x);
            } else {
                if (x >= minEle) {
                    s.push(x);
                } else {
                    s.push(2 * x - minEle);
                    minEle = x;
                }
            }
        }
    }
}
