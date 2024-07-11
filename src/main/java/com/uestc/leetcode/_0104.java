package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-10 21:36
 * @description: https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 **/
public class _0104 {
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (root.left == null && root.right == null){
                return 1;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
