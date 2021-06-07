package mina.leetcode.backtrack;

import java.util.Arrays;

public class NQueen_52 {
    int res = 0;

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }

        backtrack(board, 0, n);
        return res;
    }

    private void backtrack(char[][] board, int row, int n) {
        if (row == n) {
            res++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col, n))
                continue;

            board[row][col] = 'Q';
            backtrack(board, row + 1, n);
            board[row][col] = '.';

        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        //检查列冲突
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }

        // 右上方
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        // 左上方
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }


    public static void main(String[] args) {
        NQueen_52 queen = new NQueen_52();
        queen.totalNQueens(4);
        System.out.println(queen.res);

    }
}
