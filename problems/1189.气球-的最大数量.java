/*
 * @lc app=leetcode.cn id=1189 lang=java
 *
 * [1189] “气球” 的最大数量
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    // 直接统计 本来想用 Map的 一看解题 解决
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[5];
        for (int i = 0; i < text.length(); ++i) {
            char ch = text.charAt(i);
            if (ch == 'b') {
                cnt[0]++;
            } else if (ch == 'a') {
                cnt[1]++;
            } else if (ch == 'l') {
                cnt[2]++;
            } else if (ch == 'o') {
                cnt[3]++;
            } else if (ch == 'n') {
                cnt[4]++;
            }
        }
        cnt[2] /= 2;
        cnt[3] /= 2;
        return Arrays.stream(cnt).min().getAsInt();
    }
}
// @lc code=end
