import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    List<Integer> ans;
    Solution(){
        this.ans=new ArrayList<Integer>();
    }
    public void dfstoadd(TreeNode root){
        if(root==null)return;
        ans.add(root.val);
        if(root.left!=null){
            dfstoadd(root.left);
        }
        if(root.right!=null){
            dfstoadd(root.right);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        dfstoadd(root);
        return this.ans;
    }
}
// @lc code=end

