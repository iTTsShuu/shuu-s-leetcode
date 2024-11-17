/*
 * @lc app=leetcode.cn id=2379 lang=java
 *
 * [2379] 得到 K 个黑块的最少涂色次数
 */

// @lc code=start
class Solution {
    public int minimumRecolors(String blocks, int k) {
        // 固定窗口内的最少W
        int n = blocks.length();
        char[] blocksCh = blocks.toCharArray();
        int l = 0, r = 0;
        int cntW = 0;
        // if (n == k) { // 特殊处理k=n
        // for (char c : blocksCh) {
        // if (c == 'W') {
        // cntW++;
        // }
        // }
        // return cntW;
        // }
        int ans = n;
        while (r < n) {
            if (blocksCh[r] == 'W') {// 右端点入窗口
                cntW++;
            }
            if (r - l + 1 == k) { // 窗口长度到k
                // 窗口长度到k开始 维护答案最小值
                ans = Math.min(ans, cntW);
                if (blocksCh[l] == 'W') {// 左端点出窗口
                    cntW--;
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}
// @lc code=end
