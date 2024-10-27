/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
 */

// @lc code=start

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public int findSecondMinimumValue(TreeNode root) {
        // 层序遍历 第一个不更root.val相等的值 就是第二小的节点
        Queue<TreeNode> queue = new LinkedList<>();
        if (root.left == null || root.right == null) {
            return -1;
        }
        int rootVal = root.val;
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                if (cur.left.val == rootVal) {
                    queue.offer(cur.left);
                } else {
                    return cur.left.val;
                }
                if (cur.right.val == rootVal) {
                    queue.offer(cur.right);
                } else {
                    return cur.right.val;
                }
            }
        }
        return -1;

    }
}
// @lc code=end
