/*
 * @lc app=leetcode.cn id=1822 lang=java
 *
 * [1822] 数组元素积的符号
 */

// @lc code=start
class Solution {
    public int arraySign(int[] nums) {
        int ans=0;
        int fushu=0;
        for (int i : nums) {
            if(i==0){
                return 0;
            }
            else if (i<0) {
                fushu++;
            }
        }
        if(fushu%2==0){
            ans=1;
        }
        else{
            ans=-1;
        }
        return ans;
    }
}
// @lc code=end

