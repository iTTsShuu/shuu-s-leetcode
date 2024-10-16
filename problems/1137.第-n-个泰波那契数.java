/*
 * @lc app=leetcode.cn id=1137 lang=java
 *
 * [1137] 第 N 个泰波那契数
 */

// @lc code=start
class Solution {
    public int tribonacci(int n) {
        int x=0,y=1,z=1;
        if(n==0){
            return x;
        }else{
            int ans=1;
            for (int i = 2; i < n; i++) {
                ans=x+y+z;
                x=y;
                y=z;
                z=ans;
            }
            return ans;
        }
    }
}
// @lc code=end

