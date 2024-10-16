import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans= new ArrayList<>();
        Map<String , String> letterMap=new HashMap<>();
        letterMap.put("2", "abc");
        letterMap.put("3", "def");
        letterMap.put("4", "ghi");
        letterMap.put("5", "jkl");
        letterMap.put("6", "mno");
        letterMap.put("7", "pqrs");
        letterMap.put("8", "tuv");
        letterMap.put("9", "wxyz");
        if(digits.equals("")){return ans;}
        backTrack(digits,ans,letterMap,0,new StringBuffer() );
        return ans;
    }

    public void backTrack(String digits, List<String> ans, Map<String,
     String> letterMap, int depth,StringBuffer comS){
        if(depth == digits.length()){
            ans.add(comS.toString());
        }
        else{
            String digit=digits.substring(depth, depth+1);
            String toadd=letterMap.get(digit);
            int n=toadd.length();
            for (int i = 0; i < n; i++) {
                comS.append(toadd.charAt(i));
                backTrack(digits, ans, letterMap, depth+1, comS);
                comS.deleteCharAt(depth);
            }
        }

     }
}
// @lc code=end

class test{
    public static void main(String[] args) {
        mySolution solution=new mySolution();
        String iString="23";
        List<String> ans = solution.letterCombinations(iString);
        for (String string : ans) {
            System.out.println(string);
        }
    }
}