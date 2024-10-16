/*
 * @lc app=leetcode.cn id=509 lang=java
 *
 * [509] 斐波那契数
 */

// @lc code=start
class Solution {
    public int fib(int n) {
        int x=0,y=1,ans=0 ;
        for (int i = 0; i < n; i++) {
            x=y;
            y=ans;
            ans=x+y;
        }
        return ans;
    }
}
// @lc code=end

