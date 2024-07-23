package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-23 08:23
 * @description: <a href="https://leetcode.cn/problems/search-insert-position/">...</a>
 **/
public class _0035 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
