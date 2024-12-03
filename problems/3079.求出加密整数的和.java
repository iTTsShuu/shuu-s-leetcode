/*
 * @lc app=leetcode.cn id=3079 lang=java
 *
 * [3079] 求出加密整数的和
 */

// @lc code=start
class Solution {
    // 无非就是模拟嘛 随便模模拟拟
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum += encrypt(x);
        }
        return sum;
    }

    int encrypt(int num) {
        int maxL = 0;
        int cnt = 0;
        while (num > 0) {
            maxL = Math.max(maxL, num % 10);
            num /= 10;
            cnt++;
        }
        int ans = 0;
        while (cnt != 0) {
            ans *= 10;
            ans += maxL;
            cnt--;
        }
        return ans;
    }
}
// @lc code=end
