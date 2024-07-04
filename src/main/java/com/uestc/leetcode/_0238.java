package com.uestc.leetcode;

/**
 * @description: <a href="https://leetcode.cn/problems/product-of-array-except-self">...</a>
 * @author: hyj721
 * @date: 2024-07-03 09:43
 **/
public class _0238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            // 此题不能使用除法，而且需要在O(n)的时间复杂度内完成
            // 定义left[i]为小于等于下标i的元素的乘积，right[i]为大于等于下标i的元素的乘积
            int n = nums.length;
            int[] left = new int[n];
            int[] right = new int[n];

            // 初始化left
            left[0] = nums[0];
            for (int i = 1; i < n; i++) {
                left[i] = left[i - 1] * nums[i];
            }
            // 初始化right
            right[n - 1] = nums[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                right[i] = right[i + 1] * nums[i];
            }

            int[] res = new int[n];
            res[0] = right[1];
            res[n - 1] = left[n - 2];
            for (int i = 1; i < n - 1; i++) {
                res[i] = left[i - 1] * right[i + 1];
            }
            return res;
        }
    }
}
