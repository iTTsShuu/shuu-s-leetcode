/*
 * @lc app=leetcode.cn id=1438 lang=java
 *
 * [1438] 绝对差不超过限制的最长连续子数组
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int maxL = -1;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                if (max - min > limit) {
                    maxL = Math.max(j - i, maxL);
                    break;
                }
            }
        }
        return maxL;
    }
}

// @lc code=end
class sdsad {
    public static void main(String[] args) {
        mySolution solution = new mySolution();
        int[] nums = new int[] { 8, 2, 4, 7 };
        System.out.println(solution.longestSubarray(nums, 4));
    }
}