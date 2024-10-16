/*
 * @lc app=leetcode.cn id=1456 lang=java
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        char[] chs = s.toCharArray();
        int l = 0, r = 0;
        int ans = 0;
        int count = 0;
        while (r < chs.length) {
            if (isYuany(chs[r])) {
                count++;
            }
            if (r - l > k - 1) {
                // 移除左节点
                if (isYuany(chs[l])) {
                    count--;
                }
                l++;
            }
            ans = Math.max(count, ans);
            r++;
        }
        return ans;
    }

    boolean isYuany(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
// @lc code=end
