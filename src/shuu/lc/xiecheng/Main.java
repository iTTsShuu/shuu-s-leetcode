package xiecheng;

import java.util.*;

public class Main {

    private static int maxSubP(String s) {
        // 最长回文子串的长度 + 中间的位置字符需要重复
        // 最长长度除以2为答案
        if ("".equals(s)) {
            return 0;
        }
        // 遍历所有长度 最短为2 //回文判断是子串两边的i j字符 相等时看dp[i+1][j-1]
        // 长度一定为偶数
        // 存在误区 非最长回文子串的部分 也会发生消除
        // 思路整体进入误区
        // 改换栈
        // int len = s.length();
        // boolean[][] dp = new boolean[len][len]; // dp[i][j]表示下标i字符到下标j字符是否为回文
        // int maxL = 0;
        // for (int L = 2; L <= len; L += 2) {
        // for (int i = 0; i + L - 1 < len; i++) {
        // int j = i + L - 1;
        // if (s.charAt(i) == s.charAt(j)) {
        // if (L > 2) {
        // dp[i][j] = dp[i + 1][j - 1];
        // } else {
        // dp[i][j] = true;
        // }
        // if (dp[i][j]) {
        // maxL = Math.max(maxL, L);
        // }
        // }
        // }
        // }
        // return maxL / 2;

        int cnt = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (Character ch : s.toCharArray()) {
            if (stack.isEmpty() || !stack.peek().equals(ch)) {
                stack.push(ch);
            } else {
                stack.pop();
                cnt++;
            }
        }
        return cnt;
    }

    // 2
    private static int transform(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        /*
         * 2X2 1个1 2个1 3个1都有解
         * 0 0 | 1 0 | 0 1 | 0 0 | 1 1
         * 0 1 | 1 0 | 1 1 | 0 0 | 1 1
         * 3X3
         * 
         */
        // 动态规划？设dp[i][j]为矩阵前i列和前j列是否可以变换
        // i=1 或者 j=1情况 只有一行或一列 对于位置 i j

        return -1;
    }

    // 3
    static int cnt = 0;
    static int MOD = 1_000_000_007;

    private static int findAllPos(int[] a, int m, int b) { // m天数 b最大失误数

        // 组合
        // 递归求所有组合
        dfs(a, m, b, 0, 0);
        return cnt;
    }

    static void dfs(int[] a, int m, int b, int curB, int curIndex) {

        if (m == 0) {
            if (curB <= b) {
                cnt++;
                cnt %= MOD;
            }
            return;
        }
        if (curIndex >= a.length || curB > b) { // 没有员工或者当前已经不成功时 返回
            return;
        }
        for (int i = 0; i <= m; i++) {
            // 遍历递归当前员工工作0~m天
            dfs(a, m - i, b, curB + (i * a[curIndex]), curIndex + 1);
        }
    }

    private static int sumHeighest(int[] a) {
        // 直接计算
        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                // 错误了
                // ans += Math.pow(Math.log(a[i] ^ a[j]), 2);
                ans += Math.pow(getMLn(a[i] ^ a[j]), 2);
            }
        }
        return ans;
    }

    private static int getMLn(int i) {
        int times = 0;
        while (Math.pow(2, times) < i) {
            times++;
        }
        return times;
    }

    public static void main(String[] args) {
        // // 1
        // Scanner in = new Scanner(System.in);
        // int T = in.nextInt();
        // in.nextLine();
        // String[] s = new String[T];
        // for (int i = 0; i < T; i++) {
        // s[i] = in.nextLine();
        // }
        // for (int i = 0; i < T; i++) {
        // System.out.println(maxSubP(s[i]));
        // }

        //// 2
        // Scanner in = new Scanner(System.in);
        // int T = in.nextInt();
        // in.nextLine();
        // List<int[][]> grids = new ArrayList<>();
        // for (int i = 0; i < T; i++) {
        // int n = in.nextInt(), m = in.nextInt();
        // int[][] grid = new int[n][m];
        // for (int j = 0; j < n; j++) {
        // for (int j2 = 0; j2 < m; j2++) {
        // grid[j][j2] = in.nextInt();
        // }
        // in.nextLine();
        // }
        // grids.add(grid);
        // }
        // for (int[][] is : grids) {
        // System.out.println(transform(is));
        // }

        // 3
        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt(), m = in.nextInt(), b = in.nextInt();
        // in.nextLine();
        // int[] a = new int[n];
        // for (int i = 0; i < n; i++) {
        // a[i] = in.nextInt();
        // }
        // System.out.println(findAllPos(a, m, b));

        // 4
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        in.nextLine();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(sumHeighest(a));
    }

}
