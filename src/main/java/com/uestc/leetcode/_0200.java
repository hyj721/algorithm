package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-17 15:49
 * @description: <a href="https://leetcode.cn/problems/number-of-islands/">...</a>
 **/
public class _0200 {
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int res = 0;
    public int numIslands(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        // 打印一下
        printGrid(grid);
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        grid[i][j] = 2;
        for (int[] dir : dirs) {
            if (isValidPosition(grid, i + dir[0], j + dir[1]) && grid[i + dir[0]][j + dir[1]] == 1) {
                dfs(grid, i + dir[0], j + dir[1]);
            }
        }
    }

    private boolean isValidPosition(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid.length;
    }

    private void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
