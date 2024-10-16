/*
 * @lc app=leetcode.cn id=539 lang=java
 *
 * [539] 最小时间差
 */

// @lc code=start

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public int findMinDifference1(List<String> timePoints) {
        // 尝试LocalTIme
        List<LocalTime> timeList = new ArrayList<>();
        timePoints.forEach(s -> {
            LocalTime time = LocalTime.parse(s, DateTimeFormatter.ofPattern("HH:mm"));
            timeList.add(time);
        });
        Collections.sort(timeList);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < timeList.size(); i++) {
            LocalTime t1 = timeList.get(i);
            LocalTime t2 = timeList.get(i - 1);
            ans = Math.min(ans, t1.compareTo(t2));
        }
        return ans;
    }

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int ans = Integer.MAX_VALUE;
        int t0Minutes = getMinutes(timePoints.get(0));
        int preMinutes = t0Minutes;
        for (int i = 1; i < timePoints.size(); ++i) {
            int minutes = getMinutes(timePoints.get(i));
            ans = Math.min(ans, minutes - preMinutes); // 相邻时间的时间差
            preMinutes = minutes;
        }
        ans = Math.min(ans, t0Minutes + 1440 - preMinutes); // 首尾时间的时间差
        return ans;
    }

    public int getMinutes(String t) {
        return ((t.charAt(0) - '0') * 10 + (t.charAt(1) - '0')) * 60 + (t.charAt(3) - '0') * 10 + (t.charAt(4) - '0');
    }
}

// @lc code=end
class test539 {
    public static void main(String[] args) {
        String[] s = { "23:59", "00:00" };
        Solution539 solution = new Solution539();
        System.out.println(solution.findMinDifference(Arrays.asList(s)));
    }
}