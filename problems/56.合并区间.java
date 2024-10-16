import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        // if (intervals.length==1) {
        // return intervals;
        // }
        // Arrays.sort(intervals,(f1,f2)->{
        // return f1[0]-f2[0];
        // });
        // List<int[]> ansList = new ArrayList<int[]>();
        // int[] cur;
        // for (int i = 0; i < intervals.length; i++) {
        // cur=intervals[i];
        // //不可合并，当前区间加入答案集
        // if (ansList.size()==0 || ansList.get(ansList.size()-1)[1] < cur[0]) {
        // ansList.add(new int[]{cur[0],cur[1]});
        // }
        // //可合并
        // else{
        // ansList.get(ansList.size()-1)[1]=Math.max(ansList.get(ansList.size()-1)[1],
        // cur[1]);
        // }
        // }
        // return ansList.toArray(new int[ansList.size()][]);

        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        List<int[]> ansList = new ArrayList<>();
        int l = 0, r = 1;
        ansList.add(new int[] { intervals[0][0], intervals[0][1] });
        while (r < intervals.length) {
            int[] tmp = intervals[r];
            int[] last = ansList.get(l);
            // 可以合并
            if (last[1] >= tmp[0]) {
                last[1] = Math.max(last[1], tmp[1]);
            } else {// 不可合并
                ansList.add(tmp);
                l++;
            }
            r++;
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}
// @lc code=end

class testt {
    public static void main(String[] args) {
        mySolution solution = new mySolution();
        int[][] intervals = {
                { 1, 3 },
                { 8, 10 },
                { 2, 6 },
                { 15, 18 }
        };
        int[][] ans = solution.merge(intervals);
        for (int[] is : ans) {
            System.out.println("(" + is[0] + "," + is[1] + ")");
        }
    }
}
