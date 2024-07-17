package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-17 15:16
 * @description: <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/">...</a>
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * 解法：其实就是遍历树的每一个节点，对其求左边的最大路径、右边的最大路径，再更新 res
 **/
public class _0124 {
    private Integer res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return res;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);
        int curSum = left + root.val + right;
        res = Math.max(res, curSum);
        return Math.max(left, right) + root.val;
    }
}
