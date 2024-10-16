/*
 * @lc app=leetcode.cn id=1103 lang=java
 *
 * [1103] 分糖果 II
 */

// @lc code=start
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int curC = 1;
        int curI = 0;
        while (candies != 0) {
            if (candies >= curC) {
                ans[curI] += curC;
                candies -= curC;
            } else {
                ans[curI] += candies;
                candies -= candies;
            }
            curC++;
            curI = (curI + 1) % num_people;
        }
        return ans;
    }
}
// @lc code=end
