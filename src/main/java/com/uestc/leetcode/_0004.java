package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-27 10:23
 * @description: <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/">...</a>
 **/
public class _0004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] nums = new int[m + n];
        int index = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[index++] = nums1[i++];
            } else {
                nums[index++] = nums2[j++];
            }
        }
        while (i < m) {
            nums[index++] = nums1[i++];
        }
        while (j < n) {
            nums[index++] = nums2[j++];
        }
        int length = nums.length;
        if ((length & 1) == 1) {
            return nums[length / 2];
        } else {
            return (nums[(length - 1) / 2] + nums[length / 2]) / 2.0;
        }
    }
}