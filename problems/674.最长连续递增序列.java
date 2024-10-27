/*
 * @lc app=leetcode.cn id=674 lang=java
 *
 * [674] 最长连续递增序列
 */

// @lc code=start
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int index = 1;
        int ans = 0, len = 1;
        while (index < n) {
            if (nums[index] > nums[index - 1]) {
                len++;
            } else {
                len = 1; // 重新计算
            }
            // 维护最大值
            ans = Math.max(ans, len);
            index++;
        }
        return ans;
    }
}

// @lc code=end
class test674 {
    public static void main(String[] args) {
        Solution674 solution674 = new Solution674();
        System.out.println(solution674.findLengthOfLCIS(new int[] { 1, 3, 5, 7 }));
    }
}