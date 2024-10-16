/*
 * @lc app=leetcode.cn id=1043 lang=java
 *
 * [1043] 分隔数组以得到最大和
 */

// @lc code=start
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] f=new int[n+1];
        for(int i=0;i<n;i++){
            for(int j=i,mx=0;j>i-k&&j>=0;--j){
                mx=Math.max(mx, arr[j]);
                f[i+1]=Math.max(f[i+1],f[j]+(i-j+1)*mx );
            }
        }
        
        
        return f[n];
    }
}
// @lc code=end

