/*
 * @lc app=leetcode.cn id=537 lang=java
 *
 * [537] 复数乘法
 */

// @lc code=start
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        String[] complex1 = num1.split("\\+|i");
        String[] complex2 = num2.split("\\+|i");
        Integer real1 = Integer.parseInt(complex1[0]);
        Integer vur1 = Integer.parseInt(complex1[1]);
        Integer real2 = Integer.parseInt(complex2[0]);
        Integer vur2 = Integer.parseInt(complex2[1]);
        return String.format("%d+%di", real1 * real2 - vur1 * vur2, real1 * vur2 + vur1 * real2);
    }
}
// @lc code=end
