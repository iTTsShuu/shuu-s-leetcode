import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ran=ransomNote.toCharArray();
        char[] maga=magazine.toCharArray();
        if(ran.length>maga.length){
            return false;
        }
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < ran.length; i++) {
            Character ch=ran[i];
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch, 1);
            }
        }
        for (int i = 0; i < maga.length; i++) {
            Character ch=maga[i];
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
            }
        }
        for (Map.Entry<Character,Integer> imap : map.entrySet()) {
            Integer val=imap.getValue();
            if(val>0){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

