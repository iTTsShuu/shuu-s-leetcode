/*
 * @lc app=leetcode.cn id=2516 lang=java
 *
 * [2516] 每种字符至少取 K 个
 */

// @lc code=start
class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();
        int l = 0, r = n - 1;
        int ans = 0;
        int[] cnt = new int[3];
        char[] chs = s.toCharArray();
        for (char c : chs) {
            cnt[c - 'a']++;
        }
        // 问题转换为求中间最长子串满足字串子中每个字符数量小于cnt[ch]-k
        // 使用前缀和方式求解

    }
}
// @lc code=end
