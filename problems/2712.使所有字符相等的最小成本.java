/*
 * @lc app=leetcode.cn id=2712 lang=java
 *
 * [2712] 使所有字符相等的最小成本
 */

// @lc code=start
class Solution {
    public long minimumCost(String s) {
        // 还是贪心 只要不同就得反转 在反转前和后之间取更小值
        int n = s.length();
        char[] chs = s.toCharArray();
        long cnt = 0; // 注意越界
        for (int i = 1; i < n; i++) {
            if (chs[i - 1] != chs[i]) {
                cnt += Math.min(i, n - i); // 这里i是反转下标i-1及以前的花销 i-1+1
            }
        }
        return cnt;
    }
}
// @lc code=end
