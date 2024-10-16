import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int n=nums.length;
        // int[] L=new int[n],R=new int[n];
        // int[] ans=new int[n];
        // Arrays.fill(L, 1);
        // Arrays.fill(R, 1);
        // for (int i = 1,j = n-2; i < n; i++,j--) {
        //     L[i]=L[i-1]*nums[i-1];
        //     R[j]=R[j+1]*nums[j+1];
        // }
        // for (int i = 0; i < n; i++) {
        //     ans[i]=L[i]*R[i];
        // }
        // return ans;
        //双指针的解法
        int n=nums.length;
        int[] ans=new int[n];
        Arrays.fill(ans, 1);
        int L=1,R=1;
        for (int i = 0,j = n-1; i < n; i++,j--) {
            ans[i]*=L;
            ans[j]*=R;
            L*=nums[i];
            R*=nums[j];
        }
        return ans;
    }
}
// @lc code=end

