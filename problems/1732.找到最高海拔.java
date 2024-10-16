/*
 * @lc app=leetcode.cn id=1732 lang=java
 *
 * [1732] 找到最高海拔
 */

// @lc code=start
class Solution {
    public int largestAltitude(int[] gain) {
        int curAl = 0;
        int maxH = 0;
        for (int i : gain) {
            curAl += i;
            maxH = Math.max(curAl, maxH);
        }
        return maxH;
    }
}
// @lc code=end
