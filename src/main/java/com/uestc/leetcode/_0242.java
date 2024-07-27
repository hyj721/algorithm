package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-27 19:15
 * @description: https://leetcode.cn/problems/valid-anagram/description/
 **/
public class _0242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--hash[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        _0242 _242 = new _0242();
        _242.isAnagram(s, t);

    }
}
