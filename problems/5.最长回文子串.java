/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int sLength = s.length();
        if (sLength == 1) {
            return s;
        }
        boolean[][] isPalin = new boolean[sLength][sLength];
        for (int i = 0; i < sLength; i++) {
            isPalin[i][i] = true;
        }
        int maxL = 1;
        int begin = 0;
        for (int L = 2; L <= sLength; L++) {
            for (int i = 0; i < sLength; i++) {
                int j = i + L - 1;
                if (j > sLength - 1) {
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (L > 2) {
                        isPalin[i][j] = isPalin[i + 1][j - 1];
                    } else {
                        isPalin[i][j] = true;
                    }
                } else {
                    isPalin[i][j] = false;
                }
                if (isPalin[i][j] && L > maxL) {
                    maxL = L;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxL);
    }
}
// @lc code=end
