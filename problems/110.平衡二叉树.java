/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                int abs = Math.abs(count(node.left, 0) - count(node.right, 0));
                if (abs > 1) {
                    return false;
                }
                node = node.left;
            }
            node = stack.pop().right;
        }
        return true;
    }

    int count(TreeNode node, int count) {
        if (node == null) {
            return count;
        }
        return Math.max(count(node.left, count + 1), count(node.right, count + 1));
    }
}
// @lc code=end
