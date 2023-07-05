import java.util.*;
class Pair{
    int row;
    int col;
    Pair(int r, int c){
        this.row = r;
        this.col = c;
    }
}
public class distinctIslands {
    int countDistinctIslands(int[][] grid){
        
        HashSet<ArrayList<String>> st = new HashSet<>();
        int[][] vis = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,vis, grid, list, i, j);
                    st.add(list);
                }
            }
        }
        return st.size();
    }

    private String toString(int r, int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    private void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> list, int baseR, int baseC) {
        vis[row][col] = 1;
        list.add(toString(row - baseR, col- baseC));
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};

        for (int i = 0; i < 4; i++) {
            int tempR = row + x[i];
            int tempC = col + y[i];

            if(tempR >= 0 && tempC >= 0 && tempR < vis.length && tempC < vis[0].length && vis[tempR][tempC] == 0 && grid[tempR][tempC] == 1){
                dfs(tempR, tempC, vis, grid, list, baseR, baseC);
            }
        }
    }
}
