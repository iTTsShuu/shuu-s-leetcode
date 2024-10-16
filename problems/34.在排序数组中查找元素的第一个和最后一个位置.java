/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=BinarySearch(nums, target, true);
        int right=BinarySearch(nums, target, false)-1;
        if( right<nums.length && left<=right && nums[left]==target && nums[right]==target){
            return new int[]{left,right};
        }
        return new int[]{-1,-1};
        
    }
    public int BinarySearch(int[] nums, int target,boolean low){
        int left=0, right=nums.length-1;
        int ans=nums.length;
        while(left<=right){
            int mid = (left+right)>>1;
            if(nums[mid]>target || (low && nums[mid]>=target )){
                right=mid-1;
                ans=mid;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
}
// @lc code=end

