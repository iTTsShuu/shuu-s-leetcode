
/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        // if (nums.length == 1) {
        // return nums[0];
        // }
        // int x = nums[0], y = Math.max(nums[0], nums[1]), ans = Math.max(x, y);
        // for (int i = 2; i < nums.length; i++) {
        // ans = Math.max(x + nums[i], y);
        // x = y;
        // y = ans;
        // }
        // return ans;

        // if (nums.length==1){
        // return nums[0];
        // }
        // int x=nums[0],y=Math.max(nums[0], nums[1]),ans=Math.max(x, y);
        // for (int i = 1; i < nums.length-1; i++) {
        // ans=Math.max(x+nums[i+1], y);
        // x=y;
        // y=ans;
        // }
        // return ans;
        if (nums.length < 2) {
            return nums[0];
        }
        int pre = nums[0], cur = Math.max(nums[0], nums[1]), next = Math.max(pre, cur);
        for (int i = 2; i < nums.length; i++) {
            next = Math.max(cur, pre + nums[i]);
            pre = cur;
            cur = next;
        }
        return next;
    }
}
// @lc code=end
