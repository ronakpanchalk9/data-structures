import java.util.*;

class Pair {
    int wt;
    int row;
    int col;

    Pair(int w, int r, int c) {
        this.wt = w;
        this.row = r;
        this.col = c;
    }
}

class shortestPathMtrx {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        // int[][] visited = new int[grid.length][grid[0].length];
        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        int[][] ans = new int[grid.length][grid[0].length];

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = (int) 1e9;
            }
        }

        ans[source[0]][source[1]] = 0;
        q.add(new Pair(0, source[0], source[1]));

        int[] x = { -1, 1, 0, 0 };
        int[] y = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            Pair curr = q.peek();
            q.remove();
            int dist = curr.wt;
            int r = curr.row;
            int c = curr.col;

            for (int i = 0; i < 4; i++) {
                int tr = r + x[i];
                int tc = c + y[i];

                if (tr < grid.length && tc < grid[0].length && tr >= 0 && tc >= 0 && grid[tr][tc] == 1
                        && dist + 1 < ans[tr][tc]) {
                    ans[tr][tc] = dist + 1;
                    if (tr == destination[0] && tc == destination[1]) {
                        return dist + 1;
                    }
                    q.add(new Pair(dist + 1, tr, tc));
                }
            }
        }

        return -1;

    }
}