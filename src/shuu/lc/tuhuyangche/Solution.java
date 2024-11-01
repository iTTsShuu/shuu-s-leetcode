package tuhuyangche;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param tyres string字符串 初始轮胎排列
     * @return int整型
     */
    public int minimumOperations(String tyres) {
        // 左右指针匹配到开始和结尾的L 统计这个范围内的S
        char[] tyresChs = tyres.toCharArray();
        int n = tyresChs.length;
        int l = 0, r = n - 1;
        int cnt = 0;
        // 如果两端没有S
        if (l == 0) {
            cnt++;
            l++;
        }
        if (r == n - 1) {
            cnt++;
            r--;
        }
        // 先定位L
        // 中间可能有 SSSSLSSLLLSS 的情况 也就是改L更优 一会回来看
        // !!!

        while (tyresChs[l] == 'S') {
            l++;
        }
        while (tyresChs[r] == 'S') {
            --r;
        }

        for (int i = l; i <= r; i++) {
            if (tyresChs[i] == 'S') {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 获得考勤奖励的记录情况
     * 
     * @param n int整型 出勤记录的长度（次数）
     * @return int整型
     */

    int MOD = 1_000_000_007;
    int ans;

    public int checkRecord(int n) {
        // 想法1： 求全排列
        dfs(n, 0, 0, 0, 1);
        // 动态规划类似的 思路：
        // dp[n]表示n的最大记录数
        // d[i]=d[i-1]*3(第i个时 有三种可选)
        return ans;
    }

    /**
     * 
     * @param n
     * @param cntA
     * @param constL   当前L的连续长度 在放A或者P后清0
     * @param curDepth
     */
    // 递归全排列
    public void dfs(int n, int cntA, int constL, int curDepth, int curSum) {
        if (curDepth == n - 1) { // 已经是长度为n的排列
            // ans = (ans + 1) % MOD;
            return;
        }
        // 改进
        // 不是求到全排列再记录数加1 每次都计算当前位置可添加的数有A,L,P其中几种
        // 直接将答案乘以倍数
        if (cntA < 1 && constL < 2) { // 当前位置有三种可放的数
            ans = Math.max((curSum * 3), ans) % MOD;
            // 递归后序三种情况
            dfs(n, cntA + 1, 0, curDepth + 1, curSum); // 好像醒悟了 这里得把ans带过去
            dfs(n, cntA, constL + 1, curDepth + 1, curSum);
            dfs(n, cntA, 0, curDepth + 1, curSum);
        } else if (constL < 2) { // 当前位置有2种可放
            // 答案乘2
            ans = Math.max((curSum * 2), ans) % MOD;
            //
            dfs(n, cntA, constL + 1, curDepth + 1, curSum);
            dfs(n, cntA, 0, curDepth + 1, curSum);
        } else {// 只有一种可放
            dfs(n, cntA, 0, curDepth + 1, curSum);
        }

        // // 添加A
        // if (cntA < 1) {
        // // L连续长度置为0 depTh+1
        // dfs(n, cntA + 1, 0, curDepth + 1);
        // }
        // // 添加L
        // if (constL < 2) {
        // // L连续长度+1 depTh+1
        // dfs(n, cntA, constL + 1, curDepth + 1);
        // }
        // // 添加P
        // dfs(n, cntA, 0, curDepth + 1);

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算满足用户洗车需求的最小花费
     * 
     * @param T  int整型 用户未来一年内需要洗车的总次数
     * @param P1 int整型 套餐A的价格
     * @param C1 int整型 套餐A的可用次数
     * @param P2 int整型 套餐B的价格
     * @param C2 int整型 套餐B的可用次数
     * @param P3 int整型 套餐C的价格
     * @param C3 int整型 套餐C的可用次数
     * @return int整型
     */
    public int optimalWashPlan(int T, int P1, int C1, int P2, int C2, int P3, int C3) {
        // 背包问题
        // 对于 第i次洗车 dp[i]=Min(dp[i-C1]+P1,dp[i-C2]+P2,dp[i-C3]+P3) 取最小值 i-Ci<0时 视为dp[0]
        // 理解dp[0]理解为0 第0次洗车
        // dp[T] 为所求
        int[] dp = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            dp[i] = Math.min(dp[i - C1 < 0 ? 0 : i - C1] + P1,
                    Math.min(dp[i - C2 < 0 ? 0 : i - C2] + P2,
                            dp[i - C3 < 0 ? 0 : i - C3] + P3));
        }
        return dp[T];
    }

}