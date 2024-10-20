/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        char[] word1C = word1.toCharArray();
        char[] word2C = word2.toCharArray();
        // shuu: 记忆化搜索 动态规划经典思路
        // shuu: dp[i][j] 用来表示将word{0:i}转化为word2[0:j]的最少操作数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // j为0 word2为空 全删除i
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        // i为0 word1为空 全添加j
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 替换i 与 替换j 取最小值
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                // i，j字符相等 不需要转换 取最小值
                if (word1C[i - 1] == word2C[j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    // shuu: 这是什么东西 马勒戈壁 我当时在想什么
    // 好像是笔试某题的代码 存疑
    public int countMax(int[] bricks, int x, int y) {
        int a = bricks[0], b = bricks[1], c = bricks[2];
        if (c > a && c > b) {
            while (a - x > b) {
                a -= x;
                b++;
            }
        } else {
            // 尝试合成c
            while (c < a || c < b) {
                // b合成c
                if (b - y > c) {
                    b -= y;
                    c++;
                } else if (a - x > c) {
                    a -= x;
                    b++;
                } else {
                    break;
                }
            }
        }

        return Math.min(a, Math.min(c, b));
    }

}
// @lc code=end

/**
 * 72.编辑距离
 */
class test72 {
    public static void main(String[] args) {
        int[] abc = new int[] { 10, 0, 0 };
        int x = 1, y = 1;
        Solution72 solution = new Solution72();
        System.out.println(solution.countMax(abc, x, y));
    }
}