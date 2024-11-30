/*
 * @lc app=leetcode.cn id=1145 lang=java
 *
 * [1145] 二叉树着色游戏
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int x, lsize, rsize;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // 深度遍历计算子树节点个数
        // 关键点见灵神解题
        // https://leetcode.cn/problems/binary-tree-coloring-game/solutions/2089813/mei-you-si-lu-yi-zhang-tu-miao-dong-pyth-btav/?source=vscode
        this.x = x;
        dfs(root); // 计算左右子树节点数
        return Math.max(Math.max(lsize, rsize), n - 1 - lsize - rsize) * 2 > n;
    }

    int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int ls = dfs(node.left);
        int rs = dfs(node.right);
        if (node.val == x) {
            lsize = ls;
            rsize = rs;
        }
        return ls + rs + 1;
    }
}
// @lc code=end
