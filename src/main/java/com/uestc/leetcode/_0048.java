package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-04 09:07
 * @description: <a href="https://leetcode.cn/problems/rotate-image/">...</a>
 **/
public class _0048 {
    class Solution {
        public void rotate(int[][] matrix) {
            // 注意区分k和n，一开始把k和n搞混了
            int m = matrix.length / 2;
            int k = (matrix.length + 1) / 2;
            int n = matrix.length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < k; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 -j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 -i][n - 1 - j];
                    matrix[n - 1 -i][n - 1 - j] = matrix[j][n - 1 -i];
                    matrix[j][n - 1 -i] = tmp;
                }
            }
        }
    }
}
