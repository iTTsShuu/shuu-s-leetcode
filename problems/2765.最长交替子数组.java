/*
 * @lc app=leetcode.cn id=2765 lang=java
 *
 * [2765] 最长交替子数组
 */

// @lc code=start
class Solution {
    public int alternatingSubarray(int[] nums) {
        int maxcnt=Integer.MIN_VALUE;
        int cnt=-1;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]+1==nums[i+1]){
                cnt=2;
                int si=i;
                if(i+2<nums.length){
                    while(si+2<nums.length && nums[si]==nums[si+2] ){
                        cnt++;
                        si++;
                    }
                    i=si;
                }
            }
            maxcnt=Math.max(maxcnt, cnt);
        }
        return maxcnt;
    }
}
// @lc code=end
class test{
    public static void main(String[] args) {
        mySolution solution=new mySolution();
        int[] nums=new int[]{21,22};
        int ans= solution.alternatingSubarray(nums);
        System.out.println(ans);
    }
     
}
