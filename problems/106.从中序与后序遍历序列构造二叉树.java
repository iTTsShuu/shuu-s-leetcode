/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

//import javax.swing.tree.TreeNode;

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
    Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root;
        root = BuildTreeWithINPOST(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    public TreeNode BuildTreeWithINPOST(
            int[] inorder, int[] postorder,
            int instart, int inend,
            int poststart, int postend) {
        if (poststart > postend) {
            return null;
        }
        // 构建根节点
        int inorderIndex = indexMap.get(postorder[postend]);
        TreeNode root = new TreeNode(postorder[postend]);
        // 左子树节点数
        int size_left = inorderIndex - instart;
        // 递归构建左右子树
        root.right = BuildTreeWithINPOST(
                inorder, postorder,
                instart + size_left + 1, inend,
                poststart + size_left, postend - 1);
        root.left = BuildTreeWithINPOST(
                inorder, postorder,
                instart, instart + size_left - 1,
                poststart, poststart + size_left - 1);
        return root;
    }
}

// @lc code=end

// class TreeNode {
// int val;
// TreeNode left;
// TreeNode right;

// TreeNode() {
// }

// TreeNode(int val) {
// this.val = val;
// }

// TreeNode(int val, TreeNode left, TreeNode right) {
// this.val = val;
// this.left = left;
// this.right = right;
// }
// }

// class test {
// public static void main(String[] args) {
// int[] postorder = new int[] { 9, 15, 7, 20, 3 };
// int[] inorder = new int[] { 9, 3, 15, 20, 7 };
// mySolution solution = new mySolution();
// TreeNode root = solution.buildTree(inorder, postorder);
// }
// }