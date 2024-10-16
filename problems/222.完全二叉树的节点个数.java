/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        //计算树的高度
        TreeNode node=root;
        int depth=0;
        while(node.left!=null){
            depth++;
            node=node.left;
        }
        //二分搜索
        int minP=1<<depth , maxP=(1<<(depth+1))-1;
        while(minP<maxP){
            int mid=(maxP-minP+1)/2+minP;//用(maxP-minP+1)/2+minP而不是(maxP+minP+1)/2是为了防止溢出
            //存在节点是说明节点数更大
            if(existp(mid, root, depth)){
                minP=mid;
            }
            //不存在时说明节点数更小
            else{
                maxP=mid-1;
            }
        }
        return minP;
    }
    //判断完全二叉树是否存在第K个节点（depth为二叉树高度）
    public boolean existp(int nodeK, TreeNode root,int depth) {
        int step=1<<(depth-1);
        TreeNode node=root;
        while(node!=null && step!=0){
            if((step&nodeK)==0){
                node=node.left;
            }
            else{
                node=node.right;
            }
            step=step>>1;
        }
        return node!=null;
    }
}
// @lc code=end

