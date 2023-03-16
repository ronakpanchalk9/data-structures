public class celebrityProblem {
    static int celebritu(int M[][], int n) {
        int ans = -1;
        int row = 0;
        int celebcount = 1;

        for (int i = 1; i < n && row < n; i++) {
            if(row == i){
                continue;
            }
            if (M[row][i] == 1) {
                i = -1;
                row++;
                celebcount = 1;
            } else if (M[row][i] == 0 && M[i][row] == 1) {
                celebcount++;
            } 
        }

        if (celebcount == n) {
            return row;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
        int n = 3;
        System.out.println(celebritu(arr, n));
    }
}
