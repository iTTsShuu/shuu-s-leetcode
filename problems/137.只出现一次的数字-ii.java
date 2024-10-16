/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        // 用以记录每一位的1出现次数
        int total = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                total += ((nums[j] >> i) & 1);
            }
            if (total % 3 != 0) {
                // 当前位不为3的倍数
                // 答案的当前位也要为1
                ans |= (1 << i);
            }
            total = 0;
        }
        return ans;
    }
}
// @lc code=end

class tetete {
    public static void main(String[] args) {
        int[] nums = new int[] {
                3, 4, 4, 4, 5, 5, 5
        };
        System.out.println((nums[0] >> 1) & 1);
    }
}