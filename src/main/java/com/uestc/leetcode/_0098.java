package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-11 09:43
 * @description: <a href="https://leetcode.cn/problems/validate-binary-search-tree/">...</a>
 **/
public class _0098 {
    class Solution {
        TreeNode pre = null;
        Boolean flag = true;
        public boolean isValidBST(TreeNode root) {
            dfs(root);
            return flag;
        }
        private void dfs(TreeNode cur) {
            // 空树是 BST
            if (cur == null) {
                return;
            }
            // dfs 左子树
            dfs(cur.left);
            // 如果有 pre 节点就比较
            if (pre != null && pre.val >= cur.val) {
                flag = false;
                return;
            }
            // 不论有没有 pre 节点，都需要记录更新 pre 节点
            pre = cur;
            dfs(cur.right);
        }
    }
}
