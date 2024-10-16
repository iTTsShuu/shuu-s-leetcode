import java.security.Principal;

/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int k=0;
        int i=0,maxindex=nums.length-1;
        int mCur=nums[0];
        if(maxindex==0){
            return 0;
        }
        if(mCur>=maxindex){
            return 1;
        }
        while(i<maxindex){
            int dis=i+nums[i];
            for (int j = i; j <= dis&&j<=maxindex; j++) {
                if(j+nums[j]>mCur){
                    mCur=j+nums[j];
                    i=j;
                }
            }
            k++;
            if(i<maxindex&&mCur>=maxindex){
                return k+1;
            }
        }
        return k;
    }
}
// @lc code=end
class test{
    public static void main(String[] args) {
        mySolution solution=new mySolution();
        int[] nums=new int[]{
            2,1
        };
        int s=solution.jump(nums);
        System.out.println(s);
    }
}

