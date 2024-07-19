package com.uestc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyj721
 * @create: 2024-07-19 19:11
 * @description: <a href="https://leetcode.cn/problems/subsets/">...</a>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的
 * 子集
 * （幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 **/
public class _0078 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, cur, used, 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> cur, boolean[] used, int startIndex) {
        res.add(new ArrayList<>(cur));
        if (cur.size() == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            cur.add(nums[i]);
            used[i] = true;
            dfs(nums, cur, used, i + 1);
            used[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
