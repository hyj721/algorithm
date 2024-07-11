package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-10 21:38
 * @description: https://leetcode.cn/problems/invert-binary-tree/
 **/
public class _0226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }
}
