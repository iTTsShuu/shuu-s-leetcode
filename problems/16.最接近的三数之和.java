import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.text.html.HTML.Tag;
import javax.swing.text.html.parser.TagElement;

/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之�?
 *
 * https://leetcode.cn/problems/3sum-closest/description/
 *
 * algorithms
 * Medium (44.96%)
 * Likes:    1387
 * Dislikes: 0
 * Total Accepted:    465.1K
 * Total Submissions: 1M
 * Testcase Example:  '[-1,2,1,-4]\n1'
 *
 * 给你一个长度为 n 的整数数组 nums �? 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近�?
 * 
 * 返回这三个数的和�?
 * 
 * 假定每组输入只存在恰好一个解�?
 * 
 * 
 * 
 * 示例 1�?
 * 
 * 
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出�?2
 * 解释：与 target 最接近的和�? 2 (-1 + 2 + 1 = 2) �?
 * 
 * 
 * 示例 2�?
 * 
 * 
 * 输入：nums = [0,0,0], target = 1
 * 输出�?0
 * 
 * 
 * 
 * 
 * 提示�?
 * 
 * 
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=-99999;
        Arrays.sort(nums);
        int n=nums.length;
        int i,j,k;
        for(i=0;i<n;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            j=i+1;
            for(k=n-1;k>j;k--){
                if(nums[i]+nums[j]+nums[k]==target){
                    return nums[i]+nums[j]+nums[k];
                }
                if(Math.abs(target-(nums[i]+nums[j]+nums[k]))<Math.abs(target-ans)){
                    ans=nums[i]+nums[j]+nums[k];
                }
                if(nums[i]+nums[j]+nums[k]<target){
                    j++;
                    k++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

