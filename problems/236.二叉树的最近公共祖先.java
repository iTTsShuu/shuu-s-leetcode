
/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;

    // 递归函数
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        // 递归到底时为出口
        if (root == null) {
            return false;
        }
        // 先向深处递归
        boolean lca = dfs(root.left, p, q);
        boolean rca = dfs(root.right, p, q);
        // shuu: 这里的判断一眼抄 我真会抄吧
        if ((lca && rca) || (((root.val == p.val) || (root.val == q.val)) && (lca || rca))) {
            ans = root;
        }
        return lca || rca || ((root.val == p.val) || (root.val == q.val));
    }

    // 重写递归的方法函数

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 当前节点为空 或为 p，q时 直接返回当前节点
        if (root == null || root == p || root == q) {
            return root;
        }
        // 否则分别递归左右节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左右节点都有 p或q 当前节点为最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 只有左有 返回递归左子树的结果
        if (left != null) {
            return left;
        }
        // 否则返回递归右子树的结果
        return right;
    }
}
// @lc code=end
