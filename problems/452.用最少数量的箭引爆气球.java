/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] < b[0]) {
                    return -1;
                } else {
                    if (a[0] == b[0]) {
                        if (a[1] < b[1]) {
                            return -1;
                        }
                    }
                    return 1;
                }
            }
        });
        // for (int i = 0; i < points.length; i++) {
        // System.out.println(points[i][0] + "," + points[i][1]);
        // }
        int count = 1;
        int[] range = new int[] { points[0][0], points[0][1] };
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > range[1]) {
                count++;
                range[0] = points[i][0];
                range[1] = points[i][1];
            } else if (points[i][0] <= range[1] && points[i][0] >= range[0]) {
                range[0] = Math.max(range[0], points[i][0]);
                range[1] = Math.min(range[1], points[i][1]);
            }
        }
        return count;
    }
}
// @lc code=end

class tessss {
    public static void main(String[] args) {
        mySolution solution = new mySolution();
        int[][] points = new int[][] {
                { 7, 12 },
                { 2, 8 },
                { 10, 16 },
                { 1, 6 } };
        System.out.println(solution.findMinArrowShots(points));
    }
}