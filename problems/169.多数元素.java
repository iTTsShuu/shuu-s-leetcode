import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        // Arrays.sort(nums);
        // int n=nums.length;
        // return nums[n/2];
        int max=nums[0];
        Map<Integer,Integer> numsCount=new HashMap<>();
        for (int num : nums) {
            if(!numsCount.containsKey(num)){
                numsCount.put(num, 1);
            }
            else{
                numsCount.put(num, numsCount.get(num)+1);
            }
            if(numsCount.get(max)<numsCount.get(num)){
                max=num;
            }
        }
        return max;
    }
}
// @lc code=end

