/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) {
            if (len1 % i == 0 && len2 % i == 0) {
                String str = str1.substring(0, i);
                if (check(str, str1) && check(str, str2)) {
                    return str;
                }
            }
        }
        return "";
    }

    public boolean check(String str, String str1) {
        int n = str1.length() / str.length();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString().equals(str1);
    }
}
// @lc code=end
