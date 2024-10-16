/*
 * @lc app=leetcode.cn id=2535 lang=java
 *
 * [2535] 数组元素和与数字和的绝对差
 */

// @lc code=start
class Solution {
    public int differenceOfSum(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            /*
             * if (num >= 10) {
             * int sum = 0;
             * int tmp = num;
             * while (tmp != 0) {
             * sum += tmp % 10;
             * tmp = tmp / 10;
             * }
             * ans += (num - sum);
             * }
             */
            ans += nums[i];
            while (nums[i] != 0) {
                ans -= nums[i] % 10;
                nums[i] /= 10;
            }
        }
        return ans;
    }
}
// @lc code=end
