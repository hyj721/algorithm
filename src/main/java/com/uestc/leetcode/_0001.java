package com.uestc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hyj721
 * @create: 2024-07-27 19:59
 * @description: <a href="https://leetcode.cn/problems/two-sum/description/">...</a>
 **/
public class _0001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
