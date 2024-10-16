/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int j = 0; j < n; j++) {
            for (int i = coins[j]; i <= amount; i++) {
                dp[i] += dp[i - coins[j]];
            }
        }

        return dp[amount];
    }
}

// @lc code=end
/**
 * 518.零钱兑换-ii
 */
class test518 {
    public static void main(String[] args) {
        teSolution solution = new teSolution();
        int amount = 5;
        int[] coins = new int[] { 1, 2, 5 };
        System.out.println(solution.change(amount, coins));
    }
}