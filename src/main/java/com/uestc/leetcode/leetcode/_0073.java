package com.uestc.leetcode.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: <a href="https://leetcode.cn/problems/set-matrix-zeroes/">...</a>
 * @author: hyj721
 * @date: 2024-07-03 11:04
 **/
public class _0073 {
    class Solution {
        public void setZeroes(int[][] matrix) {
            Set<Integer> rows = new HashSet<>();
            Set<Integer> cols = new HashSet<>();
            // 记录有0的行和列
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        rows.add(i);
                        cols.add(j);
                    }
                }
            }
            // 分别遍历2个set，置为0
            for (Integer row : rows) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[row][j] = 0;
                }
            }

            for (Integer col : cols) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][col] = 0;
                }
            }
        }
    }
}
