/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class mySolution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left=0 ,right=intervals.length-1;
        while (intervals[left][0]<intervals[right][0]) {
            int mid = (left+right) >> 1;
            if (newInterval[0]<=intervals[mid][0]) {
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        List<int[]> ansList= new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (i==right) {
                ansList.add(newInterval);
            }
            ansList.add(intervals[i]);
            
        }
        int start=right;
        int curAry=right+1;
        while (ansList.get(start)[1]>=ansList.get(curAry)[0]) {
            ansList.get(start)[1]=Math.max(ansList.get(curAry)[1], ansList.get(start)[1]);
            ansList.remove(curAry);
        }
        return ansList.toArray(new int[ansList.size()][2]);
    }
}
// @lc code=end

class test{
    public static void main(String[] args) {
        mySolution solution=new mySolution();
        int[][] intervals={
            {1,3},
            {6,9}
        };
        int[] newInterval={2,5};
        int[][] ans=solution.insert(intervals,newInterval);
        for (int[] is : ans) {
            System.out.println("("+is[0]+","+is[1]+")");
        }
    }
}
