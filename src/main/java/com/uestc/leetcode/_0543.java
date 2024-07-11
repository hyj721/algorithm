package com.uestc.leetcode;

import java.util.Map;

/**
 * @author: hyj721
 * @create: 2024-07-10 21:49
 * @description: <a href="https://leetcode.cn/problems/diameter-of-binary-tree/">...</a>
 **/
public class _0543 {
    class Solution {
        private int res = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            getDepth(root);
            return res;
        }

        private int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = getDepth(root.left);
            int right = getDepth(root.right);
            res = Math.max(left + right, res);
            return Math.max(left, right) + 1;
        }

    }
}
