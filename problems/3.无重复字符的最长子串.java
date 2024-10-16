import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start=0,end=0;
        int maxLen=0;
        //创建字典来记录出现过的字符和其第一次出现的位置
        Map<Character,Integer> sawChar=new HashMap<>();
        while(end<s.length()){
            Character ch=s.charAt(end);
            if(sawChar.containsKey(ch)){
                if(sawChar.get(ch)>=start){
                    start=sawChar.get(ch)+1;
                }
            }
            sawChar.put(ch, end);
            maxLen=Math.max(maxLen, end-start+1);
            end++;
        }
        return maxLen;
    }
}
// @lc code=end
class MaxLentest{
    public static void main(String[] args) {
        mySolution solution=new mySolution();
        String string="abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(string)); 
    }
}

