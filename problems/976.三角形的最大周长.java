import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=976 lang=java
 *
 * [976] 三角形的最大周长
 */

// @lc code=start
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length-1;
        int x=n,y=n-1,z=n-2;
        while(nums[x]>=(nums[y]+nums[z])){
            x--;
            y--;
            z--;
            if(z<0)return 0;
        }
        return nums[x]+nums[y]+nums[z];
    }
}
// @lc code=end

