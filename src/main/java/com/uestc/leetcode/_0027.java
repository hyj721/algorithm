package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-24 09:26
 * @description: <a href="https://leetcode.cn/problems/remove-element/">...</a> 代码随想录 「数组-3.移除元素」
 **/
public class _0027 {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        // 如果fast指针的值不是val，才会赋给slow所指处。
        for (; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
