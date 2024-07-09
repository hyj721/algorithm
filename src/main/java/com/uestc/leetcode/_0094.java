package com.uestc.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: hyj721
 * @create: 2024-07-09 10:14
 * @description: https://leetcode.cn/problems/binary-tree-inorder-traversal/
 **/
public class _0094 {
    /**
     * 这是一个递归解法的中序遍历，往往不会考察，考察的都是不用迭代的中序遍历
     */
    // class Solution {
    //     public List<Integer> inorderTraversal(TreeNode root) {
    //         List<Integer> res = new ArrayList<>();
    //         dfs(root, res);
    //         return res;
    //     }
    //     private void dfs(TreeNode root, List<Integer> res) {
    //         if (root == null) {
    //             return;
    //         }
    //         dfs(root.left, res);
    //         res.add(root.val);
    //         dfs(root.right, res);
    //     }
    // }
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Deque<TreeNode> deque = new ArrayDeque<>();
            TreeNode cur = root;
            while (cur != null || !deque.isEmpty()) {
                if (cur != null) {
                    // 第一次遇见的标记
                    deque.addLast(cur);
                    cur = cur.left;
                } else {
                    // 第二次遇见，就进入结果集
                    cur = deque.removeLast();
                    res.add(cur.val);
                    // 第二次遇见结束，往右
                    cur = cur.right;
                }
            }
            return res;
        }
    }
}
