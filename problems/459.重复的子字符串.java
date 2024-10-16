/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        char[] str=s.toCharArray();
        int n=s.length();
        boolean ans =false;
        for (int i = 1; i <= str.length/2; i++) {
            if(n%i==0){
                for (int j = i; j < str.length; j++) {
                    if(str[j]!=str[j-i]){
                        ans=false;
                        break;
                    }
                    else{
                        ans=true;
                    }
                }
                if(ans==true){
                    return ans;
                }
            }
        }
        return ans;
    }
}
// @lc code=end

