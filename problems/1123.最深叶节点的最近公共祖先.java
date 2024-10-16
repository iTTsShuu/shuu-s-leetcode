

/*
 * @lc app=leetcode.cn id=1123 lang=java
 *
 * [1123] 最深叶节点的最近公共祖先
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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // return dfs(root).getValue();
        // 计算最大深度
        int n = getDepth(root);
        return dfs(root, 1, n);
    }

    // 因为要返回节点和对应的深度
    public Pair<Integer, TreeNode> dfs(TreeNode node) {
        if (node == null)
            return new Pair<>(0, null);
        var left = dfs(node.left);
        var right = dfs(node.right);
        if (left.getKey() > right.getKey()) // 左子树更高
            return new Pair<>(left.getKey() + 1, left.getValue());
        if (left.getKey() < right.getKey()) // 右子树更高
            return new Pair<>(right.getKey() + 1, right.getValue());
        return new Pair<>(left.getKey() + 1, node); // 一样高
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
}
// @lc code=end
