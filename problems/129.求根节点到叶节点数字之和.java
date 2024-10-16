import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
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
    private int Ans=0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return Ans;
    }
    public void dfs(TreeNode root, int curSum){
        if(root!=null){
            int Sum=(curSum*10)+root.val;
            if(root.left!=null){
                dfs(root.left, Sum);
            }
            if(root.right!=null){
                dfs(root.right, Sum);
            }
            if(root.left==null && root.right==null){
                this.Ans+=Sum;
            }
        }
    }
}
// @lc code=end

