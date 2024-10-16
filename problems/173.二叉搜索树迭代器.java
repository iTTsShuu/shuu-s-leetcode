/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
 */

// @lc code=start

import java.util.Stack;

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
class BSTIterator {

    TreeNode curNode;
    Stack<TreeNode> hisNode;

    public BSTIterator(TreeNode root) {
        this.hisNode = new Stack<TreeNode>();
        this.curNode = root;
    }

    public int next() {
        while (this.curNode != null) {
            this.hisNode.push(this.curNode);
            this.curNode = this.curNode.left;
        }
        this.curNode = this.hisNode.pop();
        int val = this.curNode.val;
        this.curNode = this.curNode.right;
        return val;
    }

    public boolean hasNext() {
        return this.curNode != null || !this.hisNode.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end
