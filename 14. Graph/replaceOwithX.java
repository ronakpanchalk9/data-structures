// Given a matrix mat of size N x M where every element is either O or X.
// Replace all O with X that are surrounded by X.
// A O (or a set of O) is considered to be surrounded by X if there are X at locations just below, just above, just left and just right of it.
public class replaceOwithX {
    static void dfs(char[][] a, int[][] vis, int row, int col) {
        vis[row][col] = 1;

        int[] x = { 1, -1, 0, 0 };
        int[] y = { 0, 0, -1, 1 };

        for (int i = 0; i < 4; i++) {
            int tempR = row + x[i];
            int tempC = col + y[i];

            if (tempR >= 0 && tempC >= 0 && tempR < a.length && tempC < a[0].length && a[tempR][tempC] == 'O'
                    && vis[tempR][tempC] == 0) {
                dfs(a, vis, tempR, tempC);
            }
        }
    }

    static char[][] fill(int n, int m, char a[][]) {
        // code here
        int[][] vis = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 'O' && (i == 0 || i == a.length - 1 || j == 0 || j == a[0].length - 1)) {
                    dfs(a, vis, i, j);
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (vis[i][j] == 0 && a[i][j] == 'O') {
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }
}
