package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-24 09:36
 * @description: <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">...</a> 代码随想录「数组-4.长度最小的子数组」
 **/
public class _0209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int cur = 0;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            cur += nums[right++];
            while (cur >= target) {
                res = Math.min(res, right - left);
                cur -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
