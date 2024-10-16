/*
 * @lc app=leetcode.cn id=865 lang=java
 *
 * [865] 具有所有最深节点的最小子树
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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // 计算最大深度
        int n = getDepth(root);
        return dfs(root, 1, n);
    }

    // 计算最大深度
    int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftL = getDepth(node.left);
        int rightL = getDepth(node.right);
        return Math.max(leftL, rightL) + 1;
    }

    // 递归求解
    public TreeNode dfs(TreeNode node, int depth, int n) {

        if (node == null) {
            return null;
        }
        TreeNode left = dfs(node.left, depth + 1, n);
        TreeNode right = dfs(node.right, depth + 1, n);
        if (depth == n || (left != null && right != null)) {
            return node;
        }
        if (left != null) {
            return left;
        }
        return right;

    }

    // void dfs(TreeNode node, int depth, int max) {
    // if (node == null) {
    // return;
    // }

    // }
}

// @lc code=end
// class test865 {
// public static void main(String[] args) {
// Solution865 solution865 = new Solution865();
// solution865.subtreeWithAllDeepest(null);
// }
// }