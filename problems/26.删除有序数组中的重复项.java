/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除有序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int k=1; 
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                continue;
            }
            else{
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}
// @lc code=end

