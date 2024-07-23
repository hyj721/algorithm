package com.uestc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyj721
 * @create: 2024-07-21 08:28
 * @description: <a href="https://leetcode.cn/problems/palindrome-partitioning/">...</a>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串。返回 s 所有可能的分割方案。
 **/
public class _0131 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return res;
    }

    private void dfs(String s, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (huiwen(s, startIndex, i)) {
                path.add(s.substring(startIndex, i + 1));
                dfs(s, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean huiwen(String s, int beginIndex, int endIndex) {
        if (endIndex < beginIndex) {
            return false;
        }
        while (beginIndex < endIndex) {
            if (s.charAt(beginIndex) == s.charAt(endIndex)) {
                beginIndex++;
                endIndex--;
            } else {
                return false;
            }
        }
        return true;
    }
}
