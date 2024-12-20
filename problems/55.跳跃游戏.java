import java.math.MathContext;

/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int max =0;
        for (int i = 0; i < nums.length; i++) {
            if(max>=i){
                max=Math.max(max, i+nums[i]);
            }
        }
        if(max>=nums.length-1){
            return true;
        }
        else{
            return false;
        }
    }
}
// @lc code=end

