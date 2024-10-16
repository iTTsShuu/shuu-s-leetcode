/*
 * @lc app=leetcode.cn id=2269 lang=java
 *
 * [2269] 找到一个数字的 K 美丽值
 */

// @lc code=start
class Solution {
    public int divisorSubstrings(int num, int k) {
        String value = String.valueOf(num);
        int l = 0, r = k - 1;
        int ans = 0;
        // 被整除的数
        int cur = 0;
        while (r < value.length()) {
            // 构造被除数
            for (int i = l; i < r + 1; i++) {
                int a = value.charAt(i) - '0';// 转int
                cur += a * Math.pow(10, r - i);
            }
            // 进行判断
            if (cur != 0 && num % cur == 0) {
                ans++;
            }
            // 重置进行下一步
            cur = 0;
            l++;
            r++;
        }
        return ans;
    }
}
// @lc code=end
