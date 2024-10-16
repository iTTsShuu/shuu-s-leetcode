import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    // 构造器
    StringBuilder sb = new StringBuilder();
    // 答案列表
    List<String> anss = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0);
        return anss;

    }

    public void backtrack(int n, int index) {
        if (sb.length() == 2 * n) {
            anss.add(sb.toString());
            return;
        }
        if (index < n) {
            sb.append('(');
            backtrack(n, index + 1);
            sb.append(')');
            // 恢复现场
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(index);
            backtrack(n, index + 1);
        }

    }

    public void backTrack(int n, int left, int right, StringBuffer builder, List<String> ansList) {
        if (right == n && left == n) {
            String temp = new String();
            temp = builder.toString();
            ansList.add(temp);
            return;
        }
        if (left < n) {
            builder.append('(');
            backTrack(n, left + 1, right, builder, ansList);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (left > 0 && right < left) {
            builder.append(')');
            backTrack(n, left, right + 1, builder, ansList);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
// @lc code=end

class temp {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> anss = new ArrayList<>();
        anss = solution.generateParenthesis(3);
        for (String string : anss) {
            System.out.println(string);
        }
    }
}
