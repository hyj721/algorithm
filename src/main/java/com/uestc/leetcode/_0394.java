package com.uestc.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: hyj721
 * @create: 2024-07-24 09:06
 * @description: <a href="https://leetcode.cn/problems/decode-string/">...</a>
 **/
public class _0394 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            stack.addLast(cur);
            if (cur == ']') {
                // 把右括号移除
                stack.removeLast();
                // 得到中间的单词
                StringBuilder word = new StringBuilder();
                while (!stack.isEmpty() && Character.isLowerCase(stack.getLast())) {
                    word.append(stack.removeLast());
                }
                // 把左括号移除
                stack.removeLast();
                // 得到数量
                StringBuilder number = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.getLast())) {
                    number.append(stack.removeLast());
                }
                int loop = Integer.parseInt(number.reverse().toString());
                for (int j = 0; j < loop; j++) {
                    for (int k = word.length() - 1; k >= 0; k--) {
                        stack.addLast(word.charAt(k));
                    }
                }
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.removeFirst());
        }
        return res.toString();
    }
}
