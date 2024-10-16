import java.io.FileFilter;
import java.lang.annotation.Retention;
import java.util.PrimitiveIterator.OfDouble;

/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int fast=2,slow=2;
        if(nums.length<=2){
            return nums.length;
        }
        while(fast<nums.length){
            if(nums[slow-2]!=nums[fast]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
// @lc code=end

