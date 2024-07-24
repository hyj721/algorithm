package com.uestc.leetcode;

/**
 * @author: hyj721
 * @create: 2024-07-23 21:33
 * @description: <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">...</a>
 **/
public class _0121 {
    public int maxProfit(int[] prices) {
        // dp[i][0]表示第i天没有持有的最大收益，dp[i][1]表示第i天已经持有的最大收益，dp[i][2]表示第i天已经卖出的最大收益
        int n = prices.length;
        int[][] dp = new int[n][3];
        dp[0][1] = -prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
        }
        return dp[n - 1][2];
    }
}
