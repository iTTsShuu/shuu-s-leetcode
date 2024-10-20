import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {

    List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrack(new ArrayList<>(), n, k, 0, 0);
        return ansList;
    }

    // shuu: last是添加数的位置下标 depth代表当前长度
    public void backTrack(List<Integer> curCom, int n, int k, int depth, int last) {
        if (depth == k) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(curCom);
            ansList.add(temp);
        } else {
            for (int i = last; i < n; i++) {
                curCom.add(i + 1);
                backTrack(curCom, n, k, depth + 1, i + 1);
                curCom.remove(depth);
            }
        }
    }
}
// @lc code=end

class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.combine(4, 2);
    }
}
