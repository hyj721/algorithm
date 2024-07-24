package com.uestc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: hyj721
 * @create: 2024-07-23 21:23
 * @description: <a href="https://leetcode.cn/problems/valid-parentheses/">...</a>
 **/
public class _0020 {
    Map<Character, Character> map = new HashMap<>();
    public boolean isValid(String s) {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (deque.isEmpty()) {
                // 栈为空
                if (!map.containsKey(cur)) {
                    // 左括号
                    deque.addLast(cur);
                } else {
                    // 右括号
                    return false;
                }
            } else {
                // 栈非空
                if (!map.containsKey(cur)) {
                    // 左括号
                    deque.addLast(cur);
                } else {
                    // 右括号
                    if (map.get(cur).equals(deque.getLast())) {
                        deque.removeLast();
                    } else {
                        return false;
                    }
                }
            }
        }
        return deque.isEmpty();
    }
}
