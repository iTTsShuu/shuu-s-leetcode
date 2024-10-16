/*
 * @lc app=leetcode.cn id=3234 lang=java
 *
 * [3234] 统计 1 显著的字符串的数量
 */

// @lc code=start
class Solution {
    public int numberOfSubstrings1(String s) {
        int n = s.length();
        int totalOne = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                totalOne++;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int zero = 0, one = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '0') {
                    zero++;
                } else {
                    one++;
                }
                if (zero * zero > totalOne) {
                    break;
                }
                if (one >= zero * zero) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int numberOfSubstrings(String S) {
        char[] s = S.toCharArray();
        int ans = 0;
        int tot1 = 0;
        int[] a = new int[s.length + 1];
        a[0] = -1; // 哨兵
        int m = 1;
        for (int right = 0; right < s.length; right++) {
            if (s[right] == '0') {
                a[m++] = right;
            } else {
                ans += right - a[m - 1];
                tot1++;
            }
            for (int k = m - 1; k > 0 && (m - k) * (m - k) <= tot1; k--) {
                int cnt0 = m - k;
                int cnt1 = right - a[k] + 1 - cnt0;
                ans += Math.max(a[k] - a[k - 1] - Math.max(cnt0 * cnt0 - cnt1, 0), 0);
            }
        }
        return ans;
    }
}
// @lc code=end
