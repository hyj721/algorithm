package com.uestc.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: hyj721
 * @create: 2024-07-21 08:42
 * @description: <a href="https://leetcode.cn/problems/n-queens/">...</a>
 **/
public class _0051 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 准备棋盘
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        dfs(n, board, 0);
        return res;

    }

    private void dfs(int n, char[][] board, int index) {
        if (index == n) {
            res.add(toList(board));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(board, index, j)) {
                board[index][j] = 'Q';
                dfs(n, board, index + 1);
                board[index][j] = '.';
            }
        }

    }

    private List<String> toList(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(String.valueOf(row));
        }
        return res;
    }

    private boolean isValid(char[][] board, int x, int y) {
        for (int i = 0; i < x; i++) {
            if (board[i][y] == 'Q') {
                return false;
            }
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = x - 1, j = y + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
