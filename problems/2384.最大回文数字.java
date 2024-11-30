/*
 * @lc app=leetcode.cn id=2384 lang=java
 *
 * [2384] 最大回文数字
 */

// @lc code=start
class Solution {
    public String largestPalindromic(String num) {
        // 统计各个数出现次数
        int[] cnt = new int[10];
        for (char ch : num.toCharArray()) {
            cnt[ch - '0']++;
        }
        // 组成答案
        StringBuffer sb = new StringBuffer();
        // 贪心从大开始
        // 记录最大单个数字
        int maxSingel = -1;
        for (int i = 9; i >= 0; i--) {
            if (sb.length() == 0 && i == 0) {// 处理前置零
                cnt[0] = 1;
            }
            while (cnt[i] > 1) {
                sb.append(i);
                cnt[i] -= 2;
            }
            // 维护最大单个数
            if (cnt[i] == 1) {
                maxSingel = Math.max(maxSingel, i);
            }
        }
        String orign = sb.toString();
        String reversed = sb.reverse().toString();
        return maxSingel == -1 ? orign + reversed : orign + String.valueOf(maxSingel) + reversed;
    }
}
// @lc code=end
