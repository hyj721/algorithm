package com.uestc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyj721
 * @create: 2024-07-19 19:10
 * @description: <a href="https://leetcode.cn/problems/permutations/">...</a>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 **/
public class _0046 {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[n];
        List<Integer> cur = new ArrayList<>();
        dfs(nums, used, res, cur);
        return res;
    }
    private void dfs(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            cur.add(nums[i]);
            dfs(nums, used, res, cur);
            cur.remove(cur.size() - 1);
            used[i] = false;
        }
    }
}
