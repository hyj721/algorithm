package com.uestc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: hyj721
 * @create: 2024-07-17 16:03
 * @description: <a href="https://leetcode.cn/problems/rotting-oranges/">...</a>
 **/
public class _0994 {
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int freshOrange = 0;
        int m = grid.length, n = grid[0].length;
        // 存储腐烂的橘子，用于 bfs
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOrange++;
                } else if (grid[i][j] == 2) {
                    queue.addLast(new int[]{i, j});
                }
            }
        }

        // 为什么需要一个 hasNewRotten ？
        // 因为当所有橘子都已经腐烂时，计时器 minutes 会多加一次。因此需要在每次循环结束后检查队列是否为空，如果不为空再增加 minutes。
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean hasNewRotten = false; // 记录是否有新的橘子腐烂
            for (int i = 0; i < size; i++) {
                int[] removed = queue.removeFirst();
                for (int[] dir : dirs) {
                    int nx = removed[0] + dir[0];
                    int ny = removed[1] + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.addLast(new int[]{nx, ny});
                        freshOrange--;
                        hasNewRotten = true;
                    }
                }
            }
            if (hasNewRotten) {
                minutes++;
            }
        }
        if (freshOrange == 0) {
            return minutes;
        }
        // freshOrange 不是 0，返回 -1
        return -1;
    }
}
