/*
 * @lc app=leetcode.cn id=1276 lang=java
 *
 * [1276] 不浪费原料的汉堡制作方案
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new ArrayList<>();
        int tmp = tomatoSlices - cheeseSlices * 2;
        if (tmp < 0 || tmp / 2 > cheeseSlices || tmp % 2 != 0) {
            return ans;
        }
        ans.add(tmp / 2);
        ans.add(cheeseSlices - tmp / 2);
        return ans;
    }
}
// @lc code=end
