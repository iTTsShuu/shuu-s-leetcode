/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
    public List<Integer> rerightSideView(TreeNode root) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> nodeStack = new LinkedList();
        Deque<Integer> depthStack = new LinkedList();
        if (root == null) {
            return ans;
        }
        nodeStack.push(root);
        depthStack.push(0);
        int max_depth = 0;
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if (node != null) {
                // 维护最大深度
                max_depth = Math.max(max_depth, depth);
                // 只有当前深度为存过数据是=时存入
                if (!map.containsKey(depth)) {
                    map.put(depth, node.val);
                }
                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        for (int i = 0; i <= max_depth; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    // 尝试广度优先实现
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> duilie = new LinkedList<>();
        duilie.add(root);
        while (!duilie.isEmpty()) {
            TreeNode node;
            int duilieSize = duilie.size();
            int curNodeVal = -101;
            for (int i = 0; i < duilieSize; i++) {
                node = duilie.remove();
                if (node != null) {
                    curNodeVal = node.val;
                    duilie.add(node.left);
                    duilie.add(node.right);
                }
            }
            if (curNodeVal != -101) {
                ans.add(curNodeVal);
            }
        }
        return ans;
    }
}
// @lc code=end
