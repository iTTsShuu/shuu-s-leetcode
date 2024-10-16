/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int ans=0;
        int last=s.length()-1;
        for(last=s.length()-1;s.charAt(last)==' ';last--){

        }
        for (int i = last; i >=0; i--) {
            if(s.charAt(i)!=' ')                                                                                                                                                                                         {
                ans++;
            }
            else{
                break;
            }
        }
        return ans;
    }
}
// @lc code=end

