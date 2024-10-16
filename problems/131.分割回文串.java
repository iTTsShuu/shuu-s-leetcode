/*
 * @lc app=leetcode.cn id=131 lang=java
 *
 * [131] 分割回文串
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {

    // 这里可以预处理判断是否是回文
    List<List<String>> anss = new ArrayList<>();
    List<String> newAns = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return anss;
    }

    void dfs(String s, int depth) {
        if (depth == s.length()) {
            anss.add(new ArrayList<String>(newAns));
            return;
        }
        for (int i = depth; i < s.length(); i++) {
            // 到这里其实已经是全排列的做法了
            // 只要进行是否回文的判断进行筛除即可
            if (isPalindrome(s.substring(depth, i + 1))) {
                newAns.add(s.substring(depth, i + 1));
                dfs(s, i + 1);
                newAns.remove(newAns.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        // 双指针 判断当前串是否是回文串
        char[] chs = s.toCharArray();
        int l = 0, r = chs.length - 1;
        while (l < r) {
            if (chs[r] == chs[l]) {
                r--;
                l++;
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
