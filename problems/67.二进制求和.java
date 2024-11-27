/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary1(String a, String b) {
        // int inta = Integer.parseInt(a, 2);
        // int intb = Integer.parseInt(b, 2);
        // int ans = 0;
        // int carry = 0;
        // while (intb != 0) {
        // ans = inta ^ intb;
        // carry = (inta & intb) << 1;
        // inta = ans;
        // intb = carry;
        // }
        // String ansS = Integer.toBinaryString(inta);
        // return ansS;
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public String addBinary(String a, String b) {

        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();

    }
}
// @lc code=end
