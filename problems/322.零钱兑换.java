/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] anss = new int[amount + 1];
        Arrays.fill(anss, amount + 1);
        anss[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    anss[i] = Math.min(anss[i - coins[j]] + 1, anss[i]);
                }
            }
        }
        return anss[amount] > amount ? -1 : anss[amount];
    }
}
// @lc code=end
