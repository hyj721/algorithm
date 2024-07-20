package com.uestc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hyj721
 * @create: 2024-07-20 07:56
 * @description: <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">...</a>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 **/
public class _0017 {
    private String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        StringBuilder curString = new StringBuilder();
        dfs(res, digits, 0, curString);
        return res;
    }

    /**
     * 递归用于获得结果
     * @param res 结果集
     * @param index 表示现在正在遍历到原字符串digits的index位
     */
    private void dfs(List<String> res, String digits, int index, StringBuilder curString) {
        if (index == digits.length()) {
            res.add(new String(curString));
            return;
        }

        int arrayPosition = digits.charAt(index) - '0';
        for (char c : map[arrayPosition].toCharArray()) {
            curString.append(c);
            dfs(res, digits, index + 1, curString);
            curString.deleteCharAt(curString.length() - 1);
        }
    }
}
