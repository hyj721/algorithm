package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-23 09:19
 * @description: <a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/">...</a>
 * 1 <= nums.length <= 5000
 **/
public class _0033 {
    public int search(int[] nums, int target) {
        int x = nums[0];
        // [>=x, <x]
        int cutIndex = getCutIndex(nums, x); // 获取分割点，即>=x的最后一个
        // 如果target理论上在右边，而右边又是空的，则返回-1
        if (target < x && cutIndex == nums.length - 1) {
            return -1;
        }
        // 在左半部分
        if (target >= x) {
            // 再次二分
            int index = getFirstIndex(nums, target, 0, cutIndex);
            return nums[index] == target ? index : -1;
        } else {
            // 在右半部分
            int index = getFirstIndex(nums, target, cutIndex + 1, nums.length - 1);
            return nums[index] == target ? index : -1;
        }
    }

    private int getCutIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (nums[mid] >= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int getFirstIndex(int[] nums, int target, int left, int right) {
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

    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
        _0033 solution = new _0033();
        System.out.println(solution.search(arr, 0));
    }
}
