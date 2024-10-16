/*
 * @lc app=leetcode.cn id=1431 lang=java
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ansList = new ArrayList<>();
        int maxC = 0;
        for (int i = 0; i < candies.length; i++) {
            maxC = Math.max(maxC, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxC) {
                ansList.add(true);
            } else {
                ansList.add(false);
            }
        }
        return ansList;
    }
}
// @lc code=end
