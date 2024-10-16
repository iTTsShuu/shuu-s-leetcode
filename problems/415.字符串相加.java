/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1, j=num2.length()-1, add=0;
        int x,y,res;
        StringBuffer ans=new StringBuffer();
        while(i>=0||j>=0||add!=0){
             x=i>=0 ? num1.charAt(i)-'0':0;
             y=j>=0 ?num2.charAt(j)-'0':0;
             res=x+y+add;
            ans.append(res%10);
            add=res/10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
// @lc code=end

