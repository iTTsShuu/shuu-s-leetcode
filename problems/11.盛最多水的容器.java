/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] ç››æœ€å¤šæ°´çš„å®¹å™?
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0;
        while(left<right){
            max=Math.max(max, Math.min(height[left], height[right])*(right-left));
            //ÅÐ¶ÏÒÆ¶¯
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

