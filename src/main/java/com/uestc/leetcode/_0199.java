package com.uestc.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: hyj721
 * @create: 2024-07-15 17:30
 * @description: <a href="https://leetcode.cn/problems/binary-tree-right-side-view/">...</a>
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 **/
public class _0199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode removed = deque.removeFirst();
                if (i == size - 1) {
                    res.add(removed.val);
                }
                if (removed.left != null) {
                    deque.addLast(removed.left);
                }
                if (removed.right != null) {
                    deque.addLast(removed.right);
                }
            }
        }
        return res;
    }
}
