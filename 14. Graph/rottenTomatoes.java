import java.util.*;

class Pair{
    int row;
    int col;
    int time;

    Pair(int r, int c, int t){
        this.row = r;
        this.col = c;
        this.time = t;
    }
}
public class rottenTomatoes {
    public int orangesRotting(int[][] grid){
        int r = grid.length;
        int c = grid[0].length;
        int freshOrng = 0;
        int[][] visited = new int[r][c];
        Queue<Pair> q = new LinkedList<>();
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 0){
                    visited[i][j] = 0;
                }else if(grid[i][j] == 2){
                    visited[i][j] = 2;
                    q.add(new Pair(i, j, 0));
                }else{
                    visited[i][j] = 1;
                    freshOrng++;
                }
            }
        }

        int time = 0;
        int[] x ={-1,1,0,0};
        int[] y = {0,0,-1,1};
        int countRotten = 0;

        while(!q.isEmpty()){
            int tempR = q.peek().row;
            int tempC = q.peek().col;
            int tempT = q.peek().time;

            time = Math.max(time, tempT);
            q.remove();

            for (int i = 0; i < 4; i++) {
                int rowLimit = tempR + x[i];
                int colLimit = tempC + y[i];

                if(rowLimit >= 0 && colLimit >= 0 && rowLimit < r && colLimit < c && visited[rowLimit][colLimit] == 1 && grid[rowLimit][colLimit] == 1){
                    q.add(new Pair(rowLimit, colLimit, time+1));
                    visited[rowLimit][colLimit] = 2;
                    countRotten++;
                }
            }
        }

        if(countRotten != freshOrng){
            return -1;
        }
        return time;
    }
}
