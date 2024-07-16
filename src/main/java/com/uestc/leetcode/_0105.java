package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-16 21:48
 * @description: <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">...</a>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 **/
public class _0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        if (l1 == r1) {
            return new TreeNode(preorder[l1]);
        }
        int rootVal = preorder[l1];
        int midIndex = l2;
        while (inorder[midIndex] != rootVal) {
            midIndex++;
        }
        // [l2, midIndex - 1], midIndex, [midIndex + 1, r2]
        int leftLength = midIndex - l2;
        int rightLength = r2 - midIndex;
        TreeNode leftRoot = buildTree(preorder, l1 + 1, l1 + 1 + leftLength - 1, inorder, l2, midIndex - 1);
        TreeNode rightRoot = buildTree(preorder, l1 + 1 + leftLength, r1, inorder, midIndex + 1, r2);
        return new TreeNode(rootVal, leftRoot, rightRoot);
    }
}
