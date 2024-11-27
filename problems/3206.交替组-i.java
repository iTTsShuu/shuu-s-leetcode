/*
 * @lc app=leetcode.cn id=3206 lang=java
 *
 * [3206] 交替组 I
 */

// @lc code=start
class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int l = (i - 1 + n) % n;
            int r = (i + 1 + n) % n;
            if (colors[l] != colors[i] && colors[i] != colors[r]) {
                cnt++;
            }
        }
        return cnt;
    }
}
// @lc code=end
