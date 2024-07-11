package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-10 21:45
 * @description: <a href="https://leetcode.cn/problems/symmetric-tree/">...</a>
 **/
public class _0101 {
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return false;
            }
            return isSymmetric(root.left, root.right);
        }
        private boolean isSymmetric(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
    }
}
