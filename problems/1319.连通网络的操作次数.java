/*
 * @lc app=leetcode.cn id=1319 lang=java
 *
 * [1319] 连通网络的操作次数
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer>[] edges;
    boolean[] used;

    public int makeConnected(int n, int[][] connections) {
        // 深度优先搜索 统计连通分量图 用连通分量数-1既为最小操作次数
        int len = connections.length;
        if (len < n - 1) {
            return -1;
        }

        // 统计边
        edges = new List[n];
        for (int i = 0; i < n; ++i) {
            edges[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            edges[connection[0]].add(connection[1]);
            edges[connection[1]].add(connection[0]);
        }
        used = new boolean[n];
        int ans = 0;
        // 对每一个节点求是否是一个连通量图 遍历到未使用的节点时 可以认定这是一个新连通分量图的起点节点
        for (int i = 0; i < n; ++i) {
            if (!used[i]) {
                dfs(i);
                ++ans;
            }
        }

        return ans - 1;

    }

    public void dfs(int u) {
        used[u] = true;
        for (int v : edges[u]) {
            if (!used[v]) {
                dfs(v);
            }
        }
    }
}
// @lc code=end
