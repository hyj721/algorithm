package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-15 17:19
 * @description: <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/">...</a>
 **/
public class _0230 {
    private TreeNode res = null;
    private Integer k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res.val;
    }
    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        // 如果是第 k 个元素，记录
        if (--k == 0) {
            res = cur;
            return;
        }
        dfs(cur.right);
    }
}
