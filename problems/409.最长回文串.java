/*
 * @lc app=leetcode.cn id=409 lang=java
 *
 * [409] 最长回文串
 */

// @lc code=start
class Solution {
    public int longestPalindrome(String s) {
        int[] map = new int[128];
        char[] chs = s.toCharArray();
        int ans = 0;
        // 为偶数的情况 可以直接加上
        // 个数为奇数的字符只能有一个
        for (char ch : chs) {
            map[ch]++;
            if (map[ch] == 2) {
                ans += 2;
                map[ch] = 0;
            }
        }
        // 存在个数为奇数的字符
        if (s.length() != ans)
            ans++;
        return ans;
    }
}
// @lc code=end
