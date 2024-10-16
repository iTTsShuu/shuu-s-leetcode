/*
 * @lc app=leetcode.cn id=1315 lang=java
 *
 * [1315] 祖父节点值为偶数的节点和
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
    int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        if (root.left != null) {
            dps(root, root.left, root.left.left);
            dps(root, root.left, root.left.right);
        }
        if (root.right != null) {
            dps(root, root.right, root.right.left);
            dps(root, root.right, root.right.right);
        }
        return sum;
    }

    void dps(TreeNode grandParent, TreeNode parent, TreeNode node) {
        if (node == null) {
            return;
        }
        if (grandParent.val % 2 == 0) {
            sum += node.val;
        }
        dps(parent, node, node.left);
        dps(parent, node, node.right);
    }

}
// @lc code=end
