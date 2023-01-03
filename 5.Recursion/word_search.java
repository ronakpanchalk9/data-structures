// Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed from letters of adjacent cells only. ie - horizontal or vertical neighbors. The same letter cell can not be used more than once

public class word_search {
    static boolean isCheck(char[][] board, int row, int col, String word, int idx) {
        if (idx >= word.length()) {
            return true;
        }
        
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return false;
        }
        
        if (board[row][col] == '.'|| word.charAt(idx) != board[row][col]) {
            return false;
        }

        board[row][col] = '.';

        boolean temp = false;

        int[] x = { 0, 0, -1, 1 };
        int[] y = { -1, 1, 0, 0 };

        for (int i = 0; i < 4; i++) {
            temp = temp || isCheck(board, row + x[i], col + y[i], word, idx + 1);
        }
        board[row][col] = word.charAt(idx);
        return temp;
    }

    public boolean isWordExist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (isCheck(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
