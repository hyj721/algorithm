package com.uestc.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: hyj721
 * @create: 2024-07-27 19:47
 * @description: <a href="https://leetcode.cn/problems/happy-number/description/">...</a>
 **/
public class _0202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            int digitSquareSum = getDigitSquareSum(n);
            if (!set.add(digitSquareSum)) {
                return false;
            }
            if (digitSquareSum == 1) {
                return true;
            }
            n = digitSquareSum;
        }
    }

    private int getDigitSquareSum(int n) {
        int res = 0;
        while (n != 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }
        return res;
    }
}
