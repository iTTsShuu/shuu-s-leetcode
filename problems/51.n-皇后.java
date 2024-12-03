/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> anss = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 标记每行的皇后位置
        int[] posQ = new int[n];
        // 储存列是否有皇后
        boolean[] onPath = new boolean[n];
        // 储存当前左上和右上的对角线是否有皇后
        // shuu:这里的重点是 同对角线上的 行列下标相加相等或相减相等
        // 对角线数量为2*n-1；
        int m = 2 * n - 1;
        boolean[] leftUp = new boolean[m];
        boolean[] rightUp = new boolean[m];
        dfs(0, n, posQ, onPath, leftUp, rightUp);
        return anss;
    }

    void dfs(int index, int n, int[] posQ, boolean[] onPath, boolean[] leftUp, boolean[] rightUp) {
        if (index == n) {
            // 构造答案加入 anss
            build(posQ, n);
            return;
        }
        // 选择可以放置的位置
        for (int i = 0; i < n; i++) {
            // 当前位置的列 对角线 都没有皇后
            if (!onPath[i] && !leftUp[index - i + (n - 1)] && !rightUp[i + index]) {
                // 放置皇后
                posQ[index] = i;
                // 标记有皇后的位置
                onPath[i] = leftUp[index - i + (n - 1)] = rightUp[i + index] = true;
                // 递归
                dfs(index + 1, n, posQ, onPath, leftUp, rightUp);
                // 还原现场
                onPath[i] = leftUp[index - i + (n - 1)] = rightUp[i + index] = false;
            }
        }

    }

    void build(int[] posQ, int n) {
        List<String> tmp = new ArrayList<>();
        for (int i : posQ) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            tmp.add(sb.toString());
        }
        anss.add(tmp);
    }
}
// @lc code=end
