import java.util.ArrayList;

// Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
// Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.
public class rat_maze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> finans = new ArrayList<>();

        if (m[0][0] != 1 || m[n - 1][n - 1] != 1) {
            finans.add("-1");
            return finans;
        }

        pathCheck(finans, 0, 0, n, m, "");
        return finans;
    }

    public static void pathCheck(ArrayList<String> finans, int row, int col, int n, int[][] m, String string) {
        if (row >= n - 1 && col >= n - 1) {
            finans.add(string);
            return;
        }

        if (row < 0 || col < 0 || row >= n || col >= n) {
            return;
        }
        if (m[row][col] == 0 || m[row][col] == 2) {
            return;
        }

        m[row][col] = 2;

        int[] x = { -1, 1, 0, 0 };
        int[] y = { 0, 0, -1, 1 };
        char[] dir = { 'U', 'D', 'L', 'R' };

        for (int i = 0; i < 4; i++) {
            pathCheck(finans, row + x[i], col + y[i], n, m, string + dir[i]);
        }
        m[row][col] = 1;

    }
}
