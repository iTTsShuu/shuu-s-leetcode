import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Character> reflect=new HashMap<>();
        Map<Character,Character> sreflect=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character sc=s.charAt(i);
            Character tc=t.charAt(i);
            if(!sreflect.containsKey(sc)){
                sreflect.put(sc, tc);
            }
            else{
                if(tc!=sreflect.get(sc)){
                    return false;
                }
            }
            if(!reflect.containsKey(tc)){
                reflect.put(tc, sc);
            }
            else{
                if(sc!=reflect.get(tc)){
                    return false;
                }
            }
        }
        return true;
    }
}
// @lc code=end

