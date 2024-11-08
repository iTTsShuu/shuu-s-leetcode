/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        int l = 0, r = 0;
        int m = s.length();
        // hash表 计数 'a'-'Z' 统计大写和小写 'a'-'z' 'A'-'Z'
        int[] cntS = new int[128];
        int[] cntT = new int[128];
        // 计数t
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }
        // 这里依靠初始值判断是否找到covered
        // int ansL = -1, ansR = m;
        // 或者多用一个flag来标识是否找到
        int ansL = 0, ansR = m - 1;
        boolean flag = false;
        while (r < m) {
            char ch = s.charAt(r);
            cntS[ch]++; // 统计当前字符到窗口
            while (isCovered(cntS, cntT)) { // cover时不断移动左端点
                flag = true;
                // 维护最短左右节点
                if (ansR - ansL > r - l) {
                    ansL = l;
                    ansR = r;
                }
                cntS[s.charAt(l)]--;
                l++;
            }
            r++;
        }
        return flag ? s.substring(ansL, ansR + 1) : "";
    }

    // 比较串是否涵盖的函数
    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
