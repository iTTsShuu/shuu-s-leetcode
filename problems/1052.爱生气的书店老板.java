/*
 * @lc app=leetcode.cn id=1052 lang=java
 *
 * [1052] 爱生气的书店老板
 */

// @lc code=start

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        // 完全不带忍的情况下
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }

        // 问题转化为求长度minutes的滑动窗口 grumpy为1的customers和值最大
        int cnt = 0;
        int maxC = 0;
        int l = 0, r = 0;
        while (r < n) {
            if (grumpy[r] == 1) { // 右进
                cnt += customers[r];
            }
            if (r - l + 1 == minutes) {// 窗口长度满足
                maxC = Math.max(maxC, cnt);
                // 左出窗口
                if (grumpy[l] == 1) {
                    cnt -= customers[l];
                }
                l++;
            }
            r++;
        }
        // 加上最长忍耐
        return total + maxC;
    }
}
// @lc code=end
