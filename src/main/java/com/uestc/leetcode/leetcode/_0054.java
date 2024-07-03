package com.uestc.leetcode.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: <a href="https://leetcode.cn/problems/spiral-matrix/">...</a>
 * @author: hyj721
 * @date: 2024-07-03 11:14
 **/
public class _0054 {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;
            int count = 1;
            while (true) {
                // 上面的行
                for (int j = left; j <= right; j++) {
                    res.add(matrix[up][j]);
                }
                if (++up > down) {
                    break;
                }
                // 右边的列
                for (int i = up; i <= down; i++) {
                    res.add(matrix[i][right]);
                }
                if (--right < left) {
                    break;
                }
                // 下面的行
                for (int j = right; j >= left; j--) {
                    res.add(matrix[down][j]);
                }
                if (--down < up) {
                    break;
                }
                // 左边的行
                for (int i = down; i >= up; i--) {
                    res.add(matrix[i][left]);
                }
                if (++left > right) {
                    break;
                }
            }
            return res;
        }
    }
}