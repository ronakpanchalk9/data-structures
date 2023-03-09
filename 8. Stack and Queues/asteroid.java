import java.util.Stack;

public class asteroid {
    static int[] asteroidCOllision(int n, int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            boolean tabah = false;
            while (st.size() != 0) {
                if ((st.peek() < 0 && asteroids[i] < 0) || (st.peek() > 0 && asteroids[i] > 0)) {
                    break;
                } else if (st.peek() > 0 && asteroids[i] < 0) {
                    if (((-1) * asteroids[i]) > st.peek()) {
                        st.pop();
                    } else if (((-1) * asteroids[i]) < st.peek()) {
                        tabah = true;
                        break;
                    } else if (((-1) * asteroids[i]) == st.peek()) {
                        tabah = true;
                        st.pop();
                        break;
                    }
                } else if (st.peek() < 0 && asteroids[i] > 0) {
                    break;
                }
            }
            if (tabah == false) {
                st.push(asteroids[i]);
            }
        }

        int[] ans = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}
