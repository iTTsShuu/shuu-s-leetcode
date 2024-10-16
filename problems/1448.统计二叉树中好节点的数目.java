/*
 * @lc app=leetcode.cn id=1448 lang=java
 *
 * [1448] 统计二叉树中好节点的数目
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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        if (root.val >= max) {
            int ans = 1;
            ans += dfs(root.left, root.val) + dfs(root.right, root.val);
            return ans;
        } else {
            int ans = 0;
            ans += dfs(root.left, max) + dfs(root.right, max);
            return ans;
        }
    }
}
// @lc code=end
