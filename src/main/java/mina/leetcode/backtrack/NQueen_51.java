package mina.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后问题
 */

// TODO: 2021-06-07 省空间的算法
public class NQueen_51 {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }

        backtrack(board, 0, n);
        return result;
    }

    private void backtrack(char[][] board, int row, int n) {
        if (row == n) {
            result.add(boardToList(board));
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

    private List<String> boardToList(char[][] board) {

        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            list.add(String.copyValueOf(c));
        }
        return list;

    }


    public static void main(String[] args) {
        NQueen_51 queen = new NQueen_51();
        queen.solveNQueens(2);
        System.out.println(queen.result);

    }
}
