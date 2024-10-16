/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer stoB=new StringBuffer();
        int l=s.length();
        for (int i = 0; i < l; i++) {
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stoB.append(Character.toLowerCase(ch));
            }
        }
        int left=0,right=stoB.length()-1;
        while(left<right){
            if(stoB.charAt(left)!=stoB.charAt(right)){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}
// @lc code=end

