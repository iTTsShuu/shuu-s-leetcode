/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<min){
                min=prices[i];
            }
            else if((prices[i]-min)>max){
                max=prices[i]-min;
            }
        }
        if(max<0){
            return 0;
        }
        return max;
    }
}
// @lc code=end

