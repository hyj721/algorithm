package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-04 09:30
 * @description: <a href="https://leetcode.cn/problems/search-a-2d-matrix-ii/">...</a>
 **/
public class _0240 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int x = 0, y = matrix[0].length - 1;
            while (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) {
                if (matrix[x][y] == target) {
                    return true;
                } else if (matrix[x][y] < target) {
                    x++;
                } else {
                    y--;
                }
            }
            // 如果在里面没有找到，就返回false
            return false;
        }
    }
}
