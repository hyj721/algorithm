package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-21 08:14
 * @description: <a href="https://leetcode.cn/problems/word-search/">...</a>
 **/
public class _0079 {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean exist(char[][] board, String word) {
        char begin = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (begin == board[i][j]) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 进入的时候，保证了index对应的位置是正确的元素
     */
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length() - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '1';
        for (int[] dir : dirs) {
            int nextx = i + dir[0];
            int nexty = j + dir[1];
            if (valid(board, nextx, nexty) && board[nextx][nexty] == word.charAt(index + 1)) {
                if (dfs(board, word, nextx, nexty, index + 1)) {
                    return true;
                }
            }
        }
        board[i][j] = tmp;
        return false;
    }

    private boolean valid(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
