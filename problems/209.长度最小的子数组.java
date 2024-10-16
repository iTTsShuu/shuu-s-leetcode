/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //暴力解
        // int min=Integer.MAX_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        //     int sum=0;
        //     int len=0;
        //     while(sum<target&&i+len<nums.length){
        //         sum+=nums[i+len];
        //         len++;
        //     }
        //     if(sum>=target){
        //         min=Math.min(min, len);
        //     }
        // }
        // return min==Integer.MAX_VALUE? 0 : min;
        //滑动窗口
        int start=0,end=0;
        int sum=0;  //sum用来记录窗口内的数组和
        int minLen=Integer.MAX_VALUE;  //minLen用来维护最小子数组长度
        while(end<nums.length){
            sum+=nums[end];
            while(sum>=target){
                minLen=Math.min(minLen, end-start+1);
                sum-=nums[start];
                start++;
            }
            end++;
        }
        return minLen==Integer.MAX_VALUE? 0: minLen;
    }
}
// @lc code=end
class minSubArray{
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums=new int[]{1,2,3,4,5};
        int  ans=solution.minSubArrayLen(15, nums);
        System.out.println(ans);
    }
}

