import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=2208 lang=java
 *
 * [2208] 将数组和减半的最少操作次数
 */

// @lc code=start
class Solution {
    public int halveArray(int[] nums) {
        int ans;
        int sum=0;
        for (int i : nums) {
            sum+=i;
        }
        sum/=2;
        Arrays.sort(nums,(x,y)->y-x);
        int i=0;
        while(sum!=0){
            if(nums[i]/2<=sum){
                sum-=nums[0/2];
                nums[0]/=2;
                Arrays.sort(nums,(x,y)->y-x);
                ans++;
            }
            else{
                i++;
            }
        }
    }
}
// @lc code=end

