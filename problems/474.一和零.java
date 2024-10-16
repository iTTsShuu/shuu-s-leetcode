/*
 * @lc app=leetcode.cn id=474 lang=java
 *
 * [474] 一和零
 */

// @lc code=start
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int s = strs.length;
        int[][] zeroAndOne = new int[s][2];
        for (int i = 0; i < strs.length; i++) {
            String is = strs[i];
            int[] cntZeroOne = cntZeroOne(is);
            zeroAndOne[i][0] = cntZeroOne[0];
            zeroAndOne[i][1] = cntZeroOne[1];
        }
        // 选或者不选 背包问题 经典 dp[i][j]代表 使用j个0 k个1的最大子集长度
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < s; i++) {

            int cnt0 = zeroAndOne[i][0], cnt1 = zeroAndOne[i][1];
            // shuu: 这里的重点之一也是 内层循环需采用倒序遍历的方式，这种方式保证转移来的是 dp[i−1][][] 中的元素值
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    // shuu: 当前字符串的数量小于 dp[j][k]
                    if (cnt0 <= j && cnt1 <= k) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - cnt0][k - cnt1] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    // shuu:内层循环需采用倒序遍历的方式，这种方式保证转移来的是 dp[i−1][][] 中的元素值
    public int findMaxForm1(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            int[] zerosOnes = cntZeroOne(strs[i]);
            int zeros = zerosOnes[0], ones = zerosOnes[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    int[] cntZeroOne(String s) {
        char[] charArray = s.toCharArray();

        int cnt0 = 0, cnt1 = 0;
        for (char c : charArray) {
            if (c == '0') {
                cnt0++;
            }
            if (c == '1') {
                cnt1++;
            }
        }
        return new int[] { cnt0, cnt1 };
    }
}

// @lc code=end
class test474 {
    public static void main(String[] args) {
        Solution474 solu = new Solution474();
        String[] strs = new String[] {
                "10", "0001", "111001", "1", "0"
        };
        System.out.println(solu.findMaxForm(strs, 5, 3));
    }
}