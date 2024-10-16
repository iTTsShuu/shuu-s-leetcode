/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int x=0,y=n-1;
        while(x<=y){
            boolean flag=true;
            int mid=(x+y)>> 1;
            if(mid-1>=0){
                if(nums[mid-1]>nums[mid]) {
                    flag=false;
                    y=mid-1;
                    continue;
                }
            }
            if(mid+1<n){
                if(nums[mid+1]>nums[mid]) {
                    flag=false;
                    x=mid+1;
                    continue;
                }
                
            }
            if(flag)return mid;
        }
        return -1;
    }
}
// @lc code=end

