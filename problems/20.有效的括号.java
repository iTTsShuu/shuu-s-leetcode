import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        if(n%2==1||n==0){
            return false;
        }
        Map<Character,Character> mapofP=new HashMap<Character,Character>();
        mapofP.put('}', '{');
        mapofP.put(')', '(');
        mapofP.put(']', '[');
        Stack<Character> st=new Stack<>();
        for (int i = 0; i < n; i++) {
            if(mapofP.containsKey(s.charAt(i))){
                if(st.empty()||st.peek()!=mapofP.get(s.charAt(i))){
                    return false;
                }
                else{
                    st.pop();
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return st.isEmpty();
    }
}
// @lc code=end

