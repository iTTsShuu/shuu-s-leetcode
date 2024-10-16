import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排�?
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute1(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }
        boolean[] used = new boolean[n];
        List<Integer> pos = new ArrayList();
        dfc(nums, n, 0, used, pos, ans);
        return ans;
    }

    // 递归划小排列，回溯完成全排
    void dfc(int[] nums, int n, int index, boolean[] used, List<Integer> pos, List<List<Integer>> ans) {
        int i;
        if (index == n) { // 递归出口
            ans.add(new ArrayList<>(pos)); // 执行拷贝，避免pos回溯后变为空列表
            return;
        }
        for (i = 0; i < n; i++) {
            if (!used[i]) { // 当前位置元素未被使用
                pos.add(nums[i]);
                used[i] = true;
                dfc(nums, n, index + 1, used, pos, ans);
                used[i] = false; // 递归后重置，为下次排列进行准备
                pos.remove(pos.size() - 1);
            }
        }
    }

    // 返回的 答案
    List<List<Integer>> anss = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        //
        for (int x : nums) {
            cur.add(x);
        }
        // 递归调用
        dfs(0);
        return anss;
    }

    void dfs(int index) {
        if (index == cur.size() - 1) {
            anss.add(new ArrayList<Integer>(cur));
            return;
        }
        // 这一段的回溯 非常的 令人费解
        // shuu: !!!!!!!!!
        for (int i = index; i < cur.size(); i++) {
            Collections.swap(cur, index, i);
            dfs(index + 1);
            // 回溯撤回交换
            Collections.swap(cur, index, i);
        }
    }

}
// @lc code=end
