import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/*
 * @lc app=leetcode.cn id=213 lang=java
 *
 * [213] 打家劫舍 II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int ans=Integer.MIN_VALUE;
        //n<=3只能去一家，取最大值
        if(n<=3){
            for (int i : nums) {
                ans=Math.max(ans, i);
            }
            return ans;
        }
        //范围[0，n-2]
        int x=nums[0],y=Math.max(nums[0], nums[1]),ans1=Math.max(x, y);
        for(int i=2;i<n-1;i++){
            ans1=Math.max(x+nums[i], y);
            x=y;
            y=ans1;
        }
        //范围[1,n-1]
        x=nums[1];y=Math.max(nums[1], nums[2]);
        int ans2=Math.max(x, y);
        for(int i=3;i<n;i++){
            ans2=Math.max(x+nums[i], y);
            x=y;
            y=ans2;
        }
        return Math.max(ans1, ans2);    
    }
}
// @lc code=end

