/*
 * @lc app=leetcode.cn id=389 lang=java
 *
 * [389] 找不同
 */

// @lc code=start
class Solution {
    public char findTheDifference(String s, String t) {
        // int[] aph=new int[26];
        // for (int i = 0; i < s.length(); i++) {
        //     char ch=s.charAt(i);
        //     aph[ch-'a']++;
        // }
        // for (int i = 0; i < t.length(); i++) {
        //     char ch=t.charAt(i);
        //     aph[ch-'a']--;
        //     if(aph[ch-'a']<0){
        //         return ch;
        //     }
        // }
        // return ' ';
        // int ans=0;
        // for (int i = 0; i < s.length(); i++) {
        //     char ch=s.charAt(i);
        //     ans+=ch;
        // }
        // int anss=0;
        // for (int i = 0; i < t.length(); i++) {
        //     char ch=t.charAt(i);
        //     anss+=ch;
        // }
        // return (char)(anss-ans);
        int ans=0;
        for (int i = 0; i < s.length(); i++) {
            ans^=s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            ans^=t.charAt(i);
        }
        return (char)ans;
    }
}
// @lc code=end

