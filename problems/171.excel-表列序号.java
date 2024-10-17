/*
 * @lc app=leetcode.cn id=171 lang=java
 *
 * [171] Excel 表列序号
 */

// @lc code=start
class Solution {
    public int titleToNumber1(String columnTitle) {
        char[] chs = columnTitle.toCharArray();
        int len = chs.length;
        int ans = 0;
        int time = 1;
        for (int i = len - 1; i >= 0; --i) {
            char curr = chs[i];
            ans += time * (curr - 'A' + 1);
            time *= 26;
        }
        return ans;
    }

    public int titleToNumber(String columnTitle) {
        // 不维护 time
        int n = columnTitle.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }
        return ans;
    }
}
// @lc code=end
