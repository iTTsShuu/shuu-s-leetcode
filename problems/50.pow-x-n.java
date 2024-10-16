/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(n>=0){
            return powxn(x, n);
        }
        else{
            return 1.0/powxn(x, -n);
        }
    }
    public double powxn(double x, int n) {
        if(n==0){
            return 1.0;
        }
        else if(n%2==0){
            double ans=powxn(x, n/2);
            return ans*ans;
        }
        else{
            double ans=powxn(x, n/2);
            return ans*ans*x;
        }
    }
}
// @lc code=end

