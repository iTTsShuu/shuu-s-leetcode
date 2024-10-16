/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean i=true,d=true;
        for (int j = 0; j < nums.length-1; j++) {
            if(nums[j]>nums[j+1]){
                i=false;
            }
            if(nums[j]<nums[j+1]){
                d=false;
            }
        }
        return i||d;
    }
}
// @lc code=end

