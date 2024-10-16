import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return ans;
    }
    public int maxGain(TreeNode root)  {
        if(root ==null){
            return 0;
        }
        int leftGain=Math.max(maxGain(root.left), 0);
        int rightGain=Math.max(maxGain(root.right), 0);
        //当前可能的最大路径和
        int newPath= root.val+leftGain+rightGain;
        ans= Math.max(ans, newPath);
        return root.val+Math.max(rightGain, leftGain);
    }
}
// @lc code=end

