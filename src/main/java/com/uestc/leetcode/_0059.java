package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-24 09:46
 * @description: <a href="https://leetcode.cn/problems/spiral-matrix-ii">...</a> 代码随想录 「数组-5.螺旋矩阵 II」
 **/
public class _0059 {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, down = n - 1;
        int count = 1;
        int[][] res = new int[n][n];
        while (true) {
            // 上
            for (int j = left; j <= right; j++) {
                res[top][j] = count++;
            }
            if (++top > down) {
                break;
            }

            // 右
            for (int i = top; i <= down; i++) {
                res[i][right] = count++;
            }
            if (--right < left) {
                break;
            }

            // 下
            for (int j = right; j >= left; j--) {
                res[down][j] = count++;
            }
            if (--down < top) {
                break;
            }

            // 左
            for (int i = down; i >= top; i--) {
                res[i][left] = count++;
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }
}
