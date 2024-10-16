/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1){
            return 0;
        }
        int ans=0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]>prices[i-1]){
                ans+=(prices[i]-prices[i-1]);
            }
        }
        return ans;
    }
}
// @lc code=end

