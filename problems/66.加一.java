/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        for (int i = digits.length-1; i >=0 ; i--) {
            if(digits[i]==9){
                digits[i]=0;
            }
            else{
                digits[i]++;
                return digits;
            }
        }
        if(digits[0]==0){
            digits=new int[n+1];
            digits[0]=1;
        }
        return digits;
    }
}
// @lc code=end

