/*
 * @lc app=leetcode.cn id=2207 lang=java
 *
 * [2207] 字符串中最多数目的子序列
 */

// @lc code=start
class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int ans = 0, countA = 0, countB = 0;
        char[] chs = text.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == pattern.charAt(0)) {
                countA++;
                for (int j = i + 1; j < chs.length; j++) {
                    if (chs[j] == pattern.charAt(1)) {
                        ans++;
                    }
                }
            }
            if (chs[i] == pattern.charAt(1)) {
                countB++;
            }
        }
        ans += Math.max(countA, countB);
        return ans;
    }
}

// @lc code=end
/**
 * 2207.字符串中最多数目的子序列
 */
class test2207 {
    public static void main(String[] args) {
        Solution2207 solution = new Solution2207();
        String text = "abdcdbc";
        String pattern = "ac";
        System.out.println(solution.maximumSubsequenceCount(text, pattern));
    }
}