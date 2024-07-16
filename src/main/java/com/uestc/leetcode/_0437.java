package com.uestc.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hyj721
 * @create: 2024-07-16 21:55
 * @description: <a href="https://leetcode.cn/problems/path-sum-iii/">...</a>
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 **/
public class _0437 {
    Map<Long, Integer> map = new HashMap<>();
    Long preSum = 0L;
    Integer res = 0;
    Integer target = 0;
    public int pathSum(TreeNode root, int targetSum) {
        // map表示以 key 的值为前缀和，有 value 种
        map.put(0L, 1);
        target = targetSum;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        preSum += cur.val;
        // preSum - x = target ==> x = preSum - target
        res += map.getOrDefault(preSum - target, 0);
        // 更新前缀和 map
        map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        dfs(cur.left);
        dfs(cur.right);
        map.put(preSum, map.get(preSum) - 1);
        preSum -= cur.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        int target = 0;
        _0437 solution = new _0437();
        System.out.println(solution.pathSum(root, target));
    }
}
