import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1921 lang=java
 *
 * [1921] 消灭怪物的最大数量
 */

// @lc code=start
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        //靠贪心和排序解决，使用一个新的数组存储怪兽的 到达时间，通过贪心最优求解。
        int n=dist.length;
        int[] time =new int[n];
        for (int i = 0; i < n; i++) {
            time[i]=(dist[i]+speed[i]-1)/speed[i];
        }
        Arrays.sort(time);
        // int ntime=0;
        // for (int i = 0; i < n; i++) {
        //  优化前判断太多导致执行时间太长
        //     if(time[i]>ntime){
        //         ntime++;
        //     }
        //     else if(time[i]==ntime){
        //         break;
        //     }
        //     else if(time[i]<ntime){
        //         break;
        //     }
        // }
        // return ntime;
        for (int i = 0; i < n; i++) {
            if (time[i]<=i) {
                return i;
            }
        }
        return n;
    }
}
// @lc code=end

