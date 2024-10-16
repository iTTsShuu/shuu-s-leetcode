import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 记录节点位置的哈希表
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        // 先构建根节点
        TreeNode root;
        int n = preorder.length;
        root = mybuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        return root;
    }

    public TreeNode mybuildTree(int[] preorder, int[] inorder,
            int prestart, int preend, int instart, int inend) {
        if (prestart > preend) {
            return null;
        }
        // 先构建根节点
        int rootindex = indexMap.get(preorder[prestart]);
        TreeNode root = new TreeNode(preorder[prestart]);
        // 找到左右子树前序和中序遍历的起始点
        // 左子树节点数
        int left_size = rootindex - instart;
        // 递归构建左右子树
        root.left = mybuildTree(preorder, inorder, prestart + 1, prestart + left_size, instart,
                instart + left_size - 1);
        root.right = mybuildTree(preorder, inorder, prestart + left_size + 1, preend, rootindex + 1, inend);
        return root;
    }
}
// @lc code=end
// class test{
// public static void main(String[] args) {
// int[] preorder=new int[]{3,9,20,15,7};
// int[] inorder=new int[]{9,3,15,20,7};
// mySolution solution=new mySolution();
// TreeNode root=solution.buildTree(preorder, inorder);
// System.out.println(root.toString());
// }
// }
