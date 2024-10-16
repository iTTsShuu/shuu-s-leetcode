/*
 * @lc app=leetcode.cn id=436 lang=java
 *
 * [436] 寻找右区间
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        // 记录原本下标
        for (int i = 0; i < n; i++) {
            indexMap.put(intervals[i][0], i);
        }
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = i, right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (intervals[mid][0] >= intervals[i][1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            ans[indexMap.get(intervals[i][0])] = intervals[left][0] >= intervals[i][1]
                    ? indexMap.get(intervals[left][0])
                    : -1;
        }
        return ans;
    }
}
// @lc code=end

class findRightIntervalTest {
    public static void main(String[] args) {
        mySolution solution = new mySolution();
        int[][] intervals = new int[][] {
                { 3, 4 },
                { 1, 2 },
                { 2, 3 }
        };

        int[] ans = solution.findRightInterval(intervals);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}