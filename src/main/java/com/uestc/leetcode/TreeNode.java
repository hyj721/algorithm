package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-09 10:14
 * @description: 二叉树节点的定义
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
