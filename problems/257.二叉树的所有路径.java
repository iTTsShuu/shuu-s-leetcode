/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

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
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        // 递归写吧
        // shuu: 写吧 你就递归吧 一递归一个不吱声

        dfs(root, "");
        return ans;
    }

    void dfs(TreeNode root, String path) {
        if (root != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(root.val);
            // 叶子节点
            if (root.left == null && root.right == null) {
                ans.add(sb.toString());
            } else {
                // 非叶子节点
                sb.append("->");
                dfs(root.left, sb.toString());
                dfs(root.right, sb.toString());
            }
        }
    }
}
// @lc code=end
