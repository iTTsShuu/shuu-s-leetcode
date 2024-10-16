/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public int SquareSum(int n){
       int num=n;
       int sum=0;
        while(num!=0){
            sum+=(num%10)*(num%10);
            num=num/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        int slow=n,fast=SquareSum(n);
        while(slow!=fast){
            slow=SquareSum(slow);
            fast=SquareSum(fast);
            fast=SquareSum(fast);
        }
        return slow==1;
    }
}
// @lc code=end
class testSquareSum{
    public static void main(String[] args) {
        Solution solution=new Solution();
        int num=2;
        System.out.println(solution.SquareSum(num));
        System.out.println(solution.isHappy(num));
    }
}
