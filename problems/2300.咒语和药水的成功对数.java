/*
 * @lc app=leetcode.cn id=2300 lang=java
 *
 * [2300] 咒语和药水的成功对数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        int[] anss = new int[n];
        for (int i = 0; i < n; i++) {
            int l = binarySearchPotions(potions, spells[i], success);
            anss[i] = m - l;
        }
        return anss;
    }

    public int binarySearchPotions(int[] potions, int spell, long success) {
        int l = 0, r = potions.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if ((long) potions[m] * (long) spell >= success) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (l == potions.length - 1) {
            return (long) potions[l] * (long) spell >= success ? l : l + 1;
        }
        return l;
    }
}
// @lc code=end
