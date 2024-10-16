/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length(),m=needle.length();
        char[] s=haystack.toCharArray(),p=needle.toCharArray();
        for(int i=0;i<=n-m;i++){
            int b=0;
            int t=i;
            while(s[t]==p[b]){
                t++;
                b++;
                if(b==m){
                    return i;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

