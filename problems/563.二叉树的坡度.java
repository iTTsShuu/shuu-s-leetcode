/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
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

    int ans = 0;

    public int findTilt(TreeNode root) {
        // 深度优先 递归
        //
        dfs(root);
        return ans;
    }

    // 同时做求和和计算坡度
    // 递归的返回值应该为求和结果
    // 将坡度累加在答案中返回
    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        ans += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
// @lc code=end
