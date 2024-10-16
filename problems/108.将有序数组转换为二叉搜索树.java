/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 */

// @lc code=start

// import javax.swing.tree.TreeNode;

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
    public TreeNode sortedArrayToBST(int[] nums) {
        // 取中位树为根
        int n = nums.length;
        TreeNode root = toBST(nums, 0, n - 1);
        return root;
    }

    TreeNode toBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int midN = (left + right) >> 1;
        TreeNode node = new TreeNode(nums[midN]);
        node.left = toBST(nums, left, midN - 1);
        node.right = toBST(nums, midN + 1, right);
        return node;
    }
}
// @lc code=end
