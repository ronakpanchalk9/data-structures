public class median_in_matrix {
    //*Given a row wise sorted matrix of size rxc where r and c are always odd, find the median of the matrix. */
    static int median(int matrix[][], int r, int c) {
        int high = Integer.MAX_VALUE;
        int low = 0;
        int num = (r * c) >> 1;

        while (low <= high) {
            int count = 0;
            int mid = (low + high) >> 1;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (matrix[i][j] <= mid) {
                        count++;
                    }
                }
            }

            if (count <= num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println((73 * 57) >> 1);
    }
}
