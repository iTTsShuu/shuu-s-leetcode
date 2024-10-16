/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ansList;

    public List<List<Integer>> subsets(int[] nums) {
        ansList = new ArrayList<>();
        dfsSub(nums, 0, new ArrayList<>());
        return ansList;
    }

    public void dfsSub(int[] nums, int depth, List<Integer> lastList) {
        if (depth == nums.length) {
            List<Integer> tmp = new ArrayList<>(lastList);
            ansList.add(tmp);
            return;
        }
        lastList.add(nums[depth]);
        dfsSub(nums, depth + 1, lastList);
        lastList.remove(lastList.size() - 1);
        dfsSub(nums, depth + 1, lastList);

    }
}
// @lc code=end
