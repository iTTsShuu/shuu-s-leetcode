import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
// class TreeNode {
//     int val;
//    TreeNode left;
//     TreeNode right;
//    TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }
class Solution {
    
    List<TreeNode> list=new ArrayList<>();
    
    public void flatten(TreeNode root) {
        dfstoadd(root);
        TreeNode node =root;
        for (int i = 1; i < list.size(); i++) {
            TreeNode temp=list.get(i);
            node.left=null;
            node.right=temp;
            node=node.right;
        }
    }
    public void dfstoadd(TreeNode root){
        if(root==null)return;
        list.add(root);
        if(root.left!=null){
            dfstoadd(root.left);
        }
        if(root.right!=null){
            dfstoadd(root.right);
        }
    }
}
// @lc code=end
class test{
    public static void main(String[] args) {
        mySolution solution=new mySolution();
        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(3),new TreeNode(4))
        ,new TreeNode(5,null,new TreeNode(6)));
        solution.flatten(root);
    }
}
