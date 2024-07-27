package com.uestc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: hyj721
 * @create: 2024-07-27 19:35
 * @description: <a href="https://leetcode.cn/problems/intersection-of-two-arrays/description/">...</a>
 **/
public class _0349 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            for (int num : nums1) {
                set1.add(num);
            }

            Set<Integer> res = new HashSet<>();
            for (int i = 0; i < nums2.length; i++) {
                if (set1.contains(nums2[i])) {
                    res.add(nums2[i]);
                }
            }

            int[] result = new int[res.size()];
            int index = 0;
            for (Integer num : res) {
                result[index++] = num;
            }
            return result;
        }
    }
}
