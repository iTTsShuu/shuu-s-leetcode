
/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
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

    public int pathSum(TreeNode root, int targetSum) {
        ans = 0;
        TreeNode node = root;
        Deque<TreeNode> stack = new LinkedList<>();
        // 中序遍历所有节点
        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            dpsSum(node, targetSum);
            node = node.right;
        }
        return ans;
    }

    // 计算以某个节点为起点
    public void dpsSum(TreeNode node, long currSum) {
        if (node == null) {
            return;
        }
        currSum -= node.val;
        if (currSum == 0) {
            ans++;
        }

        dpsSum(node.left, currSum);
        dpsSum(node.right, currSum);
    }
}
// @lc code=end
