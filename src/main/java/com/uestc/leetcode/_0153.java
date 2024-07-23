package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-23 21:16
 * @description: <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/">...</a>
 **/
public class _0153 {
    public int findMin(int[] nums) {
        int cutIndex = getCutIndex(nums);
        if (cutIndex == nums.length - 1) {
            return nums[0];
        } else {
            return nums[cutIndex + 1];
        }
    }

    // [>=x, <x]
    private int getCutIndex(int[] nums) {
        int x = nums[0];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] >= x) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
