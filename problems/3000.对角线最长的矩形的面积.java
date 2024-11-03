/*
 * @lc app=leetcode.cn id=3000 lang=java
 *
 * [3000] 对角线最长的矩形的面积
 */

// @lc code=start
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        int maxDig2 = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int curL = dimensions[i][0];
            int curW = dimensions[i][1];
            int curDig2 = curL * curL + curW * curW;
            if (curDig2 > maxDig2 || (curDig2 == maxDig2 && curL * curW > ans)) {
                maxDig2 = curL * curL + curW * curW;
                ans = curL * curW;
            }
        }
        return ans;
    }
}
// @lc code=end
