package com.uestc.leetcode.leetcode;

/**
 * @description: <a href="https://leetcode.cn/problems/first-missing-positive/">...</a>
 * @author: hyj721
 * @date: 2024-07-03 09:51
 **/
public class _0041 {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            // 调整数组，使得每个正整数尽可能放到它们“应该”在的位置上
            for (int i = 0; i < n; i++) {
                // 使用 while 循环而不是 if，确保在交换后继续检查当前位置的元素
                while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                    int position = nums[i] - 1;
                    int tmp = nums[i];
                    nums[i] = nums[position];
                    nums[position] = tmp;
                }
            }
            // 第二次遍历，找到第一个位置上数值不正确的索引
            for (int i = 0; i < n; i++) {
                if (i + 1 != nums[i]) {
                    return i + 1;
                }
            }
            // 如果所有位置都正确，则缺失的最小正整数是 n + 1
            return n + 1;
        }
    }
}
