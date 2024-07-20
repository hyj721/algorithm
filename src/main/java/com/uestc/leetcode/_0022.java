package com.uestc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyj721
 * @create: 2024-07-20 08:22
 * @description: <a href="https://leetcode.cn/problems/generate-parentheses/">...</a>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 **/
public class _0022 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder cur = new StringBuilder();
        dfs(cur, 0, 0, n);
        return res;
    }

    private void dfs(StringBuilder cur, int leftUsed, int rightUsed, int n) {
        if (leftUsed == n && rightUsed == n) {
            res.add(new String(cur));
        }
        if (leftUsed != n) {
            cur.append("(");
            dfs(cur, leftUsed + 1, rightUsed, n);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (rightUsed != n && leftUsed > rightUsed) {
            cur.append(")");
            dfs(cur, leftUsed, rightUsed + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
