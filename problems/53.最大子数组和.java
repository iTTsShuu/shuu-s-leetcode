/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int maxS=nums[0],preX=0;
        for (int i=0;i<nums.length;i++) {
                preX=Math.max(preX+nums[i], nums[i]);
                maxS=Math.max(preX, maxS);
        }
        return maxS;
    }
}
// @lc code=end

