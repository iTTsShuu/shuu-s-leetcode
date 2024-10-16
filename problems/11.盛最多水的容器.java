/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容�?
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0;
        while(left<right){
            max=Math.max(max, Math.min(height[left], height[right])*(right-left));
            //�ж��ƶ�
            if(height[left]<=height[right]){
                left+=1;
            }
            else{
                right-=1;
            }
        }
        return max;
    }
}
// @lc code=end

