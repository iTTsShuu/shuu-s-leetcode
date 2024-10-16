/*
 * @lc app=leetcode.cn id=1523 lang=java
 *
 * [1523] 在区间范围内统计奇数数目
 */

// @lc code=start
class Solution {
    public int countOdds(int low, int high) {
        return pore(high)-pore(low-1);
    }
    public int pore(int x){
        return (x+1)>>1;
    }
}
// @lc code=end

