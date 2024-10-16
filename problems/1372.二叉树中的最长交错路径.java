/*
 * @lc app=leetcode.cn id=1372 lang=java
 *
 * [1372] 二叉树中的最长交错路径
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
    int maxAns;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxAns = 0;
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxAns;
    }

    public void dfs(TreeNode root, boolean dir, int len) {
        maxAns = Math.max(maxAns, len);
        if (dir) {
            if (root.left != null) {
                dfs(root.left, false, len + 1);
            }
            if (root.right != null) {
                dfs(root.right, true, 1);
            }
        } else {
            if (root.right != null) {
                dfs(root.right, true, len + 1);
            }
            if (root.left != null) {
                dfs(root.left, false, 1);
            }
        }
    }
}
// @lc code=end
