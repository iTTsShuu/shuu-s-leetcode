/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 */

// @lc code=start

import java.util.Deque;
import java.util.LinkedList;

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
    int ans;
    int pre;

    public int getMinimumDifference(TreeNode root) {
        // 中序遍历过程中维护
        ans = Integer.MAX_VALUE;
        pre = -1;
        getAns(root);
        return ans;
    }

    public void getAns(TreeNode node) {
        if (node == null) {
            return;
        }
        getAns(node.left);
        if (pre == -1) {
            pre = node.val;
        } else {
            ans = Math.min(ans, node.val - pre);
            pre = node.val;
        }
        getAns(node.right);
    }
}
// @lc code=end
