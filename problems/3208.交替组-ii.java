/*
 * @lc app=leetcode.cn id=3208 lang=java
 *
 * [3208] 交替组 II
 */

// @lc code=start
class Solution {

    // 哈哈 滑动窗口吗 那无敌了
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int cnt = 0;
        int len = 0; // 当前的交替组长度
        for (int i = 0; i < n * 2; i++) {
            if (i > 0 && colors[i % n] != colors[(i - 1) % n]) {
                len++;
            } else {
                len = 1;
            }
            if (i >= n && len >= k) { // i>=n来避免重复统计
                cnt++;
            }
        }
        return cnt;
    }

}
// @lc code=end
