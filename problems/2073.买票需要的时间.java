/*
 * @lc app=leetcode.cn id=2073 lang=java
 *
 * [2073] 买票需要的时间
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        // 队列
        // int n = tickets.length;
        // int ans = 0;
        // int pos = 0;
        // while (tickets[k] != 0) {
        // if (tickets[pos]-- > 0) {
        // ans++;
        // }
        // pos = (pos + 1) % n;
        // }
        // return ans;

        // 取最小值
        int n = tickets.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i <= k) {
                ans += Math.min(tickets[i], tickets[k]);
            } else {
                ans += Math.min(tickets[i], tickets[k] - 1);
            }
        }
        return ans;
    }
}
// @lc code=end
