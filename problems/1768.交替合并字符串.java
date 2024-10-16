/*
 * @lc app=leetcode.cn id=1768 lang=java
 *
 * [1768] 交替合并字符串
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans=new StringBuilder();
        for (int i = 0,j=0; i < word1.length()|| j < word2.length(); i++,j++) {
            if(i<word1.length())
                ans.append(word1.charAt(i));
            if (j<word2.length())
                ans.append(word2.charAt(j));
        }
        return ans.toString();
    }
}
// @lc code=end

