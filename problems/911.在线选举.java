/*
 * @lc app=leetcode.cn id=911 lang=java
 *
 * [911] 在线选举
 */

// @lc code=start

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class TopVotedCandidate {

    int[] times;
    List<Integer> tops;
    Map<Integer, Integer> personCnt;// 记录得票

    // 这里记录在二分的解法正确性来自 times数组严格递增
    public TopVotedCandidate(int[] persons, int[] times) {
        this.personCnt = new HashMap<>();
        this.tops = new LinkedList<>();
        int top = -1; // 初始当前最高得票
        personCnt.put(-1, -1);
        for (int i = 0; i < persons.length; i++) {
            int curP = persons[i];
            personCnt.put(curP, personCnt.getOrDefault(curP, 0) + 1);
            if (personCnt.get(curP) >= personCnt.get(top)) { // 注意等号判定
                top = curP;
            }
            tops.add(top);
        }
        this.times = times;
    }

    public int q(int t) { // 这里二分的关键是找到 time[i]<=t 的最大值
        int l = 0, r = times.length - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2; // （r-l+1）是针对l与r相邻时的处理 将l-1
            if (times[m] > t) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return tops.get(l);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
// @lc code=end
