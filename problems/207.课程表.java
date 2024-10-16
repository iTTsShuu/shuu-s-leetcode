/*
 * @lc app=leetcode.cn id=207 lang=java
 *
 * [207] 课程表
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length <= 1) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] ax : prerequisites) {
            map.put(ax[0], ax[1]);
        }
    }
}
// @lc code=end
