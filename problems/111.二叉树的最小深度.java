/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth1(TreeNode root) {
        // shuu: 递归深度优先
        if (root == null) {
            return 0;
        }
        // 叶子节点
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        // 注意判断左右节点不为空
        if (root.left != null) {
            min = Math.min(min, minDepth(root.left));
        }
        if (root.right != null) {
            min = Math.min(min, minDepth(root.right));
        }
        return min + 1;
    }

    //
    public int minDepth(TreeNode root) {
        // shuu: 递归深度优先
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 注意判断
        if (left == 0 || right == 0)
            return Math.max(left, right) + 1;
        return Math.min(left, right) + 1;
    }

}
// @lc code=end
