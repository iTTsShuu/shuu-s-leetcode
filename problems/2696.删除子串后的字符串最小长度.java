/*
 * @lc app=leetcode.cn id=2696 lang=java
 *
 * [2696] 删除子串后的字符串最小长度
 */

// @lc code=start
class Solution {

    public int minLength(String s) {
        // shuu:回过头来发现我递归了构式！！！！
        // if (!s.contains("AB") && !s.contains("CD")) {
        // return s.length();
        // }
        // if (s.contains("AB")) {
        // s = s.replaceFirst("AB", "");
        // }
        // if (s.contains("CD")) {
        // s = s.replaceFirst("CD", "");
        // }
        // minLength(s);
        // return s.length();

        while (s.contains("AB") || s.contains("CD")) {
            s = s.replaceAll("AB", "");
            s = s.replaceAll("CD", "");
        }
        return s.length();
    }
}

// @lc code=end
class test2696 {
    public static void main(String[] args) {
        Solution2696 solution2696 = new Solution2696();
        String s = "ABFCACDB";
        System.out.println(solution2696.minLength(s));
    }
}