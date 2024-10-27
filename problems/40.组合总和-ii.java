/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> curCombination = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return ans;
    }

    void dfs(int[] candidates, int target, int curSum, int last) {
        if (curSum == target) {
            ans.add(new ArrayList<>(curCombination));
            return;
        }
        if (curSum > target) {
            return;
        }
        for (int i = last; i < candidates.length; i++) {
            curCombination.add(candidates[i]);
            dfs(candidates, target, curSum + candidates[i], i + 1);
            curCombination.remove(last + 1);
        }
    }
}
// @lc code=end
