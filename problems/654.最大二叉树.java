/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Map<Integer, Integer> indexMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        TreeNode root = buildMaxTree(nums, 0, nums.length - 1, indexMap);
        return root;
    }

    public TreeNode buildMaxTree(int[] nums, int i, int j, Map<Integer, Integer> indexMap) {
        if (j < i) {
            return null;
        }
        int maxN = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            maxN = Math.max(maxN, nums[k]);
        }
        Integer maxI = indexMap.get(maxN);
        TreeNode node = new TreeNode(maxN);
        node.left = buildMaxTree(nums, i, maxI - 1, indexMap);
        node.right = buildMaxTree(nums, maxI + 1, j, indexMap);
        return node;
    }
}
// @lc code=end
