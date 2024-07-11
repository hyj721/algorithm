package com.uestc.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: hyj721
 * @create: 2024-07-11 09:17
 * @description: <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/">...</a>
 **/
public class _0102 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.addLast(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> row = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.removeFirst();
                    row.add(cur.val);
                    if (cur.left != null) {
                        queue.addLast(cur.left);
                    }
                    if (cur.right != null) {
                        queue.addLast(cur.right);
                    }
                }
                res.add(row);
            }
            return res;
        }
    }
}
