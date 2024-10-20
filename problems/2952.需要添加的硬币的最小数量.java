/*
 * @lc app=leetcode.cn id=2952 lang=java
 *
 * [2952] 需要添加的硬币的最小数量
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int ans = 0, s = 1, i = 0;
        while (s <= target) {
            if (i < coins.length && coins[i] <= s) {
                s += coins[i++];
            } else {
                s *= 2; // 必须添加 s
                ans++;
            }
        }
        return ans;
    }
}

// @lc code=end
