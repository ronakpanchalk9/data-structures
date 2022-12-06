public class matrix_search {
    public static int matSearch(int[][] mat, int N, int M, int X){
        int r = 0;
        int c = M-1;

        while(c > 0){
            if(mat[r][c] == X){
                return 1;
            }else if(mat[r][c] < X){
                r++;
            }else if(mat[r][c] > X){
                c--;
            }

        }
        return 0;
    }
    public static void main(String[] args) {
        
    }
}
