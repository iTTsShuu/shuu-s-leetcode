/*
 * @lc app=leetcode.cn id=1038 lang=java
 *
 * [1038] 从二叉搜索树到更大和树
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
    public TreeNode bstToGst(TreeNode root) {
        // 看起来好像只需要反向中序遍历就搞定了
        dfs(root);
        return root;
    }

    // 用来表示全局的sum 在递归过程中表示当前节点 右子树的和
    // 即为比当前节点值大的所有数的和
    int sum = 0;

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        // 递归处理右子树
        dfs(node.right);
        /// 先加上当前值
        sum += node.val;
        // 因为右子树的值与左子树无关 可以直接得到当前节点的和
        node.val = sum;
        // 再递归修改左子树
        dfs(node.left);
    }
}
// @lc code=end
