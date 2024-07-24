package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-24 09:31
 * @description: <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">...</a> 代码随想录「数组-4.有序数组的平方」
 **/
public class _0907 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int idx = res.length - 1;


        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                res[idx--] = nums[left] * nums[left];
                left++;
            } else {
                res[idx--] = nums[right] * nums[right];
                right--;
            }
        }
        return res;
    }
}
