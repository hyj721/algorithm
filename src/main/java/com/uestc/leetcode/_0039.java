package com.uestc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyj721
 * @create: 2024-07-20 08:09
 * @description: <a href="https://leetcode.cn/problems/combination-sum/">...</a>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 **/
public class _0039 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] candidates, int target, int index, int curSum, List<Integer> cur) {
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            cur.add(candidates[i]);
            curSum += candidates[i];
            // 因为每个数字可以使用多次，因此下一次的index仍然为i
            dfs(candidates, target, i, curSum, cur);
            curSum -= candidates[i];
            cur.remove(cur.size() - 1);
        }
    }
}
