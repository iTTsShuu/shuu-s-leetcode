/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        s=s.replace("IV", "e");
        s=s.replace("IX", "f");
        s=s.replace("XL", "g");
        s=s.replace("XC", "h");
        s=s.replace("CD", "i");
        s=s.replace("CM", "j");
        int ans=0;
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            ans+=getValue(ch);
        }
        return ans;
    }
    public static int getValue(char s){
        switch(s){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            case 'e':return 4;
            case 'f':return 9;
            case 'g':return 40;
            case 'h':return 90;
            case 'i':return 400;
            case 'j':return 900;
            default:return 0;
        }
    }
}
// @lc code=end

