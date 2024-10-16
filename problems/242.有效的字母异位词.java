/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ans=new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            ans[ch-'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch=t.charAt(i);
            ans[ch-'a']--;
        }
        for (int ians : ans) {
            if(ians!=0){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

