/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        // int l = 1, r = num;
        // while (l <= r) {
        // int m = l + (r - l) / 2;
        // long tmp = (long) m * m;
        // if (tmp > num) {
        // r = m + 1;
        // } else if (tmp < num) {
        // l = m - 1;
        // } else {
        // return true;
        // }
        // }
        // return false;
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}
// @lc code=end

class isPerfectSquareTest {
    public static void main(String[] args) {
        mySolution solution = new mySolution();
        System.out.println(solution.isPerfectSquare(16));
    }
}