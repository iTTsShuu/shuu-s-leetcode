import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> ch2str=new HashMap<>();
        Map<String,Character> str2ch=new HashMap<>();
        char[] patternCh=pattern.toCharArray();
        String[] words=s.split(" ");
        if(pattern.length()!=words.length){
            return false;
        }
        for (int i = 0; i < patternCh.length; i++) {
            if(ch2str.containsKey(patternCh[i]) && !ch2str.get(patternCh[i]).equals(words[i])){
                return false;
            }
            if(str2ch.containsKey(words[i])&& str2ch.get(words[i])!=patternCh[i]){
                return false;
            }
            //if(str2ch.containsKey())
            ch2str.put(patternCh[i], words[i]);
            str2ch.put(words[i], patternCh[i]);
        }
        return true;
    }
}
// @lc code=end

