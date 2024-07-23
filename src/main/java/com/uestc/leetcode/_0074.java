package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-23 08:36
 * @description: <a href="https://leetcode.cn/problems/search-a-2d-matrix/">...</a>
 **/
public class _0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
