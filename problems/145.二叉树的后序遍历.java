/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        // 深度优先
        // 后序遍历 ：左右根
        List<Integer> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        // 主要思想：
        // 由于在某颗子树访问完成以后，接着就要回溯到其父节点去
        // 因此可以用prev来记录访问历史，在回溯到父节点时，可以由此来判断，上一个访问的节点是否为右子树
        TreeNode node = root;
        TreeNode prev = null;
        while (node != null || !deque.isEmpty()) {
            // 先左
            while (node != null) {
                deque.push(node);
                node = node.left;
            }
            // 从栈中弹出的元素，左子树一定是访问完了的
            // 回溯节点
            TreeNode pop = deque.pop();
            // 现在需要确定的是是否有右子树，或者右子树是否访问过
            // 如果没有右子树，或者右子树访问完了，也就是上一个访问的节点是右子节点时
            // 说明可以访问当前节点
            if (pop.right != null && pop.right != prev) {
                // 如果右子树没有被访问，那么将当前节点压栈，访问右子树
                // 处理右子树
                deque.push(pop);
                node = pop.right;

            } else {
                // 右子树以及访问过 或者没有右子树
                ansList.add(pop.val);
                // 更新历史访问记录，这样回溯的时候父节点可以由此判断右子树是否访问完成
                prev = pop;
            }
        }
        return ansList;
    }

    // shuu:还是递归来的快
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    void postorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }

}
// @lc code=end
