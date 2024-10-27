/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        boolean isMinus = s.charAt(0) == '-';
        boolean isPlus = s.charAt(0) == '+';
        int start = 0;
        if (isMinus || isPlus) {
            start++;
        }
        long ans = 0;
        while (start < s.length() && Character.isDigit(s.charAt(start))) {
            if (ans > Integer.MAX_VALUE / 10) {
                ans = Integer.MAX_VALUE;
                break;
            }
            ans = ans * 10 + Integer.parseInt(s.substring(start, start + 1));
            start++;
        }
        if (isMinus) {
            ans = -ans;
            ans = ans < Integer.MIN_VALUE ? Integer.MIN_VALUE : ans;
        } else {
            ans = ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : ans;
        }

        return (int) ans;
    }

}

// @lc code=end
class test8 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}