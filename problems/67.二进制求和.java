/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
class Solution {
    public String addBinary(String a, String b) {
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
}
// @lc code=end
