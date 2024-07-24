package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-24 09:19
 * @description: <a href="https://leetcode.cn/problems/binary-search/">...</a> 代码随想录 「数组-2.二分查找」
 **/
public class _0704 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // [>=, <]
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
