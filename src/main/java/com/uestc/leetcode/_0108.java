package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-11 09:28
 * @description: <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/">...</a>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树。
 **/
public class _0108 {
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return sortedArrayToBST(nums, 0, nums.length - 1);
        }

        public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
            if (l > r) {
                return null;
            }
            if (l == r) {
                return new TreeNode(nums[l]);
            }
            int mid = l + r >> 1;
            TreeNode left = sortedArrayToBST(nums, l, mid - 1);
            TreeNode right = sortedArrayToBST(nums, mid + 1, r);
            return new TreeNode(mid, left, right);
        }
    }
}
