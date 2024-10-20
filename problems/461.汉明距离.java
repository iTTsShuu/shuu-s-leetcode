/*
 * @lc app=leetcode.cn id=461 lang=java
 *
 * [461] 汉明距离
 */

// @lc code=start
class Solution {
    public int hammingDistance(int x, int y) {
        // 先想到异或 将所有不同位置 置为1 再做统计1的数量
        x ^= y;
        // 统计1的数量用到 n&(n-1) 将原数的最后一个1置为0 移除最低位 1
        // 统计将a全部置为0的次数
        int ans = 0;
        while (x > 0) {
            x &= x - 1;
            ans++;
        }
        return ans;
    }
}
// @lc code=end
