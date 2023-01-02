// The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can attack each other.
// Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct board configurations of the n-queens’ placement, where the solutions are a permutation of [1,2,3..n] in increasing order, here the number in the ith place denotes that the ith-column queen is placed in the row with that number. For eg below figure represents a chessboard [3 1 4 2].

import java.util.ArrayList;

public class n_queens {
    static boolean anotherQueenCheck(int row, int col, int[][] board) {
        int rowCopy = row;
        int colCopy = col;

        while (col >= 0) {
            if (board[row][col] == 1) {
                return false;
            }
            col--;
        }

        row = rowCopy;
        col = colCopy;
        while (col >= 0 && row >= 0) {
            if (board[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }

        row = rowCopy;
        col = colCopy;
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 1) {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    static void generate(int col, int n, ArrayList<ArrayList<Integer>> finans, ArrayList<Integer> temp, int[][] board) {
        if (col == n) {
            finans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (anotherQueenCheck(i, col, board)) {
                board[i][col] = 1;
                temp.add(i + 1);
                generate(col + 1, n, finans, temp, board);
                temp.remove(temp.size() - 1);
                board[i][col] = 0;
            }
        }
    }

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        int[][] board = new int[n][n];
        ArrayList<ArrayList<Integer>> finans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        generate(0, n, finans, temp, board);
        return finans;
    }
}
