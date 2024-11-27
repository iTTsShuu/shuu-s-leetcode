/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    // 答案列表 用cur拼成的字符串为 key 以避免重复
    Map<String, List<Integer>> anss = new HashMap<>();
    // 当前排列
    List<Integer> cur = new LinkedList<>();

    // 递归回溯
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] used = new boolean[n];
        backTrack(nums, used, 0, "");
        return List.copyOf(anss.values());
    }

    private void backTrack(int[] nums, boolean[] used, int index, String key) {
        if (cur.size() == nums.length) {
            anss.put(key, List.copyOf(cur));
        }
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                cur.add(nums[i]);
                used[i] = true;
                backTrack(nums, used, index + 1, key + String.valueOf(nums[i]));
                // 恢复现场
                cur.remove(index);
                used[i] = false;
            }
        }
    }
}
// @lc code=end
